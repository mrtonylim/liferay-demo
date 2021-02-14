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
 * Provides a wrapper for {@link PerformanceRecognitionLocalService}.
 *
 * @author hong
 * @see PerformanceRecognitionLocalService
 * @generated
 */
public class PerformanceRecognitionLocalServiceWrapper
	implements PerformanceRecognitionLocalService,
			   ServiceWrapper<PerformanceRecognitionLocalService> {

	public PerformanceRecognitionLocalServiceWrapper(
		PerformanceRecognitionLocalService performanceRecognitionLocalService) {

		_performanceRecognitionLocalService =
			performanceRecognitionLocalService;
	}

	@Override
	public hong.recog.model.PerformanceRecognition addPerformanceRecognition(
		long recognitionId, String detail1, String detail2) {

		return _performanceRecognitionLocalService.addPerformanceRecognition(
			recognitionId, detail1, detail2);
	}

	/**
	 * Adds the performance recognition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PerformanceRecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param performanceRecognition the performance recognition
	 * @return the performance recognition that was added
	 */
	@Override
	public hong.recog.model.PerformanceRecognition addPerformanceRecognition(
		hong.recog.model.PerformanceRecognition performanceRecognition) {

		return _performanceRecognitionLocalService.addPerformanceRecognition(
			performanceRecognition);
	}

	/**
	 * Creates a new performance recognition with the primary key. Does not add the performance recognition to the database.
	 *
	 * @param recognitionId the primary key for the new performance recognition
	 * @return the new performance recognition
	 */
	@Override
	public hong.recog.model.PerformanceRecognition createPerformanceRecognition(
		long recognitionId) {

		return _performanceRecognitionLocalService.createPerformanceRecognition(
			recognitionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _performanceRecognitionLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the performance recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PerformanceRecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition that was removed
	 * @throws PortalException if a performance recognition with the primary key could not be found
	 */
	@Override
	public hong.recog.model.PerformanceRecognition deletePerformanceRecognition(
			long recognitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _performanceRecognitionLocalService.deletePerformanceRecognition(
			recognitionId);
	}

	/**
	 * Deletes the performance recognition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PerformanceRecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param performanceRecognition the performance recognition
	 * @return the performance recognition that was removed
	 */
	@Override
	public hong.recog.model.PerformanceRecognition deletePerformanceRecognition(
		hong.recog.model.PerformanceRecognition performanceRecognition) {

		return _performanceRecognitionLocalService.deletePerformanceRecognition(
			performanceRecognition);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _performanceRecognitionLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _performanceRecognitionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _performanceRecognitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _performanceRecognitionLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _performanceRecognitionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _performanceRecognitionLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _performanceRecognitionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hong.recog.model.PerformanceRecognition fetchPerformanceRecognition(
		long recognitionId) {

		return _performanceRecognitionLocalService.fetchPerformanceRecognition(
			recognitionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _performanceRecognitionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _performanceRecognitionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _performanceRecognitionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the performance recognition with the primary key.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition
	 * @throws PortalException if a performance recognition with the primary key could not be found
	 */
	@Override
	public hong.recog.model.PerformanceRecognition getPerformanceRecognition(
			long recognitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _performanceRecognitionLocalService.getPerformanceRecognition(
			recognitionId);
	}

	/**
	 * Returns a range of all the performance recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of performance recognitions
	 * @param end the upper bound of the range of performance recognitions (not inclusive)
	 * @return the range of performance recognitions
	 */
	@Override
	public java.util.List<hong.recog.model.PerformanceRecognition>
		getPerformanceRecognitions(int start, int end) {

		return _performanceRecognitionLocalService.getPerformanceRecognitions(
			start, end);
	}

	/**
	 * Returns the number of performance recognitions.
	 *
	 * @return the number of performance recognitions
	 */
	@Override
	public int getPerformanceRecognitionsCount() {
		return _performanceRecognitionLocalService.
			getPerformanceRecognitionsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _performanceRecognitionLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the performance recognition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PerformanceRecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param performanceRecognition the performance recognition
	 * @return the performance recognition that was updated
	 */
	@Override
	public hong.recog.model.PerformanceRecognition updatePerformanceRecognition(
		hong.recog.model.PerformanceRecognition performanceRecognition) {

		return _performanceRecognitionLocalService.updatePerformanceRecognition(
			performanceRecognition);
	}

	@Override
	public PerformanceRecognitionLocalService getWrappedService() {
		return _performanceRecognitionLocalService;
	}

	@Override
	public void setWrappedService(
		PerformanceRecognitionLocalService performanceRecognitionLocalService) {

		_performanceRecognitionLocalService =
			performanceRecognitionLocalService;
	}

	private PerformanceRecognitionLocalService
		_performanceRecognitionLocalService;

}