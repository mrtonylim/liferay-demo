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

package hong.recog.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hong.recog.service.http.RecognitionServiceSoap}.
 *
 * @author hong
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class RecognitionSoap implements Serializable {

	public static RecognitionSoap toSoapModel(Recognition model) {
		RecognitionSoap soapModel = new RecognitionSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setRecognitionId(model.getRecognitionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setToUserId(model.getToUserId());
		soapModel.setToUserName(model.getToUserName());
		soapModel.setValue(model.getValue());
		soapModel.setSubject(model.getSubject());

		return soapModel;
	}

	public static RecognitionSoap[] toSoapModels(Recognition[] models) {
		RecognitionSoap[] soapModels = new RecognitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RecognitionSoap[][] toSoapModels(Recognition[][] models) {
		RecognitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RecognitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RecognitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RecognitionSoap[] toSoapModels(List<Recognition> models) {
		List<RecognitionSoap> soapModels = new ArrayList<RecognitionSoap>(
			models.size());

		for (Recognition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RecognitionSoap[soapModels.size()]);
	}

	public RecognitionSoap() {
	}

	public long getPrimaryKey() {
		return _recognitionId;
	}

	public void setPrimaryKey(long pk) {
		setRecognitionId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRecognitionId() {
		return _recognitionId;
	}

	public void setRecognitionId(long recognitionId) {
		_recognitionId = recognitionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getToUserId() {
		return _toUserId;
	}

	public void setToUserId(long toUserId) {
		_toUserId = toUserId;
	}

	public String getToUserName() {
		return _toUserName;
	}

	public void setToUserName(String toUserName) {
		_toUserName = toUserName;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _recognitionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _toUserId;
	private String _toUserName;
	private String _value;
	private String _subject;

}