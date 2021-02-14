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

import hong.recog.model.FriendshipRecognition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FriendshipRecognition in entity cache.
 *
 * @author hong
 * @generated
 */
public class FriendshipRecognitionCacheModel
	implements CacheModel<FriendshipRecognition>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FriendshipRecognitionCacheModel)) {
			return false;
		}

		FriendshipRecognitionCacheModel friendshipRecognitionCacheModel =
			(FriendshipRecognitionCacheModel)object;

		if ((recognitionId == friendshipRecognitionCacheModel.recognitionId) &&
			(mvccVersion == friendshipRecognitionCacheModel.mvccVersion)) {

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
		StringBundler sb = new StringBundler(13);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", recognitionId=");
		sb.append(recognitionId);
		sb.append(", detailA=");
		sb.append(detailA);
		sb.append(", detailB=");
		sb.append(detailB);
		sb.append(", detailC=");
		sb.append(detailC);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FriendshipRecognition toEntityModel() {
		FriendshipRecognitionImpl friendshipRecognitionImpl =
			new FriendshipRecognitionImpl();

		friendshipRecognitionImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			friendshipRecognitionImpl.setUuid("");
		}
		else {
			friendshipRecognitionImpl.setUuid(uuid);
		}

		friendshipRecognitionImpl.setRecognitionId(recognitionId);

		if (detailA == null) {
			friendshipRecognitionImpl.setDetailA("");
		}
		else {
			friendshipRecognitionImpl.setDetailA(detailA);
		}

		if (detailB == null) {
			friendshipRecognitionImpl.setDetailB("");
		}
		else {
			friendshipRecognitionImpl.setDetailB(detailB);
		}

		if (detailC == null) {
			friendshipRecognitionImpl.setDetailC("");
		}
		else {
			friendshipRecognitionImpl.setDetailC(detailC);
		}

		friendshipRecognitionImpl.resetOriginalValues();

		return friendshipRecognitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		recognitionId = objectInput.readLong();
		detailA = objectInput.readUTF();
		detailB = objectInput.readUTF();
		detailC = objectInput.readUTF();
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

		if (detailA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detailA);
		}

		if (detailB == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detailB);
		}

		if (detailC == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detailC);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long recognitionId;
	public String detailA;
	public String detailB;
	public String detailC;

}