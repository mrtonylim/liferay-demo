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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Recognition}.
 * </p>
 *
 * @author hong
 * @see Recognition
 * @generated
 */
public class RecognitionWrapper
	extends BaseModelWrapper<Recognition>
	implements ModelWrapper<Recognition>, Recognition {

	public RecognitionWrapper(Recognition recognition) {
		super(recognition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("recognitionId", getRecognitionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("toUserId", getToUserId());
		attributes.put("toUserName", getToUserName());
		attributes.put("value", getValue());
		attributes.put("subject", getSubject());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long recognitionId = (Long)attributes.get("recognitionId");

		if (recognitionId != null) {
			setRecognitionId(recognitionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Long toUserId = (Long)attributes.get("toUserId");

		if (toUserId != null) {
			setToUserId(toUserId);
		}

		String toUserName = (String)attributes.get("toUserName");

		if (toUserName != null) {
			setToUserName(toUserName);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}
	}

	/**
	 * Returns the company ID of this recognition.
	 *
	 * @return the company ID of this recognition
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this recognition.
	 *
	 * @return the create date of this recognition
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this recognition.
	 *
	 * @return the group ID of this recognition
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this recognition.
	 *
	 * @return the modified date of this recognition
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this recognition.
	 *
	 * @return the mvcc version of this recognition
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this recognition.
	 *
	 * @return the primary key of this recognition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the recognition ID of this recognition.
	 *
	 * @return the recognition ID of this recognition
	 */
	@Override
	public long getRecognitionId() {
		return model.getRecognitionId();
	}

	/**
	 * Returns the subject of this recognition.
	 *
	 * @return the subject of this recognition
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the to user ID of this recognition.
	 *
	 * @return the to user ID of this recognition
	 */
	@Override
	public long getToUserId() {
		return model.getToUserId();
	}

	/**
	 * Returns the to user name of this recognition.
	 *
	 * @return the to user name of this recognition
	 */
	@Override
	public String getToUserName() {
		return model.getToUserName();
	}

	/**
	 * Returns the to user uuid of this recognition.
	 *
	 * @return the to user uuid of this recognition
	 */
	@Override
	public String getToUserUuid() {
		return model.getToUserUuid();
	}

	/**
	 * Returns the user ID of this recognition.
	 *
	 * @return the user ID of this recognition
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this recognition.
	 *
	 * @return the user name of this recognition
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this recognition.
	 *
	 * @return the user uuid of this recognition
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this recognition.
	 *
	 * @return the uuid of this recognition
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the value of this recognition.
	 *
	 * @return the value of this recognition
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this recognition.
	 *
	 * @param companyId the company ID of this recognition
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this recognition.
	 *
	 * @param createDate the create date of this recognition
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this recognition.
	 *
	 * @param groupId the group ID of this recognition
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this recognition.
	 *
	 * @param modifiedDate the modified date of this recognition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this recognition.
	 *
	 * @param mvccVersion the mvcc version of this recognition
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this recognition.
	 *
	 * @param primaryKey the primary key of this recognition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the recognition ID of this recognition.
	 *
	 * @param recognitionId the recognition ID of this recognition
	 */
	@Override
	public void setRecognitionId(long recognitionId) {
		model.setRecognitionId(recognitionId);
	}

	/**
	 * Sets the subject of this recognition.
	 *
	 * @param subject the subject of this recognition
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the to user ID of this recognition.
	 *
	 * @param toUserId the to user ID of this recognition
	 */
	@Override
	public void setToUserId(long toUserId) {
		model.setToUserId(toUserId);
	}

	/**
	 * Sets the to user name of this recognition.
	 *
	 * @param toUserName the to user name of this recognition
	 */
	@Override
	public void setToUserName(String toUserName) {
		model.setToUserName(toUserName);
	}

	/**
	 * Sets the to user uuid of this recognition.
	 *
	 * @param toUserUuid the to user uuid of this recognition
	 */
	@Override
	public void setToUserUuid(String toUserUuid) {
		model.setToUserUuid(toUserUuid);
	}

	/**
	 * Sets the user ID of this recognition.
	 *
	 * @param userId the user ID of this recognition
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this recognition.
	 *
	 * @param userName the user name of this recognition
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this recognition.
	 *
	 * @param userUuid the user uuid of this recognition
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this recognition.
	 *
	 * @param uuid the uuid of this recognition
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the value of this recognition.
	 *
	 * @param value the value of this recognition
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected RecognitionWrapper wrap(Recognition recognition) {
		return new RecognitionWrapper(recognition);
	}

}