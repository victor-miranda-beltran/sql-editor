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

package com.victormiranda.liferay.sqleditor.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SnippetEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SnippetEntry
 * @generated
 */
public class SnippetEntryWrapper implements SnippetEntry,
	ModelWrapper<SnippetEntry> {
	public SnippetEntryWrapper(SnippetEntry snippetEntry) {
		_snippetEntry = snippetEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return SnippetEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SnippetEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("snippetId", getSnippetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("code", getCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long snippetId = (Long)attributes.get("snippetId");

		if (snippetId != null) {
			setSnippetId(snippetId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}
	}

	/**
	* Returns the primary key of this snippet entry.
	*
	* @return the primary key of this snippet entry
	*/
	@Override
	public long getPrimaryKey() {
		return _snippetEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this snippet entry.
	*
	* @param primaryKey the primary key of this snippet entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_snippetEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this snippet entry.
	*
	* @return the uuid of this snippet entry
	*/
	@Override
	public java.lang.String getUuid() {
		return _snippetEntry.getUuid();
	}

	/**
	* Sets the uuid of this snippet entry.
	*
	* @param uuid the uuid of this snippet entry
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_snippetEntry.setUuid(uuid);
	}

	/**
	* Returns the snippet ID of this snippet entry.
	*
	* @return the snippet ID of this snippet entry
	*/
	@Override
	public long getSnippetId() {
		return _snippetEntry.getSnippetId();
	}

	/**
	* Sets the snippet ID of this snippet entry.
	*
	* @param snippetId the snippet ID of this snippet entry
	*/
	@Override
	public void setSnippetId(long snippetId) {
		_snippetEntry.setSnippetId(snippetId);
	}

	/**
	* Returns the group ID of this snippet entry.
	*
	* @return the group ID of this snippet entry
	*/
	@Override
	public long getGroupId() {
		return _snippetEntry.getGroupId();
	}

	/**
	* Sets the group ID of this snippet entry.
	*
	* @param groupId the group ID of this snippet entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_snippetEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this snippet entry.
	*
	* @return the company ID of this snippet entry
	*/
	@Override
	public long getCompanyId() {
		return _snippetEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this snippet entry.
	*
	* @param companyId the company ID of this snippet entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_snippetEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this snippet entry.
	*
	* @return the user ID of this snippet entry
	*/
	@Override
	public long getUserId() {
		return _snippetEntry.getUserId();
	}

	/**
	* Sets the user ID of this snippet entry.
	*
	* @param userId the user ID of this snippet entry
	*/
	@Override
	public void setUserId(long userId) {
		_snippetEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this snippet entry.
	*
	* @return the user uuid of this snippet entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _snippetEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this snippet entry.
	*
	* @param userUuid the user uuid of this snippet entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_snippetEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this snippet entry.
	*
	* @return the user name of this snippet entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _snippetEntry.getUserName();
	}

	/**
	* Sets the user name of this snippet entry.
	*
	* @param userName the user name of this snippet entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_snippetEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this snippet entry.
	*
	* @return the create date of this snippet entry
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _snippetEntry.getCreateDate();
	}

	/**
	* Sets the create date of this snippet entry.
	*
	* @param createDate the create date of this snippet entry
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_snippetEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this snippet entry.
	*
	* @return the modified date of this snippet entry
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _snippetEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this snippet entry.
	*
	* @param modifiedDate the modified date of this snippet entry
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_snippetEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this snippet entry.
	*
	* @return the name of this snippet entry
	*/
	@Override
	public java.lang.String getName() {
		return _snippetEntry.getName();
	}

	/**
	* Sets the name of this snippet entry.
	*
	* @param name the name of this snippet entry
	*/
	@Override
	public void setName(java.lang.String name) {
		_snippetEntry.setName(name);
	}

	/**
	* Returns the code of this snippet entry.
	*
	* @return the code of this snippet entry
	*/
	@Override
	public java.lang.String getCode() {
		return _snippetEntry.getCode();
	}

	/**
	* Sets the code of this snippet entry.
	*
	* @param code the code of this snippet entry
	*/
	@Override
	public void setCode(java.lang.String code) {
		_snippetEntry.setCode(code);
	}

	@Override
	public boolean isNew() {
		return _snippetEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_snippetEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _snippetEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_snippetEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _snippetEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _snippetEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_snippetEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _snippetEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_snippetEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_snippetEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_snippetEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SnippetEntryWrapper((SnippetEntry)_snippetEntry.clone());
	}

	@Override
	public int compareTo(
		com.victormiranda.liferay.sqleditor.model.SnippetEntry snippetEntry) {
		return _snippetEntry.compareTo(snippetEntry);
	}

	@Override
	public int hashCode() {
		return _snippetEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.victormiranda.liferay.sqleditor.model.SnippetEntry> toCacheModel() {
		return _snippetEntry.toCacheModel();
	}

	@Override
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry toEscapedModel() {
		return new SnippetEntryWrapper(_snippetEntry.toEscapedModel());
	}

	@Override
	public com.victormiranda.liferay.sqleditor.model.SnippetEntry toUnescapedModel() {
		return new SnippetEntryWrapper(_snippetEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _snippetEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _snippetEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_snippetEntry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SnippetEntryWrapper)) {
			return false;
		}

		SnippetEntryWrapper snippetEntryWrapper = (SnippetEntryWrapper)obj;

		if (Validator.equals(_snippetEntry, snippetEntryWrapper._snippetEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _snippetEntry.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SnippetEntry getWrappedSnippetEntry() {
		return _snippetEntry;
	}

	@Override
	public SnippetEntry getWrappedModel() {
		return _snippetEntry;
	}

	@Override
	public void resetOriginalValues() {
		_snippetEntry.resetOriginalValues();
	}

	private SnippetEntry _snippetEntry;
}