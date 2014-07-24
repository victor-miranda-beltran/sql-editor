package com.victormiranda.liferay.sqleditor.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.victormiranda.liferay.sqleditor.beans.ExecutionResult;
import com.victormiranda.liferay.sqleditor.sql.SQLEngine;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Victor Miranda
 */
public class SQLEditorPortlet extends MVCPortlet {


	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		_log.debug("doView");

		try {
			JSONArray tablesObject = SQLEngine.getInstance().getTables();

			renderRequest.setAttribute("tables", tablesObject);
		} catch (SQLException e) {
			_log.error("Error getting table data ", e);
		}

		include(viewTemplate, renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException {

		String resourceId = request.getResourceID();

		_log.debug("serveResource with resourceId: " + resourceId);

		JSONObject result = JSONFactoryUtil.createJSONObject();

		if (EXECUTE_SQL_RESOURCE_ID.equals(resourceId)) {
			String query = ParamUtil.getString(request, "query");

			int start = ParamUtil.getInteger(request, "start", -1);
			int length = ParamUtil.getInteger(request, "length", -1);

			result = executeQuery(query, start, length);
		}

		response.getWriter().write(result.toString());
	}

	private JSONObject executeQuery(String query, int start, int length) {
		JSONObject result;

		try {
			result = JSONFactoryUtil.createJSONObject();

			ExecutionResult executionResult =
				SQLEngine.getInstance().runSQL(query,start,length);

			result.put("results", executionResult.getResults());
			result.put("numElements", executionResult.getNumElements());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}

		return result;
	}

	private Log _log = LogFactoryUtil.getLog(SQLEditorPortlet.class.getName());

	private static final String EXECUTE_SQL_RESOURCE_ID = "executeQuery";
}
