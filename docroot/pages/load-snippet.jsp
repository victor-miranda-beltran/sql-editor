<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page
		import="com.victormiranda.liferay.sqleditor.service.SnippetEntryLocalServiceUtil" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
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
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />



<%
	PortletURL portletURL = renderResponse.createRenderURL();

	String currentURL = PortalUtil.getCurrentURL(request);
	int totalSnippets = SnippetEntryLocalServiceUtil.getSnippetEntriesCount();
%>

<liferay-ui:search-container
		delta="10"
		headerNames="create-date,name,code"
		iteratorURL="<%= portletURL %>"
		total="<%= totalSnippets %>"
		>
	<liferay-ui:search-container-results
			results="<%= SnippetEntryLocalServiceUtil.getSnippetEntries(searchContainer.getStart(), searchContainer.getEnd()) %>"
			/>

	<liferay-ui:search-container-row
			className="com.victormiranda.liferay.sqleditor.model.SnippetEntry"
			escapedModel="<%= true %>"
			keyProperty="snippetId"
			modelVar="curSnippet"
			>

		<liferay-ui:search-container-column-text
				buffer="buffer"
				name="create-date"
				>

			<%
				buffer.append(curSnippet.getCreateDate());
			%>

		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
				name="name"
				property="name"
				/>

		<liferay-ui:search-container-column-text
				name="code"
				property="code"
				/>

		<liferay-ui:search-container-column-text>

			<%
				Map<String, Object> data = new HashMap<String, Object>();

				data.put("code", curSnippet.getCode());
			%>

			<aui:button cssClass="select-snippet" data="<%= data %>" value="Load snippet" />
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>


<aui:script use="aui-base,aui-dialog,aui-io-request">

	var selectSnippetBtn = A.all(".select-snippet");

	selectSnippetBtn.on('click',  function(e) {
		var code = e.currentTarget.getAttribute('data-code');
		Liferay.Util.getOpener().sqlEditor.get('aceEditor').getSession().setValue(code);
		Liferay.Util.getWindow().destroy();
	});

</aui:script>
