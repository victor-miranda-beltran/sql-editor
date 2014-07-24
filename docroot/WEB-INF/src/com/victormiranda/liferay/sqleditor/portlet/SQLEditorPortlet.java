package com.victormiranda.liferay.sqleditor.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author Victor Miranda
 */
public class SQLEditorPortlet extends MVCPortlet {


	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		_log.debug("doView");

		include(viewTemplate, renderRequest, renderResponse);
	}

	private Log _log = LogFactoryUtil.getLog(SQLEditorPortlet.class.getName());
}
