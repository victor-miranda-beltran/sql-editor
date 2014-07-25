create index IX_1561C964 on Snippets_SnippetEntry (companyId);
create index IX_8D17ECF0 on Snippets_SnippetEntry (uuid_);
create index IX_701A138 on Snippets_SnippetEntry (uuid_, companyId);
create unique index IX_987115BA on Snippets_SnippetEntry (uuid_, groupId);