package com.victormiranda.liferay.sqleditor.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.victormiranda.liferay.sqleditor.sql.SQLEngine;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
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

	private Log _log = LogFactoryUtil.getLog(SQLEditorPortlet.class.getName());
}
