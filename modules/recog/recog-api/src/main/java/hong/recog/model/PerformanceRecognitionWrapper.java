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
 * This class is a wrapper for {@link PerformanceRecognition}.
 * </p>
 *
 * @author hong
 * @see PerformanceRecognition
 * @generated
 */
public class PerformanceRecognitionWrapper
	extends BaseModelWrapper<PerformanceRecognition>
	implements ModelWrapper<PerformanceRecognition>, PerformanceRecognition {

	public PerformanceRecognitionWrapper(
		PerformanceRecognition performanceRecognition) {

		super(performanceRecognition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("recognitionId", getRecognitionId());
		attributes.put("detail1", getDetail1());
		attributes.put("detail2", getDetail2());

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

		String detail1 = (String)attributes.get("detail1");

		if (detail1 != null) {
			setDetail1(detail1);
		}

		String detail2 = (String)attributes.get("detail2");

		if (detail2 != null) {
			setDetail2(detail2);
		}
	}

	/**
	 * Returns the detail1 of this performance recognition.
	 *
	 * @return the detail1 of this performance recognition
	 */
	@Override
	public String getDetail1() {
		return model.getDetail1();
	}

	/**
	 * Returns the detail2 of this performance recognition.
	 *
	 * @return the detail2 of this performance recognition
	 */
	@Override
	public String getDetail2() {
		return model.getDetail2();
	}

	/**
	 * Returns the mvcc version of this performance recognition.
	 *
	 * @return the mvcc version of this performance recognition
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this performance recognition.
	 *
	 * @return the primary key of this performance recognition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the recognition ID of this performance recognition.
	 *
	 * @return the recognition ID of this performance recognition
	 */
	@Override
	public long getRecognitionId() {
		return model.getRecognitionId();
	}

	/**
	 * Returns the uuid of this performance recognition.
	 *
	 * @return the uuid of this performance recognition
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
	 * Sets the detail1 of this performance recognition.
	 *
	 * @param detail1 the detail1 of this performance recognition
	 */
	@Override
	public void setDetail1(String detail1) {
		model.setDetail1(detail1);
	}

	/**
	 * Sets the detail2 of this performance recognition.
	 *
	 * @param detail2 the detail2 of this performance recognition
	 */
	@Override
	public void setDetail2(String detail2) {
		model.setDetail2(detail2);
	}

	/**
	 * Sets the mvcc version of this performance recognition.
	 *
	 * @param mvccVersion the mvcc version of this performance recognition
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this performance recognition.
	 *
	 * @param primaryKey the primary key of this performance recognition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the recognition ID of this performance recognition.
	 *
	 * @param recognitionId the recognition ID of this performance recognition
	 */
	@Override
	public void setRecognitionId(long recognitionId) {
		model.setRecognitionId(recognitionId);
	}

	/**
	 * Sets the uuid of this performance recognition.
	 *
	 * @param uuid the uuid of this performance recognition
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PerformanceRecognitionWrapper wrap(
		PerformanceRecognition performanceRecognition) {

		return new PerformanceRecognitionWrapper(performanceRecognition);
	}

}