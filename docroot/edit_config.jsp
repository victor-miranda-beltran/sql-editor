<%@ page import="javax.portlet.PortletPreferences" %>
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

<portlet:actionURL name="savePreferences" var="savePreferencesURL" />

<portlet:renderURL  var="returnToEditorURL" portletMode="view" >
</portlet:renderURL>

<%
	PortletPreferences preferences = renderRequest.getPreferences();

	int fontSize = Integer.valueOf(preferences.getValue("fontSize","10"));

	int pageSize = Integer.valueOf(preferences.getValue("pageSize","10"));

	boolean paginate = Boolean.valueOf(preferences.getValue("paginate","true"));

%>
<aui:form class="form-horizontal" name='<portlet:namespace />fmPrefs'
		  action="<%=savePreferencesURL%>" method="POST">

	<fieldset>

		<legend>SQL Editor preferences</legend>

		<div class="control-group">
			<label class="control-label" for="fontSize">Font size</label>
			<div class="controls">
				<select id="fontSize" name="fontSize" class="input-small">
					<%  for (int i = 10; i <=  28; i += 2) {  %>
						<option	value="<%=i%>"	<%= i == fontSize ? "selected" : "" %> >
							<%=i%>
						</option>
					<% } %>
				</select>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="pagination">Pagination</label>
			<div class="controls">
				<div class="input-prepend">
					<span class="add-on">
						<label class="checkbox">
							<input id="pagination" name="pagination" type="checkbox" <%=paginate?"checked":"" %>>
						</label>
					</span>
					<input id="pageSize" name="pageSize" class="input-mini" type="text" value="<%=pageSize%>" placeholder="page size">
				</div>

			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="savePreferences"></label>
			<div class="controls">
			<aui:button value="save" cssClass="btn" onClick='<%= renderResponse.getNamespace() + "submitForm()" %>' />
				<aui:button id="cancelPreferences" href="<%=returnToEditorURL%>" value="Return" cssClass="btn" />
			</div>
		</div>

	</fieldset>
</aui:form>

<aui:script>
	function <portlet:namespace />submitForm() {
		document.forms[0].submit();
	}
</aui:script>