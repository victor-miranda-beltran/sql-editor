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

<portlet:defineObjects />

<div class="container">

	<div class="row">

		<aui:form>
			<aui:fieldset>

				<aui:input name="snippet-name" type="text" autofocus="autofocus" placeholder="snippet name..." />
				<aui:input name="snippet-code" type="textarea" rows="19"  cols="89" value="<%= query %>" />

			</aui:fieldset>

			<div class="pull-right">
				<aui:button value="Save"  class="btn" />
				<aui:button value="Cancel" class="btn" />
			</div>

		</aui:form>

	</div>


</div>


<script type="application/javascript">



</script>