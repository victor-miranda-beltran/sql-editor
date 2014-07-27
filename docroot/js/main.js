AUI.add('sql-editor', function (Y) {

	var EMPTY_STR = '',
		PAGE_SIZE = 10,
		_sqlProcessor = new Y.AceEditor.AutoCompleteSQL();

	/**
	 *  SQL Editor widget
	 */
	Y.SQLEditor = Y.Base.create('sql-editor', Y.Widget, [], {

		initializer: function(config) {
			var instance = this;

			var tables = instance.get('tables');

			var tablesTree = new Y.TreeView({
				srcNode: '.sql-editor .tree',
				children: [
					{
						children: tables,
						expanded: true,
						label: 'Portal tables ('+ tables.length +')'
					}
				],
				type: 'file'
			});

			instance.set('tablesTree', tablesTree);

			var aceEditor = new Y.AceEditor({
				boundingBox: '.sql-editor .sql-box',
				value: 'SELECT \n\t\t*\n\tFROM\n\t\tUser_\n\tWHERE\n\t\tUser_.userId != 3',
				width: '100%',
				height: '100%',
				plugins: [{
					fn: Y.Plugin.AceAutoComplete,
					cfg: {
						processor: _sqlProcessor,
						render: true,
						visible: false,
						zIndex: 1000
					}
				}]
			});

			_sqlProcessor.set('schema', tables);

			aceEditor.getEditor().setFontSize(22);

			instance.set('aceEditor', aceEditor);

			var paginator = new Y.Pagination(
				{
					after: {
						changeRequest: function(event) {
							var start = (event.state.page-1) * PAGE_SIZE;
							var sql = instance.get('latestQuery');

							instance._executeQuery(sql, start, PAGE_SIZE);
						}
					},
					boundingBox: '.paginator',
					offset: 1,
					page: 0,
					strings: {
						next: '»',
						prev: '«'
					}
				}
			);

			instance.set('paginator', paginator);
		},

		bindUI: function() {
			var instance = this;

			var aceEditor = instance.get('aceEditor');

			aceEditor.getEditor().commands.addCommand({
				name: 'executeScript',
				bindKey: {
					win: 'Ctrl-Enter',
					mac: 'Command-Enter',
					sender: 'editor|cli'
				},
				exec: function(env, args, request) {
					var sql = aceEditor.get('value');
					instance._executeQuery(sql);
				}
			});

			var executeQueryButton = Y.one('.sql-editor .execute-query');

			executeQueryButton.on('click', function () {
				var sql = instance.get('aceEditor').get('value');
				instance._executeQuery(sql);
			});

			var loadSnippetButton = Y.one('.sql-editor .load-snippet');

			loadSnippetButton.on('click', function () {
				instance._openLoadSnippetDialog();
			});

			var saveSnippetButton = Y.one('.sql-editor .save-snippet');

			saveSnippetButton.on('click', function () {
				var sql = instance.get('aceEditor').get('value');

				instance._openSaveSnippetDialog(sql);
			});

			var exportCSVButton = Y.one('.sql-editor .export-csv');

			exportCSVButton.on('click', function () {
				var sql = instance.get('latestQuery');

				instance._exportCSV(sql);
			});

			var filterInput = Y.one('.sql-editor .input-search-table');

			filterInput.on('keyup', function (e) {
				instance.filterObjectTree(e.currentTarget.val());
			});

			Y.on('windowresize', instance._adjustSize);
		},

		renderUI: function() {
			var instance = this;

			instance.get('tablesTree').render();
			instance.get('aceEditor').render();

			instance._adjustSize();
			Y.one('.sql-editor .export-csv').set('disabled', true);

			Y.one('.sql-editor').show();
		},

		_executeQuery: function(sql, start, length) {
			var instance = this;

			var url = instance.get('executeQueryActionURL');

			if (instance.get('blocked') === true) {
				return;
			}

			instance.set('latestQuery', sql);
			Y.one('.sql-editor .export-csv').set('disabled', false);

			Y.one('.sql-editor .execute-query').set('disabled', true);
			instance.set('blocked', true);

			Y.io.request(url, {
				data: {
					query: sql,
					start: start,
					length: length
				},
				on:	{
					success : function (id,res) {
						var data = JSON.parse(this.get('responseData'));

						var rs = data.results;
						var numElements = data.numElements;

						instance._showResults(numElements, rs);
					},
					complete : function() {
						instance.set('blocked', false);

						Y.one('.sql-editor .execute-query').set(
							'disabled', false);
					}
				}
			});
		},

		_exportCSV: function(sql) {
			var instance = this;

			var resourceURL= Liferay.PortletURL.createResourceURL();
			resourceURL.setParameter("query", sql);
			resourceURL.setResourceId("exportCSV");
			resourceURL.setPortletId("sqleditor_WAR_sqleditorportlet");

			window.location.href = resourceURL.toString();
		},

		filterObjectTree: function(filter) {
			var instance = this;

			var tables = instance.get('tables');

			for(var i in tables) {
				var label = tables[i].label.toLowerCase();
				var tableId = tables[i].id;

				if (label.indexOf(filter.toLowerCase()) != -1) {
					Y.one('#' + tableId).show();
				}
				else {
					Y.one('#' + tableId).hide();
				}
			}
		},

		_openLoadSnippetDialog : function() {
			var instance = this;

			var renderURL = Liferay.PortletURL.createRenderURL();
			renderURL.setParameter("jspPage", "/pages/load-snippet.jsp");
			renderURL.setWindowState("pop_up");
			renderURL.setPortletId("sqleditor_WAR_sqleditorportlet");

			Liferay.Util.openWindow(
				{
					dialog: {
						width: 820,
						height: 'auto'
					},
					id: '<portlet:namespace />LoadSnippetDialog',
					title: 'Load snippet',
					uri: renderURL.toString()
				}
			);
		},

		_openSaveSnippetDialog : function(sql) {
			var instance = this;

			var renderURL = Liferay.PortletURL.createRenderURL();
			renderURL.setParameter("query", sql);
			renderURL.setParameter("jspPage", "/pages/save-snippet.jsp");
			renderURL.setWindowState("pop_up");
			renderURL.setPortletId("sqleditor_WAR_sqleditorportlet");

			Liferay.Util.openWindow(
				{
					dialog: {
						width: 820,
						height: 'auto'
					},
					id: '<portlet:namespace />SaveSnippetDialog',
					title: 'Save sql as snippet',
					uri: renderURL.toString()
				}
			);

		},

		_showResults : function(numElements, rs) {

			var instance = this;

			var resultDT = instance.get('resultDT');

			if(resultDT) {
				resultDT.hide();
				Y.one('.sql-editor .results').html(EMPTY_STR);
			}

			resultDT = new Y.DataTable(
				{
					scrollable: "xy",
					width: '100%',
					destroyOnHide:true
				}
			);

			instance.set('resultDT', resultDT);

			if (rs[0]) {
				var currentColumnSet = Object.keys(rs[0]);

				resultDT.set('columnset', currentColumnSet);
				resultDT.set('recordset', rs);
			}

			resultDT.render('.results');

			var resultsDiv = Y.one('.sql-editor .results');

			var aceDiv = Y.one('.sql-editor .sql-box');

			resultsDiv.setStyle('height', 'auto');

			var resultsSize = resultsDiv.get('offsetHeight');

			aceDiv.setStyle('bottom', resultsSize);
			aceDiv.setStyle('height', 'auto');

			instance.get('aceEditor').getEditor().resize();

			instance.get('paginator').set('total',(numElements / PAGE_SIZE) + 1);

			instance.get('paginator').render();

		},

		_adjustSize : function() {
			var instance = this;

			var winHeight = Y.one("body").get("winHeight");

			Y.one('.objects-tree').setStyle('height', winHeight -220);

			Y.one('.editor').setStyle('height', winHeight -220);

			Y.one('.sql-box').setStyle('height', winHeight -220);

			instance.get('aceEditor').getEditor().resize();
		}

	},{
		ATTRS: {
			blocked: {
				value: false
			},
			editor: {
				value: undefined
			},
			tables: {
				value: undefined
			},
			tablesTree: {
				value: undefined
			},
			aceEditor: {
				value: undefined
			},
			resultDT: {
				value: undefined
			},
			paginator: {
				value: undefined
			},
			executeQueryActionURL: {
				value: undefined
			},
			latestQuery : {
				value: undefined
			}
		}
	});


},'0.0.1', {
	requires:
		['base','event','aui-tree-view','aui-ace-editor','io','aui-datatable','aui-pagination','aui-ace-autocomplete-plugin','sql-autocomplete','liferay-portlet-url','aui-dialog'] }
);
