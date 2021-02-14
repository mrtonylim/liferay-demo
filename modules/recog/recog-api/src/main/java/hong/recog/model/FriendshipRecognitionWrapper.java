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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FriendshipRecognition}.
 * </p>
 *
 * @author hong
 * @see FriendshipRecognition
 * @generated
 */
public class FriendshipRecognitionWrapper
	extends BaseModelWrapper<FriendshipRecognition>
	implements FriendshipRecognition, ModelWrapper<FriendshipRecognition> {

	public FriendshipRecognitionWrapper(
		FriendshipRecognition friendshipRecognition) {

		super(friendshipRecognition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("recognitionId", getRecognitionId());
		attributes.put("detailA", getDetailA());
		attributes.put("detailB", getDetailB());
		attributes.put("detailC", getDetailC());

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

		String detailA = (String)attributes.get("detailA");

		if (detailA != null) {
			setDetailA(detailA);
		}

		String detailB = (String)attributes.get("detailB");

		if (detailB != null) {
			setDetailB(detailB);
		}

		String detailC = (String)attributes.get("detailC");

		if (detailC != null) {
			setDetailC(detailC);
		}
	}

	/**
	 * Returns the detail a of this friendship recognition.
	 *
	 * @return the detail a of this friendship recognition
	 */
	@Override
	public String getDetailA() {
		return model.getDetailA();
	}

	/**
	 * Returns the detail b of this friendship recognition.
	 *
	 * @return the detail b of this friendship recognition
	 */
	@Override
	public String getDetailB() {
		return model.getDetailB();
	}

	/**
	 * Returns the detail c of this friendship recognition.
	 *
	 * @return the detail c of this friendship recognition
	 */
	@Override
	public String getDetailC() {
		return model.getDetailC();
	}

	/**
	 * Returns the mvcc version of this friendship recognition.
	 *
	 * @return the mvcc version of this friendship recognition
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this friendship recognition.
	 *
	 * @return the primary key of this friendship recognition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the recognition ID of this friendship recognition.
	 *
	 * @return the recognition ID of this friendship recognition
	 */
	@Override
	public long getRecognitionId() {
		return model.getRecognitionId();
	}

	/**
	 * Returns the uuid of this friendship recognition.
	 *
	 * @return the uuid of this friendship recognition
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the detail a of this friendship recognition.
	 *
	 * @param detailA the detail a of this friendship recognition
	 */
	@Override
	public void setDetailA(String detailA) {
		model.setDetailA(detailA);
	}

	/**
	 * Sets the detail b of this friendship recognition.
	 *
	 * @param detailB the detail b of this friendship recognition
	 */
	@Override
	public void setDetailB(String detailB) {
		model.setDetailB(detailB);
	}

	/**
	 * Sets the detail c of this friendship recognition.
	 *
	 * @param detailC the detail c of this friendship recognition
	 */
	@Override
	public void setDetailC(String detailC) {
		model.setDetailC(detailC);
	}

	/**
	 * Sets the mvcc version of this friendship recognition.
	 *
	 * @param mvccVersion the mvcc version of this friendship recognition
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this friendship recognition.
	 *
	 * @param primaryKey the primary key of this friendship recognition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the recognition ID of this friendship recognition.
	 *
	 * @param recognitionId the recognition ID of this friendship recognition
	 */
	@Override
	public void setRecognitionId(long recognitionId) {
		model.setRecognitionId(recognitionId);
	}

	/**
	 * Sets the uuid of this friendship recognition.
	 *
	 * @param uuid the uuid of this friendship recognition
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected FriendshipRecognitionWrapper wrap(
		FriendshipRecognition friendshipRecognition) {

		return new FriendshipRecognitionWrapper(friendshipRecognition);
	}

}