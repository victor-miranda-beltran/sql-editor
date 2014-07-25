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

package com.victormiranda.liferay.sqleditor.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.victormiranda.liferay.sqleditor.model.SnippetEntry;

import java.util.List;

/**
 * The persistence utility for the snippet entry service. This utility wraps {@link SnippetEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SnippetEntryPersistence
 * @see SnippetEntryPersistenceImpl
 * @generated
 */
public class SnippetEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SnippetEntry snippetEntry) {
		getPersistence().clearCache(snippetEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SnippetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SnippetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SnippetEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SnippetEntry update(SnippetEntry snippetEntry)
		throws SystemException {
		return getPersistence().update(snippetEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SnippetEntry update(SnippetEntry snippetEntry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(snippetEntry, serviceContext);
	}

	/**
	* Returns all the snippet entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the snippet entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of snippet entries
	* @param end the upper bound of the range of snippet entries (not inclusive)
	* @return the range of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the snippet entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of snippet entries
	* @param end the upper bound of the range of snippet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first snippet entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first snippet entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last snippet entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last snippet entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the snippet entries before and after the current snippet entry in the ordered set where uuid = &#63;.
	*
	* @param snippetId the primary key of the current snippet entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry[] findByUuid_PrevAndNext(
		long snippetId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(snippetId, uuid, orderByComparator);
	}

	/**
	* Removes all the snippet entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of snippet entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the snippet entry where uuid = &#63; and groupId = &#63; or throws a {@link com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the snippet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the snippet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the snippet entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the snippet entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of snippet entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the snippet entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the snippet entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of snippet entries
	* @param end the upper bound of the range of snippet entries (not inclusive)
	* @return the range of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the snippet entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of snippet entries
	* @param end the upper bound of the range of snippet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first snippet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first snippet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last snippet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last snippet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the snippet entries before and after the current snippet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param snippetId the primary key of the current snippet entry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry[] findByUuid_C_PrevAndNext(
		long snippetId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(snippetId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the snippet entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of snippet entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the snippet entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the snippet entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of snippet entries
	* @param end the upper bound of the range of snippet entries (not inclusive)
	* @return the range of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the snippet entries where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of snippet entries
	* @param end the upper bound of the range of snippet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first snippet entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first snippet entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last snippet entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last snippet entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the snippet entries before and after the current snippet entry in the ordered set where companyId = &#63;.
	*
	* @param snippetId the primary key of the current snippet entry
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry[] findByCompanyId_PrevAndNext(
		long snippetId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(snippetId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the snippet entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of snippet entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Caches the snippet entry in the entity cache if it is enabled.
	*
	* @param snippetEntry the snippet entry
	*/
	public static void cacheResult(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry) {
		getPersistence().cacheResult(snippetEntry);
	}

	/**
	* Caches the snippet entries in the entity cache if it is enabled.
	*
	* @param snippetEntries the snippet entries
	*/
	public static void cacheResult(
		java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> snippetEntries) {
		getPersistence().cacheResult(snippetEntries);
	}

	/**
	* Creates a new snippet entry with the primary key. Does not add the snippet entry to the database.
	*
	* @param snippetId the primary key for the new snippet entry
	* @return the new snippet entry
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry create(
		long snippetId) {
		return getPersistence().create(snippetId);
	}

	/**
	* Removes the snippet entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param snippetId the primary key of the snippet entry
	* @return the snippet entry that was removed
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry remove(
		long snippetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence().remove(snippetId);
	}

	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry updateImpl(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(snippetEntry);
	}

	/**
	* Returns the snippet entry with the primary key or throws a {@link com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException} if it could not be found.
	*
	* @param snippetId the primary key of the snippet entry
	* @return the snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry findByPrimaryKey(
		long snippetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException {
		return getPersistence().findByPrimaryKey(snippetId);
	}

	/**
	* Returns the snippet entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param snippetId the primary key of the snippet entry
	* @return the snippet entry, or <code>null</code> if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByPrimaryKey(
		long snippetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(snippetId);
	}

	/**
	* Returns all the snippet entries.
	*
	* @return the snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the snippet entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of snippet entries
	* @param end the upper bound of the range of snippet entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the snippet entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of snippet entries.
	*
	* @return the number of snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SnippetEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SnippetEntryPersistence)PortletBeanLocatorUtil.locate(com.victormiranda.liferay.sqleditor.service.ClpSerializer.getServletContextName(),
					SnippetEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(SnippetEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SnippetEntryPersistence persistence) {
	}

	private static SnippetEntryPersistence _persistence;
}