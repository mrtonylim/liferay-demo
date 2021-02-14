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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Recognition. This utility wraps
 * <code>hong.recog.service.impl.RecognitionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author hong
 * @see RecognitionLocalService
 * @generated
 */
public class RecognitionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>hong.recog.service.impl.RecognitionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static hong.recog.service.AddRecognitionResult addRecognition(
			long toUserId, String value, String subject,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addRecognition(
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
	public static hong.recog.model.Recognition addRecognition(
		hong.recog.model.Recognition recognition) {

		return getService().addRecognition(recognition);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new recognition with the primary key. Does not add the recognition to the database.
	 *
	 * @param recognitionId the primary key for the new recognition
	 * @return the new recognition
	 */
	public static hong.recog.model.Recognition createRecognition(
		long recognitionId) {

		return getService().createRecognition(recognitionId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static hong.recog.model.Recognition deleteRecognition(
			long recognitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRecognition(recognitionId);
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
	public static hong.recog.model.Recognition deleteRecognition(
		hong.recog.model.Recognition recognition) {

		return getService().deleteRecognition(recognition);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static hong.recog.model.Recognition fetchRecognition(
		long recognitionId) {

		return getService().fetchRecognition(recognitionId);
	}

	/**
	 * Returns the recognition matching the UUID and group.
	 *
	 * @param uuid the recognition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static hong.recog.model.Recognition fetchRecognitionByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchRecognitionByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the recognition with the primary key.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition
	 * @throws PortalException if a recognition with the primary key could not be found
	 */
	public static hong.recog.model.Recognition getRecognition(
			long recognitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRecognition(recognitionId);
	}

	/**
	 * Returns the recognition matching the UUID and group.
	 *
	 * @param uuid the recognition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching recognition
	 * @throws PortalException if a matching recognition could not be found
	 */
	public static hong.recog.model.Recognition getRecognitionByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRecognitionByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<hong.recog.model.Recognition> getRecognitions(
		int start, int end) {

		return getService().getRecognitions(start, end);
	}

	/**
	 * Returns all the recognitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the recognitions
	 * @param companyId the primary key of the company
	 * @return the matching recognitions, or an empty list if no matches were found
	 */
	public static java.util.List<hong.recog.model.Recognition>
		getRecognitionsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getRecognitionsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<hong.recog.model.Recognition>
		getRecognitionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<hong.recog.model.Recognition> orderByComparator) {

		return getService().getRecognitionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of recognitions.
	 *
	 * @return the number of recognitions
	 */
	public static int getRecognitionsCount() {
		return getService().getRecognitionsCount();
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
	public static hong.recog.model.Recognition updateRecognition(
		hong.recog.model.Recognition recognition) {

		return getService().updateRecognition(recognition);
	}

	public static RecognitionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RecognitionLocalService, RecognitionLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RecognitionLocalService.class);

		ServiceTracker<RecognitionLocalService, RecognitionLocalService>
			serviceTracker =
				new ServiceTracker
					<RecognitionLocalService, RecognitionLocalService>(
						bundle.getBundleContext(),
						RecognitionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}