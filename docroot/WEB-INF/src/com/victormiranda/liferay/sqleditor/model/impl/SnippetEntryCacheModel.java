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

package com.victormiranda.liferay.sqleditor.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.victormiranda.liferay.sqleditor.model.SnippetEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SnippetEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SnippetEntry
 * @generated
 */
public class SnippetEntryCacheModel implements CacheModel<SnippetEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", snippetId=");
		sb.append(snippetId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SnippetEntry toEntityModel() {
		SnippetEntryImpl snippetEntryImpl = new SnippetEntryImpl();

		if (uuid == null) {
			snippetEntryImpl.setUuid(StringPool.BLANK);
		}
		else {
			snippetEntryImpl.setUuid(uuid);
		}

		snippetEntryImpl.setSnippetId(snippetId);
		snippetEntryImpl.setGroupId(groupId);
		snippetEntryImpl.setCompanyId(companyId);
		snippetEntryImpl.setUserId(userId);

		if (userName == null) {
			snippetEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			snippetEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			snippetEntryImpl.setCreateDate(null);
		}
		else {
			snippetEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			snippetEntryImpl.setModifiedDate(null);
		}
		else {
			snippetEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			snippetEntryImpl.setName(StringPool.BLANK);
		}
		else {
			snippetEntryImpl.setName(name);
		}

		if (code == null) {
			snippetEntryImpl.setCode(StringPool.BLANK);
		}
		else {
			snippetEntryImpl.setCode(code);
		}

		snippetEntryImpl.resetOriginalValues();

		return snippetEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		snippetId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(snippetId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}
	}

	public String uuid;
	public long snippetId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String code;
}