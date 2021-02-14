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

package hong.recog.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hong.recog.model.FriendshipRecognition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the friendship recognition service. This utility wraps <code>hong.recog.service.persistence.impl.FriendshipRecognitionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @see FriendshipRecognitionPersistence
 * @generated
 */
public class FriendshipRecognitionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(FriendshipRecognition friendshipRecognition) {
		getPersistence().clearCache(friendshipRecognition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, FriendshipRecognition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FriendshipRecognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FriendshipRecognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FriendshipRecognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FriendshipRecognition update(
		FriendshipRecognition friendshipRecognition) {

		return getPersistence().update(friendshipRecognition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FriendshipRecognition update(
		FriendshipRecognition friendshipRecognition,
		ServiceContext serviceContext) {

		return getPersistence().update(friendshipRecognition, serviceContext);
	}

	/**
	 * Returns all the friendship recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching friendship recognitions
	 */
	public static List<FriendshipRecognition> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the friendship recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FriendshipRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of friendship recognitions
	 * @param end the upper bound of the range of friendship recognitions (not inclusive)
	 * @return the range of matching friendship recognitions
	 */
	public static List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the friendship recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FriendshipRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of friendship recognitions
	 * @param end the upper bound of the range of friendship recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching friendship recognitions
	 */
	public static List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the friendship recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FriendshipRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of friendship recognitions
	 * @param end the upper bound of the range of friendship recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching friendship recognitions
	 */
	public static List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	public static FriendshipRecognition findByUuid_First(
			String uuid,
			OrderByComparator<FriendshipRecognition> orderByComparator)
		throws hong.recog.exception.NoSuchFriendshipRecognitionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	public static FriendshipRecognition fetchByUuid_First(
		String uuid,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	public static FriendshipRecognition findByUuid_Last(
			String uuid,
			OrderByComparator<FriendshipRecognition> orderByComparator)
		throws hong.recog.exception.NoSuchFriendshipRecognitionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	public static FriendshipRecognition fetchByUuid_Last(
		String uuid,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the friendship recognitions before and after the current friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param recognitionId the primary key of the current friendship recognition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	public static FriendshipRecognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			OrderByComparator<FriendshipRecognition> orderByComparator)
		throws hong.recog.exception.NoSuchFriendshipRecognitionException {

		return getPersistence().findByUuid_PrevAndNext(
			recognitionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the friendship recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of friendship recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching friendship recognitions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or throws a <code>NoSuchFriendshipRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	public static FriendshipRecognition findByRecognitionId(long recognitionId)
		throws hong.recog.exception.NoSuchFriendshipRecognitionException {

		return getPersistence().findByRecognitionId(recognitionId);
	}

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	public static FriendshipRecognition fetchByRecognitionId(
		long recognitionId) {

		return getPersistence().fetchByRecognitionId(recognitionId);
	}

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	public static FriendshipRecognition fetchByRecognitionId(
		long recognitionId, boolean useFinderCache) {

		return getPersistence().fetchByRecognitionId(
			recognitionId, useFinderCache);
	}

	/**
	 * Removes the friendship recognition where recognitionId = &#63; from the database.
	 *
	 * @param recognitionId the recognition ID
	 * @return the friendship recognition that was removed
	 */
	public static FriendshipRecognition removeByRecognitionId(
			long recognitionId)
		throws hong.recog.exception.NoSuchFriendshipRecognitionException {

		return getPersistence().removeByRecognitionId(recognitionId);
	}

	/**
	 * Returns the number of friendship recognitions where recognitionId = &#63;.
	 *
	 * @param recognitionId the recognition ID
	 * @return the number of matching friendship recognitions
	 */
	public static int countByRecognitionId(long recognitionId) {
		return getPersistence().countByRecognitionId(recognitionId);
	}

	/**
	 * Caches the friendship recognition in the entity cache if it is enabled.
	 *
	 * @param friendshipRecognition the friendship recognition
	 */
	public static void cacheResult(
		FriendshipRecognition friendshipRecognition) {

		getPersistence().cacheResult(friendshipRecognition);
	}

	/**
	 * Caches the friendship recognitions in the entity cache if it is enabled.
	 *
	 * @param friendshipRecognitions the friendship recognitions
	 */
	public static void cacheResult(
		List<FriendshipRecognition> friendshipRecognitions) {

		getPersistence().cacheResult(friendshipRecognitions);
	}

	/**
	 * Creates a new friendship recognition with the primary key. Does not add the friendship recognition to the database.
	 *
	 * @param recognitionId the primary key for the new friendship recognition
	 * @return the new friendship recognition
	 */
	public static FriendshipRecognition create(long recognitionId) {
		return getPersistence().create(recognitionId);
	}

	/**
	 * Removes the friendship recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition that was removed
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	public static FriendshipRecognition remove(long recognitionId)
		throws hong.recog.exception.NoSuchFriendshipRecognitionException {

		return getPersistence().remove(recognitionId);
	}

	public static FriendshipRecognition updateImpl(
		FriendshipRecognition friendshipRecognition) {

		return getPersistence().updateImpl(friendshipRecognition);
	}

	/**
	 * Returns the friendship recognition with the primary key or throws a <code>NoSuchFriendshipRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	public static FriendshipRecognition findByPrimaryKey(long recognitionId)
		throws hong.recog.exception.NoSuchFriendshipRecognitionException {

		return getPersistence().findByPrimaryKey(recognitionId);
	}

	/**
	 * Returns the friendship recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition, or <code>null</code> if a friendship recognition with the primary key could not be found
	 */
	public static FriendshipRecognition fetchByPrimaryKey(long recognitionId) {
		return getPersistence().fetchByPrimaryKey(recognitionId);
	}

	/**
	 * Returns all the friendship recognitions.
	 *
	 * @return the friendship recognitions
	 */
	public static List<FriendshipRecognition> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the friendship recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FriendshipRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of friendship recognitions
	 * @param end the upper bound of the range of friendship recognitions (not inclusive)
	 * @return the range of friendship recognitions
	 */
	public static List<FriendshipRecognition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the friendship recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FriendshipRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of friendship recognitions
	 * @param end the upper bound of the range of friendship recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of friendship recognitions
	 */
	public static List<FriendshipRecognition> findAll(
		int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the friendship recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FriendshipRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of friendship recognitions
	 * @param end the upper bound of the range of friendship recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of friendship recognitions
	 */
	public static List<FriendshipRecognition> findAll(
		int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the friendship recognitions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of friendship recognitions.
	 *
	 * @return the number of friendship recognitions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FriendshipRecognitionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FriendshipRecognitionPersistence, FriendshipRecognitionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			FriendshipRecognitionPersistence.class);

		ServiceTracker
			<FriendshipRecognitionPersistence, FriendshipRecognitionPersistence>
				serviceTracker =
					new ServiceTracker
						<FriendshipRecognitionPersistence,
						 FriendshipRecognitionPersistence>(
							 bundle.getBundleContext(),
							 FriendshipRecognitionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}