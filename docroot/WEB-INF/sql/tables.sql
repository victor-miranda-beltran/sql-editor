create table Snippets_SnippetEntry (
	uuid_ VARCHAR(75) null,
	snippetId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	code_ STRING null
);