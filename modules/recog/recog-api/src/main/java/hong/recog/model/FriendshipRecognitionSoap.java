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
 * This class is used by SOAP remote services, specifically {@link hong.recog.service.http.FriendshipRecognitionServiceSoap}.
 *
 * @author hong
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class FriendshipRecognitionSoap implements Serializable {

	public static FriendshipRecognitionSoap toSoapModel(
		FriendshipRecognition model) {

		FriendshipRecognitionSoap soapModel = new FriendshipRecognitionSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setRecognitionId(model.getRecognitionId());
		soapModel.setDetailA(model.getDetailA());
		soapModel.setDetailB(model.getDetailB());
		soapModel.setDetailC(model.getDetailC());

		return soapModel;
	}

	public static FriendshipRecognitionSoap[] toSoapModels(
		FriendshipRecognition[] models) {

		FriendshipRecognitionSoap[] soapModels =
			new FriendshipRecognitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FriendshipRecognitionSoap[][] toSoapModels(
		FriendshipRecognition[][] models) {

		FriendshipRecognitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new FriendshipRecognitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FriendshipRecognitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FriendshipRecognitionSoap[] toSoapModels(
		List<FriendshipRecognition> models) {

		List<FriendshipRecognitionSoap> soapModels =
			new ArrayList<FriendshipRecognitionSoap>(models.size());

		for (FriendshipRecognition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new FriendshipRecognitionSoap[soapModels.size()]);
	}

	public FriendshipRecognitionSoap() {
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

	public String getDetailA() {
		return _detailA;
	}

	public void setDetailA(String detailA) {
		_detailA = detailA;
	}

	public String getDetailB() {
		return _detailB;
	}

	public void setDetailB(String detailB) {
		_detailB = detailB;
	}

	public String getDetailC() {
		return _detailC;
	}

	public void setDetailC(String detailC) {
		_detailC = detailC;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _recognitionId;
	private String _detailA;
	private String _detailB;
	private String _detailC;

}