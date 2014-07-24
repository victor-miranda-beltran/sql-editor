AUI.add('sql-editor', function (Y) {

	var EMPTY_STR = '';

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
				value: 'select * from User_;',
				width: '100%',
				height: '100%'
			});

			aceEditor.getEditor().setFontSize(22);

			instance.set('aceEditor', aceEditor);
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

			var filterInput = Y.one('.sql-editor .input-search-table');

			filterInput.on('keyup', function (e) {
				instance.filterObjectTree(e.currentTarget.val());
			});
		},

		renderUI: function() {
			var instance = this;

			instance.get('tablesTree').render();
			instance.get('aceEditor').render();
		},

		_executeQuery: function(sql, start, length) {
			var instance = this;

			var url = instance.get('executeQueryActionURL');

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
						var elements = data.elements;

						instance._showResults(elements, rs);
					}
				}
			});
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

		_showResults : function(elements, rs) {

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
		}

	},{
		ATTRS: {
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
			executeQueryActionURL: {
				value: undefined
			}
		}
	});


},'0.0.1', {
	requires:
		['base','event','aui-tree-view','aui-ace-editor','io','aui-datatable'] }
);
