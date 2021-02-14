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
 * Provides a wrapper for {@link RecognitionLocalService}.
 *
 * @author hong
 * @see RecognitionLocalService
 * @generated
 */
public class RecognitionLocalServiceWrapper
	implements RecognitionLocalService,
			   ServiceWrapper<RecognitionLocalService> {

	public RecognitionLocalServiceWrapper(
		RecognitionLocalService recognitionLocalService) {

		_recognitionLocalService = recognitionLocalService;
	}

	@Override
	public hong.recog.service.AddRecognitionResult addRecognition(
			long toUserId, String value, String subject,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _recognitionLocalService.addRecognition(
			toUserId, value, subject, serviceContext);
	}

	/**
	 * Adds the recognition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param recognition the recognition
	 * @return the recognition that was added
	 */
	@Override
	public hong.recog.model.Recognition addRecognition(
		hong.recog.model.Recognition recognition) {

		return _recognitionLocalService.addRecognition(recognition);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _recognitionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new recognition with the primary key. Does not add the recognition to the database.
	 *
	 * @param recognitionId the primary key for the new recognition
	 * @return the new recognition
	 */
	@Override
	public hong.recog.model.Recognition createRecognition(long recognitionId) {
		return _recognitionLocalService.createRecognition(recognitionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _recognitionLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition that was removed
	 * @throws PortalException if a recognition with the primary key could not be found
	 */
	@Override
	public hong.recog.model.Recognition deleteRecognition(long recognitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _recognitionLocalService.deleteRecognition(recognitionId);
	}

	/**
	 * Deletes the recognition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param recognition the recognition
	 * @return the recognition that was removed
	 */
	@Override
	public hong.recog.model.Recognition deleteRecognition(
		hong.recog.model.Recognition recognition) {

		return _recognitionLocalService.deleteRecognition(recognition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _recognitionLocalService.dynamicQuery();
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

		return _recognitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.RecognitionModelImpl</code>.
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

		return _recognitionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.RecognitionModelImpl</code>.
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

		return _recognitionLocalService.dynamicQuery(
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

		return _recognitionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _recognitionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public hong.recog.model.Recognition fetchRecognition(long recognitionId) {
		return _recognitionLocalService.fetchRecognition(recognitionId);
	}

	/**
	 * Returns the recognition matching the UUID and group.
	 *
	 * @param uuid the recognition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public hong.recog.model.Recognition fetchRecognitionByUuidAndGroupId(
		String uuid, long groupId) {

		return _recognitionLocalService.fetchRecognitionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _recognitionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _recognitionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _recognitionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _recognitionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _recognitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the recognition with the primary key.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition
	 * @throws PortalException if a recognition with the primary key could not be found
	 */
	@Override
	public hong.recog.model.Recognition getRecognition(long recognitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _recognitionLocalService.getRecognition(recognitionId);
	}

	/**
	 * Returns the recognition matching the UUID and group.
	 *
	 * @param uuid the recognition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching recognition
	 * @throws PortalException if a matching recognition could not be found
	 */
	@Override
	public hong.recog.model.Recognition getRecognitionByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _recognitionLocalService.getRecognitionByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @return the range of recognitions
	 */
	@Override
	public java.util.List<hong.recog.model.Recognition> getRecognitions(
		int start, int end) {

		return _recognitionLocalService.getRecognitions(start, end);
	}

	/**
	 * Returns all the recognitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the recognitions
	 * @param companyId the primary key of the company
	 * @return the matching recognitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<hong.recog.model.Recognition>
		getRecognitionsByUuidAndCompanyId(String uuid, long companyId) {

		return _recognitionLocalService.getRecognitionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of recognitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the recognitions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching recognitions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<hong.recog.model.Recognition>
		getRecognitionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<hong.recog.model.Recognition> orderByComparator) {

		return _recognitionLocalService.getRecognitionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of recognitions.
	 *
	 * @return the number of recognitions
	 */
	@Override
	public int getRecognitionsCount() {
		return _recognitionLocalService.getRecognitionsCount();
	}

	/**
	 * Updates the recognition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param recognition the recognition
	 * @return the recognition that was updated
	 */
	@Override
	public hong.recog.model.Recognition updateRecognition(
		hong.recog.model.Recognition recognition) {

		return _recognitionLocalService.updateRecognition(recognition);
	}

	@Override
	public RecognitionLocalService getWrappedService() {
		return _recognitionLocalService;
	}

	@Override
	public void setWrappedService(
		RecognitionLocalService recognitionLocalService) {

		_recognitionLocalService = recognitionLocalService;
	}

	private RecognitionLocalService _recognitionLocalService;

}