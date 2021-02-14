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
 * Provides the local service utility for FriendshipRecognition. This utility wraps
 * <code>hong.recog.service.impl.FriendshipRecognitionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author hong
 * @see FriendshipRecognitionLocalService
 * @generated
 */
public class FriendshipRecognitionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>hong.recog.service.impl.FriendshipRecognitionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the friendship recognition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FriendshipRecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param friendshipRecognition the friendship recognition
	 * @return the friendship recognition that was added
	 */
	public static hong.recog.model.FriendshipRecognition
		addFriendshipRecognition(
			hong.recog.model.FriendshipRecognition friendshipRecognition) {

		return getService().addFriendshipRecognition(friendshipRecognition);
	}

	public static hong.recog.model.FriendshipRecognition
		addFriendshipRecognition(
			long recognitionId, String detailA, String detailB,
			String detailC) {

		return getService().addFriendshipRecognition(
			recognitionId, detailA, detailB, detailC);
	}

	/**
	 * Creates a new friendship recognition with the primary key. Does not add the friendship recognition to the database.
	 *
	 * @param recognitionId the primary key for the new friendship recognition
	 * @return the new friendship recognition
	 */
	public static hong.recog.model.FriendshipRecognition
		createFriendshipRecognition(long recognitionId) {

		return getService().createFriendshipRecognition(recognitionId);
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
	 * Deletes the friendship recognition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FriendshipRecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param friendshipRecognition the friendship recognition
	 * @return the friendship recognition that was removed
	 */
	public static hong.recog.model.FriendshipRecognition
		deleteFriendshipRecognition(
			hong.recog.model.FriendshipRecognition friendshipRecognition) {

		return getService().deleteFriendshipRecognition(friendshipRecognition);
	}

	/**
	 * Deletes the friendship recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FriendshipRecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition that was removed
	 * @throws PortalException if a friendship recognition with the primary key could not be found
	 */
	public static hong.recog.model.FriendshipRecognition
			deleteFriendshipRecognition(long recognitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFriendshipRecognition(recognitionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.FriendshipRecognitionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.FriendshipRecognitionModelImpl</code>.
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

	public static hong.recog.model.FriendshipRecognition
		fetchFriendshipRecognition(long recognitionId) {

		return getService().fetchFriendshipRecognition(recognitionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the friendship recognition with the primary key.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition
	 * @throws PortalException if a friendship recognition with the primary key could not be found
	 */
	public static hong.recog.model.FriendshipRecognition
			getFriendshipRecognition(long recognitionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFriendshipRecognition(recognitionId);
	}

	/**
	 * Returns a range of all the friendship recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>hong.recog.model.impl.FriendshipRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of friendship recognitions
	 * @param end the upper bound of the range of friendship recognitions (not inclusive)
	 * @return the range of friendship recognitions
	 */
	public static java.util.List<hong.recog.model.FriendshipRecognition>
		getFriendshipRecognitions(int start, int end) {

		return getService().getFriendshipRecognitions(start, end);
	}

	/**
	 * Returns the number of friendship recognitions.
	 *
	 * @return the number of friendship recognitions
	 */
	public static int getFriendshipRecognitionsCount() {
		return getService().getFriendshipRecognitionsCount();
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
	 * Updates the friendship recognition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FriendshipRecognitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param friendshipRecognition the friendship recognition
	 * @return the friendship recognition that was updated
	 */
	public static hong.recog.model.FriendshipRecognition
		updateFriendshipRecognition(
			hong.recog.model.FriendshipRecognition friendshipRecognition) {

		return getService().updateFriendshipRecognition(friendshipRecognition);
	}

	public static FriendshipRecognitionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FriendshipRecognitionLocalService, FriendshipRecognitionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			FriendshipRecognitionLocalService.class);

		ServiceTracker
			<FriendshipRecognitionLocalService,
			 FriendshipRecognitionLocalService> serviceTracker =
				new ServiceTracker
					<FriendshipRecognitionLocalService,
					 FriendshipRecognitionLocalService>(
						 bundle.getBundleContext(),
						 FriendshipRecognitionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}