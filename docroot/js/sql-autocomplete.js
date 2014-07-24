YUI.add('sql-autocomplete', function (Y, NAME) {

	var Lang = Y.Lang,
		DOT = '.',
		STR_EMPTY = '',

		NAME = 'sql-autocomplete';

	var SQL = Y.Component.create({
		NAME: NAME,

		NS: NAME,

		ATTRS: {
			host: {
				validator: Lang.isObject
			},

			variables: {
				validator: Lang.isObject
			},

			schema: {
				setter: function(val) {
					var aux = [];
					for (var i in val) {
						aux.push({'table':val[i].label,fields: val[i].children});
					}
					return aux;
				}
			}
		},

		EXTENDS: Y.Base,

		prototype: {
			initializer: function(config) {
				var instance = this;
			},

			getMatch: function(content) {

				var instance = this;
				var match;

				var matchIndex;

				if ((matchIndex = content.lastIndexOf(DOT)) >= 0) {
					//FIXME, it has to be the last whitespace UNTIL THE CURSOR
					var lastWhiteSpace = content.lastIndexOf(' ');
					content = content.substring(lastWhiteSpace+1);

					match = {
						content: content,
						start: matchIndex
					};
				}

				return match;
			},

			getResults: function(match, callbackSuccess, callbackError) {
				var instance = this;

				var type = match.type;

				var matches = instance._getVariableMatches(match.content);

				callbackSuccess(matches);
			},

			getSuggestion: function(match, selectedSuggestion) {
				var instance = this;

				var result = selectedSuggestion || STR_EMPTY;

				var contentParts = match.content.split(DOT);
				var fieldName = contentParts[contentParts.length-1];

				if (selectedSuggestion) {
					if (fieldName && selectedSuggestion.indexOf(fieldName) === 0) {

						result = selectedSuggestion.substring(fieldName.length);
					}
				}

				return match.content+result;
			},


			_getVariableMatches: function(content) {
				var instance = this;

				var contentParts = content.split(DOT);

				var matches = [];

				var tables = instance.get('schema');

				for (var i in tables) {
					if (tables[i].table.toLowerCase() == contentParts[0].toLowerCase()) {
						for (var j in tables[i].fields) {
							var f = tables[i].fields[j];
							if (f.label.toLowerCase().indexOf(contentParts[1].toLowerCase())==0) {
								matches.push(f.label);
							}
						}
					}
				}

				return matches;
			}
		}
	});

	Y.AceEditor.AutoCompleteSQL = SQL;

}, '0.0.1', {"requires": ["aui-ace-autocomplete-base", "aui-search-tst"]});
