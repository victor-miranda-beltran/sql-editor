<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
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

<%
	String query = ParamUtil.getString(request,"query");
%>

<portlet:actionURL var="saveSnippetURL" name="saveSnippet">
</portlet:actionURL>

<portlet:defineObjects />

<div class="container">

	<div class="row">

		<aui:form>
			<aui:fieldset>

				<aui:input name="snippet-name" id="snippet-name" type="text" autofocus="autofocus" placeholder="snippet name..." />
				<aui:input name="snippet-code" id="snippet-code" type="textarea" rows="19"  cols="89" value="<%= query %>" />

			</aui:fieldset>

			<div class="pull-right">
				<aui:button value="Save" id='<%= renderResponse.getNamespace() + "SaveSnippetBtn" %>' class="btn" />
				<aui:button value="Cancel" id='<%= renderResponse.getNamespace() + "CloseSnippetBtn" %>' class="btn" />
			</div>

		</aui:form>

	</div>


</div>

<aui:script use="aui-base,aui-dialog,aui-io-request">

	var saveSnippetBtn = A.one("#<portlet:namespace />SaveSnippetBtn");

	saveSnippetBtn.on('click',  function() {
		A.io.request('${saveSnippetURL}',
		{
			method: 'post',
			data: {
				'snippet-name' : A.one('#<portlet:namespace />snippet-name').val(),
				'snippet-code' : A.one('#<portlet:namespace />snippet-code').val()
			},
			on:
			{
				success: function() {
					Liferay.Util.getWindow().destroy();
				}
			}
		});
	});

	var closeSnippetWindow = A.one("#<portlet:namespace />CloseSnippetBtn");

	closeSnippetWindow.on('click',function() {
		Liferay.Util.getWindow().destroy();
	});

</aui:script>