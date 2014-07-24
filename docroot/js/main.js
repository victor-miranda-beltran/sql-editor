AUI.add('sql-editor', function (Y) {

	/**
	 *  SQL Editor widget
	 */
	Y.SQLEditor = Y.Base.create('sql-editor', Y.Widget, [], {

		initializer: function(config) {
			var instance = this;
		},

		bindUI: function() {
			var instance = this;
		},

		renderUI: function() {
			var instance = this;

		}

	},{
		ATTRS: {
			editor: {
				value: undefined
			}
		}
	});


},'0.0.1', {
	requires:
		['base','event','aui-tree-view'] }
);
