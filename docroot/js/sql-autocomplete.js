YUI.add('sql-autocomplete', function (Y, NAME) {

	var Lang = Y.Lang,
		DOT = '.',
		STR_EMPTY = '',
		SQL_WORDS = ['SELECT','FROM','WHERE','INSERT','UPDATE','DELETE','JOIN','AND','OR','ALTER','UNION','DISTINCT','COUNT','NULL','NOT'],

		NAME = 'sql-autocomplete';

	var SQL = Y.Component.create({
		NAME: NAME,

		NS: NAME,

		ATTRS: {
			host: {
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

				var words = content.split(/[,\/ -]/);

				content = words[words.length -1];

				console.log('getMatch ' + content);

				match = {
					content: content,
					start: matchIndex
				};

				return match;
			},

			getResults: function(match, callbackSuccess, callbackError) {
				var instance = this;

				var type = match.type;

				var tableMatches = instance._getTableMatches(match.content) || [];
				var keywordMatches = instance._getKeywordMatches(match.content) || [];
				var fieldMatches = instance._getFieldMatches(match.content) || [];

				var matches = keywordMatches.concat(tableMatches.concat(fieldMatches));

				callbackSuccess(matches);
			},

			getSuggestion: function(match, selectedSuggestion) {
				var instance = this;

				var result = selectedSuggestion || STR_EMPTY;

				var contentParts = match.content.trim().split(DOT);
				var autocompleting = contentParts[contentParts.length-1];

				if (selectedSuggestion) {
					if (autocompleting && selectedSuggestion.toLowerCase().indexOf(autocompleting.toLowerCase()) === 0) {
						result = selectedSuggestion.substring(autocompleting.length);

						var lastLetter = match.content.charAt(match.content.length-1);

						if (lastLetter !== lastLetter.toUpperCase()) {
							result = result.toLowerCase();
						}
					}
				}

				return match.content+result;
			},

			_getKeywordMatches: function(content) {
				var instance = this;

				var matches = [];

				var contentToSQLWords = content.trim();

				if (contentToSQLWords.length > 0) {
					for (var i in SQL_WORDS) {
						if (SQL_WORDS[i].toLowerCase().indexOf(contentToSQLWords.toLowerCase()) == 0) {
							matches.push(SQL_WORDS[i]);
						}
					}
				}

				return matches;
			},

			_getFieldMatches: function(content) {
				var instance = this;

				var matches = [];

				var contentParts = content.split(DOT);

				if (contentParts.length == 2) {
					var editorContent =
						instance.get('host').get('host').editor.session.getValue();

					var resTables = instance._getTablesWithAliases(
						contentParts[0].trim(), editorContent);

						for (var i in resTables) {
							for (var j in resTables[i].fields) {
								var f = resTables[i].fields[j];
								if (f.label.toLowerCase().indexOf(
										contentParts[1].toLowerCase()) == 0) {
									matches.push(f.label);
								}
							}
						}
				}

				return matches;
			},

			_getTableMatches: function(content) {
				var instance = this;

				if (!content || content.lengt === 0) {
					return;
				}

				var matches = [];

				var tables = instance.get('schema');

				content = content.trim();

				for (var i = 0 in tables) {
					if (tables[i].table.toLowerCase().indexOf(content.toLowerCase()) === 0) {
						matches.push(tables[i].table);
					}
				}

				return matches;
			},

			_getTablesWithAliases: function(str, editorContent) {
				var instance = this;

				var res = [];

				if (str === undefined || str.length === 0) {
					return;
				}

				str = str.trim();

				var tables = instance.get('schema');

				var tablesWithAliases = tables;

				var alias = instance._getAliases(str, editorContent);

				if (alias) {
					str = alias;
				}

				for(var i in tables) {
					if (tables[i].table.toLowerCase() === str.toLowerCase()) {
						res.push(tables[i]);
					}
				}

				return res;
			},

			_getAliases: function(alias, sql) {
				var instance = this;

				var words = sql.split(/[, \t\n]/);

				var tables = instance.get('schema');

				for (var i = 2 in words) {
					if (words[i] === alias) {
						//check if previous word is a table
						for (var j in tables) {
							if (tables[j].table.toLowerCase() === words[i-1].toLowerCase()) {
								return tables[j].table;
							}
						}
					}
				}

				return;
			}

		}
	});

	Y.AceEditor.AutoCompleteSQL = SQL;

}, '0.0.1', {"requires": ["aui-ace-autocomplete-base", "aui-search-tst"]});
