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

import hong.recog.model.PerformanceRecognition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PerformanceRecognition in entity cache.
 *
 * @author hong
 * @generated
 */
public class PerformanceRecognitionCacheModel
	implements CacheModel<PerformanceRecognition>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PerformanceRecognitionCacheModel)) {
			return false;
		}

		PerformanceRecognitionCacheModel performanceRecognitionCacheModel =
			(PerformanceRecognitionCacheModel)object;

		if ((recognitionId == performanceRecognitionCacheModel.recognitionId) &&
			(mvccVersion == performanceRecognitionCacheModel.mvccVersion)) {

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
		StringBundler sb = new StringBundler(11);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", recognitionId=");
		sb.append(recognitionId);
		sb.append(", detail1=");
		sb.append(detail1);
		sb.append(", detail2=");
		sb.append(detail2);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PerformanceRecognition toEntityModel() {
		PerformanceRecognitionImpl performanceRecognitionImpl =
			new PerformanceRecognitionImpl();

		performanceRecognitionImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			performanceRecognitionImpl.setUuid("");
		}
		else {
			performanceRecognitionImpl.setUuid(uuid);
		}

		performanceRecognitionImpl.setRecognitionId(recognitionId);

		if (detail1 == null) {
			performanceRecognitionImpl.setDetail1("");
		}
		else {
			performanceRecognitionImpl.setDetail1(detail1);
		}

		if (detail2 == null) {
			performanceRecognitionImpl.setDetail2("");
		}
		else {
			performanceRecognitionImpl.setDetail2(detail2);
		}

		performanceRecognitionImpl.resetOriginalValues();

		return performanceRecognitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		recognitionId = objectInput.readLong();
		detail1 = objectInput.readUTF();
		detail2 = objectInput.readUTF();
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

		if (detail1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detail1);
		}

		if (detail2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detail2);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long recognitionId;
	public String detail1;
	public String detail2;

}