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

import com.liferay.portal.service.persistence.BasePersistence;

import com.victormiranda.liferay.sqleditor.model.SnippetEntry;

/**
 * The persistence interface for the snippet entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SnippetEntryPersistenceImpl
 * @see SnippetEntryUtil
 * @generated
 */
public interface SnippetEntryPersistence extends BasePersistence<SnippetEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SnippetEntryUtil} to access the snippet entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the snippet entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first snippet entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the first snippet entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last snippet entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the last snippet entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry[] findByUuid_PrevAndNext(
		long snippetId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Removes all the snippet entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of snippet entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the snippet entry where uuid = &#63; and groupId = &#63; or throws a {@link com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the snippet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the snippet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the snippet entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the snippet entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the number of snippet entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the snippet entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the first snippet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the last snippet entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry[] findByUuid_C_PrevAndNext(
		long snippetId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Removes all the snippet entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of snippet entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the snippet entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first snippet entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the first snippet entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last snippet entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the last snippet entry in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry[] findByCompanyId_PrevAndNext(
		long snippetId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Removes all the snippet entries where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of snippet entries where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the snippet entry in the entity cache if it is enabled.
	*
	* @param snippetEntry the snippet entry
	*/
	public void cacheResult(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry);

	/**
	* Caches the snippet entries in the entity cache if it is enabled.
	*
	* @param snippetEntries the snippet entries
	*/
	public void cacheResult(
		java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> snippetEntries);

	/**
	* Creates a new snippet entry with the primary key. Does not add the snippet entry to the database.
	*
	* @param snippetId the primary key for the new snippet entry
	* @return the new snippet entry
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry create(
		long snippetId);

	/**
	* Removes the snippet entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param snippetId the primary key of the snippet entry
	* @return the snippet entry that was removed
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry remove(
		long snippetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	public com.victormiranda.liferay.sqleditor.model.SnippetEntry updateImpl(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the snippet entry with the primary key or throws a {@link com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException} if it could not be found.
	*
	* @param snippetId the primary key of the snippet entry
	* @return the snippet entry
	* @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry findByPrimaryKey(
		long snippetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;

	/**
	* Returns the snippet entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param snippetId the primary key of the snippet entry
	* @return the snippet entry, or <code>null</code> if a snippet entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry fetchByPrimaryKey(
		long snippetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the snippet entries.
	*
	* @return the snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.victormiranda.liferay.sqleditor.model.SnippetEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the snippet entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of snippet entries.
	*
	* @return the number of snippet entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}