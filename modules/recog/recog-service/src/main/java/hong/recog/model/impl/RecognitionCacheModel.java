/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package hong.recog.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import hong.recog.model.Recognition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Recognition in entity cache.
 *
 * @author hong
 * @generated
 */
public class RecognitionCacheModel
	implements CacheModel<Recognition>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RecognitionCacheModel)) {
			return false;
		}

		RecognitionCacheModel recognitionCacheModel =
			(RecognitionCacheModel)object;

		if ((recognitionId == recognitionCacheModel.recognitionId) &&
			(mvccVersion == recognitionCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, recognitionId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", recognitionId=");
		sb.append(recognitionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", toUserId=");
		sb.append(toUserId);
		sb.append(", toUserName=");
		sb.append(toUserName);
		sb.append(", value=");
		sb.append(value);
		sb.append(", subject=");
		sb.append(subject);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Recognition toEntityModel() {
		RecognitionImpl recognitionImpl = new RecognitionImpl();

		recognitionImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			recognitionImpl.setUuid("");
		}
		else {
			recognitionImpl.setUuid(uuid);
		}

		recognitionImpl.setRecognitionId(recognitionId);
		recognitionImpl.setCompanyId(companyId);
		recognitionImpl.setGroupId(groupId);
		recognitionImpl.setUserId(userId);

		if (userName == null) {
			recognitionImpl.setUserName("");
		}
		else {
			recognitionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			recognitionImpl.setCreateDate(null);
		}
		else {
			recognitionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			recognitionImpl.setModifiedDate(null);
		}
		else {
			recognitionImpl.setModifiedDate(new Date(modifiedDate));
		}

		recognitionImpl.setToUserId(toUserId);

		if (toUserName == null) {
			recognitionImpl.setToUserName("");
		}
		else {
			recognitionImpl.setToUserName(toUserName);
		}

		if (value == null) {
			recognitionImpl.setValue("");
		}
		else {
			recognitionImpl.setValue(value);
		}

		if (subject == null) {
			recognitionImpl.setSubject("");
		}
		else {
			recognitionImpl.setSubject(subject);
		}

		recognitionImpl.resetOriginalValues();

		return recognitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		recognitionId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		toUserId = objectInput.readLong();
		toUserName = objectInput.readUTF();
		value = objectInput.readUTF();
		subject = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(recognitionId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(toUserId);

		if (toUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toUserName);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long recognitionId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long toUserId;
	public String toUserName;
	public String value;
	public String subject;

}