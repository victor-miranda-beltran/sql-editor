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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException;
import com.victormiranda.liferay.sqleditor.model.SnippetEntry;
import com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryImpl;
import com.victormiranda.liferay.sqleditor.model.impl.SnippetEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the snippet entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SnippetEntryPersistence
 * @see SnippetEntryUtil
 * @generated
 */
public class SnippetEntryPersistenceImpl extends BasePersistenceImpl<SnippetEntry>
	implements SnippetEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SnippetEntryUtil} to access the snippet entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SnippetEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SnippetEntryModelImpl.UUID_COLUMN_BITMASK |
			SnippetEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the snippet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SnippetEntry> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SnippetEntry> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<SnippetEntry> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<SnippetEntry> list = (List<SnippetEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SnippetEntry snippetEntry : list) {
				if (!Validator.equals(uuid, snippetEntry.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SNIPPETENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SnippetEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<SnippetEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SnippetEntry>(list);
				}
				else {
					list = (List<SnippetEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SnippetEntry findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = fetchByUuid_First(uuid, orderByComparator);

		if (snippetEntry != null) {
			return snippetEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSnippetEntryException(msg.toString());
	}

	/**
	 * Returns the first snippet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SnippetEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SnippetEntry findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (snippetEntry != null) {
			return snippetEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSnippetEntryException(msg.toString());
	}

	/**
	 * Returns the last snippet entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SnippetEntry> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SnippetEntry[] findByUuid_PrevAndNext(long snippetId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = findByPrimaryKey(snippetId);

		Session session = null;

		try {
			session = openSession();

			SnippetEntry[] array = new SnippetEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(session, snippetEntry, uuid,
					orderByComparator, true);

			array[1] = snippetEntry;

			array[2] = getByUuid_PrevAndNext(session, snippetEntry, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SnippetEntry getByUuid_PrevAndNext(Session session,
		SnippetEntry snippetEntry, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SNIPPETENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SnippetEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(snippetEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SnippetEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the snippet entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SnippetEntry snippetEntry : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(snippetEntry);
		}
	}

	/**
	 * Returns the number of snippet entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SNIPPETENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "snippetEntry.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "snippetEntry.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(snippetEntry.uuid IS NULL OR snippetEntry.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SnippetEntryModelImpl.UUID_COLUMN_BITMASK |
			SnippetEntryModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the snippet entry where uuid = &#63; and groupId = &#63; or throws a {@link com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching snippet entry
	 * @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a matching snippet entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = fetchByUUID_G(uuid, groupId);

		if (snippetEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSnippetEntryException(msg.toString());
		}

		return snippetEntry;
	}

	/**
	 * Returns the snippet entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
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
	@Override
	public SnippetEntry fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof SnippetEntry) {
			SnippetEntry snippetEntry = (SnippetEntry)result;

			if (!Validator.equals(uuid, snippetEntry.getUuid()) ||
					(groupId != snippetEntry.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SNIPPETENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<SnippetEntry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					SnippetEntry snippetEntry = list.get(0);

					result = snippetEntry;

					cacheResult(snippetEntry);

					if ((snippetEntry.getUuid() == null) ||
							!snippetEntry.getUuid().equals(uuid) ||
							(snippetEntry.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, snippetEntry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SnippetEntry)result;
		}
	}

	/**
	 * Removes the snippet entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the snippet entry that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = findByUUID_G(uuid, groupId);

		return remove(snippetEntry);
	}

	/**
	 * Returns the number of snippet entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SNIPPETENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "snippetEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "snippetEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(snippetEntry.uuid IS NULL OR snippetEntry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "snippetEntry.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SnippetEntryModelImpl.UUID_COLUMN_BITMASK |
			SnippetEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			SnippetEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the snippet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SnippetEntry> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<SnippetEntry> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<SnippetEntry> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<SnippetEntry> list = (List<SnippetEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SnippetEntry snippetEntry : list) {
				if (!Validator.equals(uuid, snippetEntry.getUuid()) ||
						(companyId != snippetEntry.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SNIPPETENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SnippetEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<SnippetEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SnippetEntry>(list);
				}
				else {
					list = (List<SnippetEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SnippetEntry findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (snippetEntry != null) {
			return snippetEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSnippetEntryException(msg.toString());
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
	@Override
	public SnippetEntry fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SnippetEntry> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SnippetEntry findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (snippetEntry != null) {
			return snippetEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSnippetEntryException(msg.toString());
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
	@Override
	public SnippetEntry fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SnippetEntry> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SnippetEntry[] findByUuid_C_PrevAndNext(long snippetId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = findByPrimaryKey(snippetId);

		Session session = null;

		try {
			session = openSession();

			SnippetEntry[] array = new SnippetEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, snippetEntry, uuid,
					companyId, orderByComparator, true);

			array[1] = snippetEntry;

			array[2] = getByUuid_C_PrevAndNext(session, snippetEntry, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SnippetEntry getByUuid_C_PrevAndNext(Session session,
		SnippetEntry snippetEntry, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SNIPPETENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SnippetEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(snippetEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SnippetEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the snippet entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (SnippetEntry snippetEntry : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(snippetEntry);
		}
	}

	/**
	 * Returns the number of snippet entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SNIPPETENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "snippetEntry.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "snippetEntry.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(snippetEntry.uuid IS NULL OR snippetEntry.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "snippetEntry.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, SnippetEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			SnippetEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			SnippetEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the snippet entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SnippetEntry> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<SnippetEntry> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<SnippetEntry> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<SnippetEntry> list = (List<SnippetEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SnippetEntry snippetEntry : list) {
				if ((companyId != snippetEntry.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SNIPPETENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SnippetEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<SnippetEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SnippetEntry>(list);
				}
				else {
					list = (List<SnippetEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SnippetEntry findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (snippetEntry != null) {
			return snippetEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSnippetEntryException(msg.toString());
	}

	/**
	 * Returns the first snippet entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SnippetEntry> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SnippetEntry findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (snippetEntry != null) {
			return snippetEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSnippetEntryException(msg.toString());
	}

	/**
	 * Returns the last snippet entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching snippet entry, or <code>null</code> if a matching snippet entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<SnippetEntry> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SnippetEntry[] findByCompanyId_PrevAndNext(long snippetId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = findByPrimaryKey(snippetId);

		Session session = null;

		try {
			session = openSession();

			SnippetEntry[] array = new SnippetEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, snippetEntry,
					companyId, orderByComparator, true);

			array[1] = snippetEntry;

			array[2] = getByCompanyId_PrevAndNext(session, snippetEntry,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SnippetEntry getByCompanyId_PrevAndNext(Session session,
		SnippetEntry snippetEntry, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SNIPPETENTRY_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SnippetEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(snippetEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SnippetEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the snippet entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (SnippetEntry snippetEntry : findByCompanyId(companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(snippetEntry);
		}
	}

	/**
	 * Returns the number of snippet entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SNIPPETENTRY_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "snippetEntry.companyId = ?";

	public SnippetEntryPersistenceImpl() {
		setModelClass(SnippetEntry.class);
	}

	/**
	 * Caches the snippet entry in the entity cache if it is enabled.
	 *
	 * @param snippetEntry the snippet entry
	 */
	@Override
	public void cacheResult(SnippetEntry snippetEntry) {
		EntityCacheUtil.putResult(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryImpl.class, snippetEntry.getPrimaryKey(), snippetEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { snippetEntry.getUuid(), snippetEntry.getGroupId() },
			snippetEntry);

		snippetEntry.resetOriginalValues();
	}

	/**
	 * Caches the snippet entries in the entity cache if it is enabled.
	 *
	 * @param snippetEntries the snippet entries
	 */
	@Override
	public void cacheResult(List<SnippetEntry> snippetEntries) {
		for (SnippetEntry snippetEntry : snippetEntries) {
			if (EntityCacheUtil.getResult(
						SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
						SnippetEntryImpl.class, snippetEntry.getPrimaryKey()) == null) {
				cacheResult(snippetEntry);
			}
			else {
				snippetEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all snippet entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SnippetEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SnippetEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the snippet entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SnippetEntry snippetEntry) {
		EntityCacheUtil.removeResult(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryImpl.class, snippetEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(snippetEntry);
	}

	@Override
	public void clearCache(List<SnippetEntry> snippetEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SnippetEntry snippetEntry : snippetEntries) {
			EntityCacheUtil.removeResult(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
				SnippetEntryImpl.class, snippetEntry.getPrimaryKey());

			clearUniqueFindersCache(snippetEntry);
		}
	}

	protected void cacheUniqueFindersCache(SnippetEntry snippetEntry) {
		if (snippetEntry.isNew()) {
			Object[] args = new Object[] {
					snippetEntry.getUuid(), snippetEntry.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				snippetEntry);
		}
		else {
			SnippetEntryModelImpl snippetEntryModelImpl = (SnippetEntryModelImpl)snippetEntry;

			if ((snippetEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						snippetEntry.getUuid(), snippetEntry.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					snippetEntry);
			}
		}
	}

	protected void clearUniqueFindersCache(SnippetEntry snippetEntry) {
		SnippetEntryModelImpl snippetEntryModelImpl = (SnippetEntryModelImpl)snippetEntry;

		Object[] args = new Object[] {
				snippetEntry.getUuid(), snippetEntry.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((snippetEntryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					snippetEntryModelImpl.getOriginalUuid(),
					snippetEntryModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new snippet entry with the primary key. Does not add the snippet entry to the database.
	 *
	 * @param snippetId the primary key for the new snippet entry
	 * @return the new snippet entry
	 */
	@Override
	public SnippetEntry create(long snippetId) {
		SnippetEntry snippetEntry = new SnippetEntryImpl();

		snippetEntry.setNew(true);
		snippetEntry.setPrimaryKey(snippetId);

		String uuid = PortalUUIDUtil.generate();

		snippetEntry.setUuid(uuid);

		return snippetEntry;
	}

	/**
	 * Removes the snippet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param snippetId the primary key of the snippet entry
	 * @return the snippet entry that was removed
	 * @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry remove(long snippetId)
		throws NoSuchSnippetEntryException, SystemException {
		return remove((Serializable)snippetId);
	}

	/**
	 * Removes the snippet entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the snippet entry
	 * @return the snippet entry that was removed
	 * @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry remove(Serializable primaryKey)
		throws NoSuchSnippetEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SnippetEntry snippetEntry = (SnippetEntry)session.get(SnippetEntryImpl.class,
					primaryKey);

			if (snippetEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSnippetEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(snippetEntry);
		}
		catch (NoSuchSnippetEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SnippetEntry removeImpl(SnippetEntry snippetEntry)
		throws SystemException {
		snippetEntry = toUnwrappedModel(snippetEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(snippetEntry)) {
				snippetEntry = (SnippetEntry)session.get(SnippetEntryImpl.class,
						snippetEntry.getPrimaryKeyObj());
			}

			if (snippetEntry != null) {
				session.delete(snippetEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (snippetEntry != null) {
			clearCache(snippetEntry);
		}

		return snippetEntry;
	}

	@Override
	public SnippetEntry updateImpl(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry)
		throws SystemException {
		snippetEntry = toUnwrappedModel(snippetEntry);

		boolean isNew = snippetEntry.isNew();

		SnippetEntryModelImpl snippetEntryModelImpl = (SnippetEntryModelImpl)snippetEntry;

		if (Validator.isNull(snippetEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			snippetEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (snippetEntry.isNew()) {
				session.save(snippetEntry);

				snippetEntry.setNew(false);
			}
			else {
				session.merge(snippetEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SnippetEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((snippetEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						snippetEntryModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { snippetEntryModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((snippetEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						snippetEntryModelImpl.getOriginalUuid(),
						snippetEntryModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						snippetEntryModelImpl.getUuid(),
						snippetEntryModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((snippetEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						snippetEntryModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { snippetEntryModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
			SnippetEntryImpl.class, snippetEntry.getPrimaryKey(), snippetEntry);

		clearUniqueFindersCache(snippetEntry);
		cacheUniqueFindersCache(snippetEntry);

		return snippetEntry;
	}

	protected SnippetEntry toUnwrappedModel(SnippetEntry snippetEntry) {
		if (snippetEntry instanceof SnippetEntryImpl) {
			return snippetEntry;
		}

		SnippetEntryImpl snippetEntryImpl = new SnippetEntryImpl();

		snippetEntryImpl.setNew(snippetEntry.isNew());
		snippetEntryImpl.setPrimaryKey(snippetEntry.getPrimaryKey());

		snippetEntryImpl.setUuid(snippetEntry.getUuid());
		snippetEntryImpl.setSnippetId(snippetEntry.getSnippetId());
		snippetEntryImpl.setGroupId(snippetEntry.getGroupId());
		snippetEntryImpl.setCompanyId(snippetEntry.getCompanyId());
		snippetEntryImpl.setUserId(snippetEntry.getUserId());
		snippetEntryImpl.setUserName(snippetEntry.getUserName());
		snippetEntryImpl.setCreateDate(snippetEntry.getCreateDate());
		snippetEntryImpl.setModifiedDate(snippetEntry.getModifiedDate());
		snippetEntryImpl.setName(snippetEntry.getName());
		snippetEntryImpl.setCode(snippetEntry.getCode());

		return snippetEntryImpl;
	}

	/**
	 * Returns the snippet entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the snippet entry
	 * @return the snippet entry
	 * @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSnippetEntryException, SystemException {
		SnippetEntry snippetEntry = fetchByPrimaryKey(primaryKey);

		if (snippetEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSnippetEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return snippetEntry;
	}

	/**
	 * Returns the snippet entry with the primary key or throws a {@link com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException} if it could not be found.
	 *
	 * @param snippetId the primary key of the snippet entry
	 * @return the snippet entry
	 * @throws com.victormiranda.liferay.sqleditor.NoSuchSnippetEntryException if a snippet entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry findByPrimaryKey(long snippetId)
		throws NoSuchSnippetEntryException, SystemException {
		return findByPrimaryKey((Serializable)snippetId);
	}

	/**
	 * Returns the snippet entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the snippet entry
	 * @return the snippet entry, or <code>null</code> if a snippet entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SnippetEntry snippetEntry = (SnippetEntry)EntityCacheUtil.getResult(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
				SnippetEntryImpl.class, primaryKey);

		if (snippetEntry == _nullSnippetEntry) {
			return null;
		}

		if (snippetEntry == null) {
			Session session = null;

			try {
				session = openSession();

				snippetEntry = (SnippetEntry)session.get(SnippetEntryImpl.class,
						primaryKey);

				if (snippetEntry != null) {
					cacheResult(snippetEntry);
				}
				else {
					EntityCacheUtil.putResult(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
						SnippetEntryImpl.class, primaryKey, _nullSnippetEntry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SnippetEntryModelImpl.ENTITY_CACHE_ENABLED,
					SnippetEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return snippetEntry;
	}

	/**
	 * Returns the snippet entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param snippetId the primary key of the snippet entry
	 * @return the snippet entry, or <code>null</code> if a snippet entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SnippetEntry fetchByPrimaryKey(long snippetId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)snippetId);
	}

	/**
	 * Returns all the snippet entries.
	 *
	 * @return the snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SnippetEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SnippetEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SnippetEntry> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SnippetEntry> list = (List<SnippetEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SNIPPETENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SNIPPETENTRY;

				if (pagination) {
					sql = sql.concat(SnippetEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SnippetEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SnippetEntry>(list);
				}
				else {
					list = (List<SnippetEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the snippet entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SnippetEntry snippetEntry : findAll()) {
			remove(snippetEntry);
		}
	}

	/**
	 * Returns the number of snippet entries.
	 *
	 * @return the number of snippet entries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SNIPPETENTRY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the snippet entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.victormiranda.liferay.sqleditor.model.SnippetEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SnippetEntry>> listenersList = new ArrayList<ModelListener<SnippetEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SnippetEntry>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SnippetEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SNIPPETENTRY = "SELECT snippetEntry FROM SnippetEntry snippetEntry";
	private static final String _SQL_SELECT_SNIPPETENTRY_WHERE = "SELECT snippetEntry FROM SnippetEntry snippetEntry WHERE ";
	private static final String _SQL_COUNT_SNIPPETENTRY = "SELECT COUNT(snippetEntry) FROM SnippetEntry snippetEntry";
	private static final String _SQL_COUNT_SNIPPETENTRY_WHERE = "SELECT COUNT(snippetEntry) FROM SnippetEntry snippetEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "snippetEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SnippetEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SnippetEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SnippetEntryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "code"
			});
	private static SnippetEntry _nullSnippetEntry = new SnippetEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SnippetEntry> toCacheModel() {
				return _nullSnippetEntryCacheModel;
			}
		};

	private static CacheModel<SnippetEntry> _nullSnippetEntryCacheModel = new CacheModel<SnippetEntry>() {
			@Override
			public SnippetEntry toEntityModel() {
				return _nullSnippetEntry;
			}
		};
}