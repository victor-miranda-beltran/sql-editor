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
		},

		renderUI: function() {
			var instance = this;

			instance.get('tablesTree').render();
			instance.get('aceEditor').render();
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
			}
		}
	});


},'0.0.1', {
	requires:
		['base','event','aui-tree-view','aui-ace-editor'] }
);
