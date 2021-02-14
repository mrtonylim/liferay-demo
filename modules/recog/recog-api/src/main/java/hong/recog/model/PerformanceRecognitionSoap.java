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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link hong.recog.service.http.PerformanceRecognitionServiceSoap}.
 *
 * @author hong
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PerformanceRecognitionSoap implements Serializable {

	public static PerformanceRecognitionSoap toSoapModel(
		PerformanceRecognition model) {

		PerformanceRecognitionSoap soapModel = new PerformanceRecognitionSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setRecognitionId(model.getRecognitionId());
		soapModel.setDetail1(model.getDetail1());
		soapModel.setDetail2(model.getDetail2());

		return soapModel;
	}

	public static PerformanceRecognitionSoap[] toSoapModels(
		PerformanceRecognition[] models) {

		PerformanceRecognitionSoap[] soapModels =
			new PerformanceRecognitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PerformanceRecognitionSoap[][] toSoapModels(
		PerformanceRecognition[][] models) {

		PerformanceRecognitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PerformanceRecognitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PerformanceRecognitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PerformanceRecognitionSoap[] toSoapModels(
		List<PerformanceRecognition> models) {

		List<PerformanceRecognitionSoap> soapModels =
			new ArrayList<PerformanceRecognitionSoap>(models.size());

		for (PerformanceRecognition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PerformanceRecognitionSoap[soapModels.size()]);
	}

	public PerformanceRecognitionSoap() {
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

	public String getDetail1() {
		return _detail1;
	}

	public void setDetail1(String detail1) {
		_detail1 = detail1;
	}

	public String getDetail2() {
		return _detail2;
	}

	public void setDetail2(String detail2) {
		_detail2 = detail2;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _recognitionId;
	private String _detail1;
	private String _detail2;

}