<%
/**
 * Copyright (c) 2014-present Victor Miranda. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<div class="sql-editor hide">

	<div class="container-fluid">

		<div class="left-box span3">

			<div class="form-group row">
				<div>
					<input type="text" placeholder="Search..." class="form-control input-search-table" >
					<span class="glyphicon glyphicon-user"></span>
				</div>
			</div>

			<div class="objects-tree row">
				<div class="tree"></div>
			</div>

		</div>

		<div class="main span9">

			<div class="toolbar row">
				<aui:button-row>
					<aui:button icon="icon-play" value="Execute query" cssClass="btn btn-primary execute-query"></aui:button>
					<aui:button icon="icon-play" value="Export CSV" cssClass="btn btn-primary export-csv"></aui:button>
				</aui:button-row>
			</div>

			<div class="editor row">
				<div class="sql-box">

				</div>

				<div class="results">

				</div>
			</div>

			<div class="paginator pull-right"></div>

		</div>

	</div>

</div>

<script type="application/javascript">

	AUI({debug: true}).use('base','event','io','json-parse','sql-editor',function(Y) {

		var sqlEditor = new Y.SQLEditor({
			tables: JSON.parse('${tables}'),
			executeQueryActionURL: '<portlet:resourceURL id="executeQuery"></portlet:resourceURL>',
			exportCSVActionURL: '<portlet:resourceURL id="exportCSV"></portlet:resourceURL>'
		});

		sqlEditor.render();
	});

</script>