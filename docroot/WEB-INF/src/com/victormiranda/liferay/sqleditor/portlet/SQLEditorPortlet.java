package com.victormiranda.liferay.sqleditor.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.CSVUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.dynamicdatamapping.storage.FieldConstants;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.victormiranda.liferay.sqleditor.beans.ExecutionResult;
import com.victormiranda.liferay.sqleditor.sql.SQLEngine;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

		if (EXECUTE_SQL_RESOURCE_ID.equals(resourceId)) {
			String query = ParamUtil.getString(request, "query");

			int start = ParamUtil.getInteger(request, "start", -1);
			int length = ParamUtil.getInteger(request, "length", -1);

			executeQuery(response, query, start, length);
		}
		else if (EXPORT_CSV_RESOURCE_ID.equals(resourceId)) {
			String query = ParamUtil.getString(request, "query");

			generateCSV(response, query);
		}
	}

	private JSONObject executeQuery(ResourceResponse response,
			String query, int start, int length) throws IOException {

		JSONObject result;

		try {
			result = JSONFactoryUtil.createJSONObject();

			ExecutionResult executionResult =
				SQLEngine.getInstance().runSQL(query,start,length);

			result.put("results", executionResult.getResults());
			result.put("numElements", executionResult.getNumElements());

			response.getWriter().write(result.toString());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		}


		return result;
	}

	private void generateCSV(ResourceResponse response, String query)
			throws IOException {

		response.setContentType("text/csv");

		response.setProperty(
			HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=query.csv");

		StringBundler sb = new StringBundler();

		try {
			ResultSet rs = SQLEngine.getInstance().executeQuery(query);

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			List<String> columnNames = new ArrayList<String>(columnCount);

			for (int i = 0; i < columnCount; i++) {
				String colName = rsmd.getColumnLabel(i + 1);
				columnNames.add(colName);
				sb.append(colName);
				sb.append(StringPool.COMMA);
			}
			sb.append(StringPool.NEW_LINE);

			while (rs.next()) {
				for (String columnName: columnNames) {

					sb.append(rs.getObject(columnName));

					sb.append(StringPool.COMMA);

				}
				sb.append(StringPool.NEW_LINE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.getWriter().write(sb.toString());
	}

	private Log _log = LogFactoryUtil.getLog(SQLEditorPortlet.class.getName());

	private static final String EXECUTE_SQL_RESOURCE_ID = "executeQuery";
	private static final String EXPORT_CSV_RESOURCE_ID = "exportCSV";
}
