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

package hong.recog.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PerformanceRecognitionService}.
 *
 * @author hong
 * @see PerformanceRecognitionService
 * @generated
 */
public class PerformanceRecognitionServiceWrapper
	implements PerformanceRecognitionService,
			   ServiceWrapper<PerformanceRecognitionService> {

	public PerformanceRecognitionServiceWrapper(
		PerformanceRecognitionService performanceRecognitionService) {

		_performanceRecognitionService = performanceRecognitionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _performanceRecognitionService.getOSGiServiceIdentifier();
	}

	@Override
	public PerformanceRecognitionService getWrappedService() {
		return _performanceRecognitionService;
	}

	@Override
	public void setWrappedService(
		PerformanceRecognitionService performanceRecognitionService) {

		_performanceRecognitionService = performanceRecognitionService;
	}

	private PerformanceRecognitionService _performanceRecognitionService;

}