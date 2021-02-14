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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PerformanceRecognition service. Represents a row in the &quot;RECOG_PerformanceRecognition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>hong.recog.model.impl.PerformanceRecognitionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>hong.recog.model.impl.PerformanceRecognitionImpl</code>.
 * </p>
 *
 * @author hong
 * @see PerformanceRecognition
 * @generated
 */
@ProviderType
public interface PerformanceRecognitionModel
	extends BaseModel<PerformanceRecognition>, MVCCModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a performance recognition model instance should use the {@link PerformanceRecognition} interface instead.
	 */

	/**
	 * Returns the primary key of this performance recognition.
	 *
	 * @return the primary key of this performance recognition
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this performance recognition.
	 *
	 * @param primaryKey the primary key of this performance recognition
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this performance recognition.
	 *
	 * @return the mvcc version of this performance recognition
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this performance recognition.
	 *
	 * @param mvccVersion the mvcc version of this performance recognition
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this performance recognition.
	 *
	 * @return the uuid of this performance recognition
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this performance recognition.
	 *
	 * @param uuid the uuid of this performance recognition
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the recognition ID of this performance recognition.
	 *
	 * @return the recognition ID of this performance recognition
	 */
	public long getRecognitionId();

	/**
	 * Sets the recognition ID of this performance recognition.
	 *
	 * @param recognitionId the recognition ID of this performance recognition
	 */
	public void setRecognitionId(long recognitionId);

	/**
	 * Returns the detail1 of this performance recognition.
	 *
	 * @return the detail1 of this performance recognition
	 */
	@AutoEscape
	public String getDetail1();

	/**
	 * Sets the detail1 of this performance recognition.
	 *
	 * @param detail1 the detail1 of this performance recognition
	 */
	public void setDetail1(String detail1);

	/**
	 * Returns the detail2 of this performance recognition.
	 *
	 * @return the detail2 of this performance recognition
	 */
	@AutoEscape
	public String getDetail2();

	/**
	 * Sets the detail2 of this performance recognition.
	 *
	 * @param detail2 the detail2 of this performance recognition
	 */
	public void setDetail2(String detail2);

}