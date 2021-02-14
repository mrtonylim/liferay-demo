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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Recognition service. Represents a row in the &quot;RECOG_Recognition&quot; database table, with each column mapped to a property of this class.
 *
 * @author hong
 * @see RecognitionModel
 * @generated
 */
@ImplementationClassName("hong.recog.model.impl.RecognitionImpl")
@ProviderType
public interface Recognition extends PersistedModel, RecognitionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>hong.recog.model.impl.RecognitionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Recognition, Long> RECOGNITION_ID_ACCESSOR =
		new Accessor<Recognition, Long>() {

			@Override
			public Long get(Recognition recognition) {
				return recognition.getRecognitionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Recognition> getTypeClass() {
				return Recognition.class;
			}

		};

}