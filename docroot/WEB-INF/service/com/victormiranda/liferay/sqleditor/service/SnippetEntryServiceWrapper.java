/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.victormiranda.liferay.sqleditor.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SnippetEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see SnippetEntryService
 * @generated
 */
public class SnippetEntryServiceWrapper implements SnippetEntryService,
	ServiceWrapper<SnippetEntryService> {
	public SnippetEntryServiceWrapper(SnippetEntryService snippetEntryService) {
		_snippetEntryService = snippetEntryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _snippetEntryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_snippetEntryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _snippetEntryService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SnippetEntryService getWrappedSnippetEntryService() {
		return _snippetEntryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSnippetEntryService(
		SnippetEntryService snippetEntryService) {
		_snippetEntryService = snippetEntryService;
	}

	@Override
	public SnippetEntryService getWrappedService() {
		return _snippetEntryService;
	}

	@Override
	public void setWrappedService(SnippetEntryService snippetEntryService) {
		_snippetEntryService = snippetEntryService;
	}

	private SnippetEntryService _snippetEntryService;
}