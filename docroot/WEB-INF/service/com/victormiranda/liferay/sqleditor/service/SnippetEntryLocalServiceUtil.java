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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SnippetEntry. This utility wraps
 * {@link com.victormiranda.liferay.sqleditor.service.impl.SnippetEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SnippetEntryLocalService
 * @see com.victormiranda.liferay.sqleditor.service.base.SnippetEntryLocalServiceBaseImpl
 * @see com.victormiranda.liferay.sqleditor.service.impl.SnippetEntryLocalServiceImpl
 * @generated
 */
public class SnippetEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.victormiranda.liferay.sqleditor.service.impl.SnippetEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the snippet entry to the database. Also notifies the appropriate model listeners.
	*
	* @param snippetEntry the snippet entry
	* @return the snippet entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry addSnippetEntry(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSnippetEntry(snippetEntry);
	}

	/**
	* Creates a new snippet entry with the primary key. Does not add the snippet entry to the database.
	*
	* @param snippetId the primary key for the new snippet entry
	* @return the new snippet entry
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry createSnippetEntry(
		long snippetId) {
		return getService().createSnippetEntry(snippetId);
	}

	/**
	* Deletes the snippet entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param snippetId the primary key of the snippet entry
	* @return the snippet entry that was removed
	* @throws PortalException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry deleteSnippetEntry(
		long snippetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSnippetEntry(snippetId);
	}

	/**
	* Deletes the snippet entry from the database. Also notifies the appropriate model listeners.
	*
	* @param snippetEntry the snippet entry
	* @return the snippet entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry deleteSnippetEntry(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSnippetEntry(snippetEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchSnippetEntry(
		long snippetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSnippetEntry(snippetId);
	}

	/**
	* Returns the snippet entry with the matching UUID and company.
	*
	* @param uuid the snippet entry's UUID
	* @param companyId the primary key of the company
	* @return the matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchSnippetEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSnippetEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the snippet entry matching the UUID and group.
	*
	* @param uuid the snippet entry's UUID
	* @param groupId the primary key of the group
	* @return the matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchSnippetEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSnippetEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the snippet entry with the primary key.
	*
	* @param snippetId the primary key of the snippet entry
	* @return the snippet entry
	* @throws PortalException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry getSnippetEntry(
		long snippetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSnippetEntry(snippetId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the snippet entry with the matching UUID and company.
	*
	* @param uuid the snippet entry's UUID
	* @param companyId the primary key of the company
	* @return the matching snippet entry
	* @throws PortalException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry getSnippetEntryByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSnippetEntryByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the snippet entry matching the UUID and group.
	*
	* @param uuid the snippet entry's UUID
	* @param groupId the primary key of the group
	* @return the matching snippet entry
	* @throws PortalException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry getSnippetEntryByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSnippetEntryByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the snippet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of snippet entries
	* @param end the upper bound of the range of snippet entries (not inclusive)
	* @return the range of snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> getSnippetEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSnippetEntries(start, end);
	}

	/**
	* Returns the number of snippet entries.
	*
	* @return the number of snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getSnippetEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSnippetEntriesCount();
	}

	/**
	* Updates the snippet entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param snippetEntry the snippet entry
	* @return the snippet entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry updateSnippetEntry(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSnippetEntry(snippetEntry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static SnippetEntryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SnippetEntryLocalService.class.getName());

			if (invokableLocalService instanceof SnippetEntryLocalService) {
				_service = (SnippetEntryLocalService)invokableLocalService;
			}
			else {
				_service = new SnippetEntryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SnippetEntryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SnippetEntryLocalService service) {
	}

	private static SnippetEntryLocalService _service;
}