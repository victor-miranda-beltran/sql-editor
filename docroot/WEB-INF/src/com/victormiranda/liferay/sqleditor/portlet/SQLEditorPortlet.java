package com.victormiranda.liferay.sqleditor.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.victormiranda.liferay.sqleditor.beans.ExecutionResult;
import com.victormiranda.liferay.sqleditor.model.SnippetEntry;
import com.victormiranda.liferay.sqleditor.service.SnippetEntryLocalServiceUtil;
import com.victormiranda.liferay.sqleditor.sql.SQLEngine;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@ProcessAction(name = "saveSnippet")
	public void saveSnippet(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		_log.debug("doView");

		String snippetName = ParamUtil.getString(actionRequest, "snippet-name");
		String snippetCode = ParamUtil.getString(actionRequest, "snippet-code");

		try {
			long snippetId =
				CounterLocalServiceUtil.increment(SnippetEntry.class.getName());

			SnippetEntry snippetEntry =
				SnippetEntryLocalServiceUtil.createSnippetEntry(snippetId);

			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			User user = themeDisplay.getUser();
			Date nowDate = new Date();

			snippetEntry.setCompanyId(CompanyThreadLocal.getCompanyId());
			snippetEntry.setGroupId(themeDisplay.getLayout().getGroupId());
			snippetEntry.setUserId(user.getUserId());
			snippetEntry.setUserName(user.getFullName());
			snippetEntry.setCreateDate(nowDate);
			snippetEntry.setModifiedDate(nowDate);
			snippetEntry.setName(snippetName);
			snippetEntry.setCode(snippetCode);

			SnippetEntryLocalServiceUtil.updateSnippetEntry(snippetEntry);
		} catch (SystemException e) {
			_log.error("Error saving snippet",e);
		}
	}


	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException {

		String resourceId = request.getResourceID();

		_log.debug("serveResource with resourceId: " + resourceId);

		if (EXECUTE_SQL_RESOURCE_ID.equals(resourceId)) {
			String query = ParamUtil.getString(request, "query");

			boolean paginate = false;
			int pageSize;
			try {
				paginate = PrefsPropsUtil.getBoolean("paginate", true);
				pageSize = PrefsPropsUtil.getInteger("pageSize", 10);
				int start = ParamUtil.getInteger(request, "start", -1);
				int length = ParamUtil.getInteger(request, "length", pageSize);

				executeQuery(response, query, paginate, start, length);
			}
			catch (SystemException e) {
				_log.error("Error getting paginate preference");
			}
		}
		else if (EXPORT_CSV_RESOURCE_ID.equals(resourceId)) {
			String query = ParamUtil.getString(request, "query");

			generateCSV(response, query);
		}
	}

	private void executeQuery(ResourceResponse response,
			String query, boolean paginate, int start, int length) throws IOException {

		response.setContentType("application/json");

		JSONObject result = JSONFactoryUtil.createJSONObject();

		try {
			result = JSONFactoryUtil.createJSONObject();

			ExecutionResult executionResult;

			if (paginate) {
				executionResult= SQLEngine.getInstance().runPaginatedSQL(
						query, start, length);
			}
			else {
				executionResult= SQLEngine.getInstance().runSQL(query);
			}

			result.put("results", executionResult.getResults());
			result.put("numElements", executionResult.getNumElements());
			result.put("paginated", paginate);
		} catch (SQLException e) {
			JSONArray errorResult = JSONFactoryUtil.createJSONArray();

			JSONObject errorObject = JSONFactoryUtil.createJSONObject();

			errorObject.put("error", e.getMessage());

			errorResult.put(errorObject);

			result.put("results", errorResult);
		}

		response.getWriter().write(result.toString());
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

			response.getWriter().write(sb.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Log _log = LogFactoryUtil.getLog(SQLEditorPortlet.class.getName());

	private static final String EXECUTE_SQL_RESOURCE_ID = "executeQuery";
	private static final String EXPORT_CSV_RESOURCE_ID = "exportCSV";
}
