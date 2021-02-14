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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import hong.recog.model.FriendshipRecognition;
import hong.recog.model.FriendshipRecognitionModel;
import hong.recog.model.FriendshipRecognitionSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the FriendshipRecognition service. Represents a row in the &quot;RECOG_FriendshipRecognition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FriendshipRecognitionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FriendshipRecognitionImpl}.
 * </p>
 *
 * @author hong
 * @see FriendshipRecognitionImpl
 * @generated
 */
@JSON(strict = true)
public class FriendshipRecognitionModelImpl
	extends BaseModelImpl<FriendshipRecognition>
	implements FriendshipRecognitionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a friendship recognition model instance should use the <code>FriendshipRecognition</code> interface instead.
	 */
	public static final String TABLE_NAME = "RECOG_FriendshipRecognition";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"recognitionId", Types.BIGINT}, {"detailA", Types.VARCHAR},
		{"detailB", Types.VARCHAR}, {"detailC", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("recognitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("detailA", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("detailB", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("detailC", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table RECOG_FriendshipRecognition (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,recognitionId LONG not null primary key,detailA VARCHAR(75) null,detailB VARCHAR(75) null,detailC VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table RECOG_FriendshipRecognition";

	public static final String ORDER_BY_JPQL =
		" ORDER BY friendshipRecognition.recognitionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY RECOG_FriendshipRecognition.recognitionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long RECOGNITIONID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static FriendshipRecognition toModel(
		FriendshipRecognitionSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		FriendshipRecognition model = new FriendshipRecognitionImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setRecognitionId(soapModel.getRecognitionId());
		model.setDetailA(soapModel.getDetailA());
		model.setDetailB(soapModel.getDetailB());
		model.setDetailC(soapModel.getDetailC());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<FriendshipRecognition> toModels(
		FriendshipRecognitionSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<FriendshipRecognition> models =
			new ArrayList<FriendshipRecognition>(soapModels.length);

		for (FriendshipRecognitionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public FriendshipRecognitionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _recognitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRecognitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recognitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FriendshipRecognition.class;
	}

	@Override
	public String getModelClassName() {
		return FriendshipRecognition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FriendshipRecognition, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FriendshipRecognition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FriendshipRecognition, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FriendshipRecognition)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FriendshipRecognition, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FriendshipRecognition, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FriendshipRecognition)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FriendshipRecognition, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FriendshipRecognition, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, FriendshipRecognition>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			FriendshipRecognition.class.getClassLoader(),
			FriendshipRecognition.class, ModelWrapper.class);

		try {
			Constructor<FriendshipRecognition> constructor =
				(Constructor<FriendshipRecognition>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<FriendshipRecognition, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FriendshipRecognition, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FriendshipRecognition, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<FriendshipRecognition, Object>>();
		Map<String, BiConsumer<FriendshipRecognition, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<FriendshipRecognition, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", FriendshipRecognition::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<FriendshipRecognition, Long>)
				FriendshipRecognition::setMvccVersion);
		attributeGetterFunctions.put("uuid", FriendshipRecognition::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<FriendshipRecognition, String>)
				FriendshipRecognition::setUuid);
		attributeGetterFunctions.put(
			"recognitionId", FriendshipRecognition::getRecognitionId);
		attributeSetterBiConsumers.put(
			"recognitionId",
			(BiConsumer<FriendshipRecognition, Long>)
				FriendshipRecognition::setRecognitionId);
		attributeGetterFunctions.put(
			"detailA", FriendshipRecognition::getDetailA);
		attributeSetterBiConsumers.put(
			"detailA",
			(BiConsumer<FriendshipRecognition, String>)
				FriendshipRecognition::setDetailA);
		attributeGetterFunctions.put(
			"detailB", FriendshipRecognition::getDetailB);
		attributeSetterBiConsumers.put(
			"detailB",
			(BiConsumer<FriendshipRecognition, String>)
				FriendshipRecognition::setDetailB);
		attributeGetterFunctions.put(
			"detailC", FriendshipRecognition::getDetailC);
		attributeSetterBiConsumers.put(
			"detailC",
			(BiConsumer<FriendshipRecognition, String>)
				FriendshipRecognition::setDetailC);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getRecognitionId() {
		return _recognitionId;
	}

	@Override
	public void setRecognitionId(long recognitionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_recognitionId = recognitionId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalRecognitionId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("recognitionId"));
	}

	@JSON
	@Override
	public String getDetailA() {
		if (_detailA == null) {
			return "";
		}
		else {
			return _detailA;
		}
	}

	@Override
	public void setDetailA(String detailA) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_detailA = detailA;
	}

	@JSON
	@Override
	public String getDetailB() {
		if (_detailB == null) {
			return "";
		}
		else {
			return _detailB;
		}
	}

	@Override
	public void setDetailB(String detailB) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_detailB = detailB;
	}

	@JSON
	@Override
	public String getDetailC() {
		if (_detailC == null) {
			return "";
		}
		else {
			return _detailC;
		}
	}

	@Override
	public void setDetailC(String detailC) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_detailC = detailC;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, FriendshipRecognition.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FriendshipRecognition toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FriendshipRecognition>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FriendshipRecognitionImpl friendshipRecognitionImpl =
			new FriendshipRecognitionImpl();

		friendshipRecognitionImpl.setMvccVersion(getMvccVersion());
		friendshipRecognitionImpl.setUuid(getUuid());
		friendshipRecognitionImpl.setRecognitionId(getRecognitionId());
		friendshipRecognitionImpl.setDetailA(getDetailA());
		friendshipRecognitionImpl.setDetailB(getDetailB());
		friendshipRecognitionImpl.setDetailC(getDetailC());

		friendshipRecognitionImpl.resetOriginalValues();

		return friendshipRecognitionImpl;
	}

	@Override
	public int compareTo(FriendshipRecognition friendshipRecognition) {
		long primaryKey = friendshipRecognition.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FriendshipRecognition)) {
			return false;
		}

		FriendshipRecognition friendshipRecognition =
			(FriendshipRecognition)object;

		long primaryKey = friendshipRecognition.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<FriendshipRecognition> toCacheModel() {
		FriendshipRecognitionCacheModel friendshipRecognitionCacheModel =
			new FriendshipRecognitionCacheModel();

		friendshipRecognitionCacheModel.mvccVersion = getMvccVersion();

		friendshipRecognitionCacheModel.uuid = getUuid();

		String uuid = friendshipRecognitionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			friendshipRecognitionCacheModel.uuid = null;
		}

		friendshipRecognitionCacheModel.recognitionId = getRecognitionId();

		friendshipRecognitionCacheModel.detailA = getDetailA();

		String detailA = friendshipRecognitionCacheModel.detailA;

		if ((detailA != null) && (detailA.length() == 0)) {
			friendshipRecognitionCacheModel.detailA = null;
		}

		friendshipRecognitionCacheModel.detailB = getDetailB();

		String detailB = friendshipRecognitionCacheModel.detailB;

		if ((detailB != null) && (detailB.length() == 0)) {
			friendshipRecognitionCacheModel.detailB = null;
		}

		friendshipRecognitionCacheModel.detailC = getDetailC();

		String detailC = friendshipRecognitionCacheModel.detailC;

		if ((detailC != null) && (detailC.length() == 0)) {
			friendshipRecognitionCacheModel.detailC = null;
		}

		return friendshipRecognitionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FriendshipRecognition, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FriendshipRecognition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FriendshipRecognition, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((FriendshipRecognition)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<FriendshipRecognition, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FriendshipRecognition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FriendshipRecognition, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((FriendshipRecognition)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, FriendshipRecognition>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private String _uuid;
	private long _recognitionId;
	private String _detailA;
	private String _detailB;
	private String _detailC;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<FriendshipRecognition, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FriendshipRecognition)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("recognitionId", _recognitionId);
		_columnOriginalValues.put("detailA", _detailA);
		_columnOriginalValues.put("detailB", _detailB);
		_columnOriginalValues.put("detailC", _detailC);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("uuid_", 2L);

		columnBitmasks.put("recognitionId", 4L);

		columnBitmasks.put("detailA", 8L);

		columnBitmasks.put("detailB", 16L);

		columnBitmasks.put("detailC", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FriendshipRecognition _escapedModel;

}