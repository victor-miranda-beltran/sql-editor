AUI.add('sql-editor', function (Y) {

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
					}
				}
			});
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
			executeQueryActionURL: {
				value: undefined
			}
		}
	});


},'0.0.1', {
	requires:
		['base','event','aui-tree-view','aui-ace-editor','io'] }
);
