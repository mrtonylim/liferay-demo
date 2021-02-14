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

import hong.recog.model.PerformanceRecognition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the performance recognition service. This utility wraps <code>hong.recog.service.persistence.impl.PerformanceRecognitionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @see PerformanceRecognitionPersistence
 * @generated
 */
public class PerformanceRecognitionUtil {

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
	public static void clearCache(
		PerformanceRecognition performanceRecognition) {

		getPersistence().clearCache(performanceRecognition);
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
	public static Map<Serializable, PerformanceRecognition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PerformanceRecognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PerformanceRecognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PerformanceRecognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PerformanceRecognition update(
		PerformanceRecognition performanceRecognition) {

		return getPersistence().update(performanceRecognition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PerformanceRecognition update(
		PerformanceRecognition performanceRecognition,
		ServiceContext serviceContext) {

		return getPersistence().update(performanceRecognition, serviceContext);
	}

	/**
	 * Returns all the performance recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching performance recognitions
	 */
	public static List<PerformanceRecognition> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the performance recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of performance recognitions
	 * @param end the upper bound of the range of performance recognitions (not inclusive)
	 * @return the range of matching performance recognitions
	 */
	public static List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the performance recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of performance recognitions
	 * @param end the upper bound of the range of performance recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching performance recognitions
	 */
	public static List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the performance recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of performance recognitions
	 * @param end the upper bound of the range of performance recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching performance recognitions
	 */
	public static List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	public static PerformanceRecognition findByUuid_First(
			String uuid,
			OrderByComparator<PerformanceRecognition> orderByComparator)
		throws hong.recog.exception.NoSuchPerformanceRecognitionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	public static PerformanceRecognition fetchByUuid_First(
		String uuid,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	public static PerformanceRecognition findByUuid_Last(
			String uuid,
			OrderByComparator<PerformanceRecognition> orderByComparator)
		throws hong.recog.exception.NoSuchPerformanceRecognitionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	public static PerformanceRecognition fetchByUuid_Last(
		String uuid,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the performance recognitions before and after the current performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param recognitionId the primary key of the current performance recognition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	public static PerformanceRecognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			OrderByComparator<PerformanceRecognition> orderByComparator)
		throws hong.recog.exception.NoSuchPerformanceRecognitionException {

		return getPersistence().findByUuid_PrevAndNext(
			recognitionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the performance recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of performance recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching performance recognitions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the performance recognition where recognitionId = &#63; or throws a <code>NoSuchPerformanceRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	public static PerformanceRecognition findByRecognitionId(long recognitionId)
		throws hong.recog.exception.NoSuchPerformanceRecognitionException {

		return getPersistence().findByRecognitionId(recognitionId);
	}

	/**
	 * Returns the performance recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	public static PerformanceRecognition fetchByRecognitionId(
		long recognitionId) {

		return getPersistence().fetchByRecognitionId(recognitionId);
	}

	/**
	 * Returns the performance recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	public static PerformanceRecognition fetchByRecognitionId(
		long recognitionId, boolean useFinderCache) {

		return getPersistence().fetchByRecognitionId(
			recognitionId, useFinderCache);
	}

	/**
	 * Removes the performance recognition where recognitionId = &#63; from the database.
	 *
	 * @param recognitionId the recognition ID
	 * @return the performance recognition that was removed
	 */
	public static PerformanceRecognition removeByRecognitionId(
			long recognitionId)
		throws hong.recog.exception.NoSuchPerformanceRecognitionException {

		return getPersistence().removeByRecognitionId(recognitionId);
	}

	/**
	 * Returns the number of performance recognitions where recognitionId = &#63;.
	 *
	 * @param recognitionId the recognition ID
	 * @return the number of matching performance recognitions
	 */
	public static int countByRecognitionId(long recognitionId) {
		return getPersistence().countByRecognitionId(recognitionId);
	}

	/**
	 * Caches the performance recognition in the entity cache if it is enabled.
	 *
	 * @param performanceRecognition the performance recognition
	 */
	public static void cacheResult(
		PerformanceRecognition performanceRecognition) {

		getPersistence().cacheResult(performanceRecognition);
	}

	/**
	 * Caches the performance recognitions in the entity cache if it is enabled.
	 *
	 * @param performanceRecognitions the performance recognitions
	 */
	public static void cacheResult(
		List<PerformanceRecognition> performanceRecognitions) {

		getPersistence().cacheResult(performanceRecognitions);
	}

	/**
	 * Creates a new performance recognition with the primary key. Does not add the performance recognition to the database.
	 *
	 * @param recognitionId the primary key for the new performance recognition
	 * @return the new performance recognition
	 */
	public static PerformanceRecognition create(long recognitionId) {
		return getPersistence().create(recognitionId);
	}

	/**
	 * Removes the performance recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition that was removed
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	public static PerformanceRecognition remove(long recognitionId)
		throws hong.recog.exception.NoSuchPerformanceRecognitionException {

		return getPersistence().remove(recognitionId);
	}

	public static PerformanceRecognition updateImpl(
		PerformanceRecognition performanceRecognition) {

		return getPersistence().updateImpl(performanceRecognition);
	}

	/**
	 * Returns the performance recognition with the primary key or throws a <code>NoSuchPerformanceRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	public static PerformanceRecognition findByPrimaryKey(long recognitionId)
		throws hong.recog.exception.NoSuchPerformanceRecognitionException {

		return getPersistence().findByPrimaryKey(recognitionId);
	}

	/**
	 * Returns the performance recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition, or <code>null</code> if a performance recognition with the primary key could not be found
	 */
	public static PerformanceRecognition fetchByPrimaryKey(long recognitionId) {
		return getPersistence().fetchByPrimaryKey(recognitionId);
	}

	/**
	 * Returns all the performance recognitions.
	 *
	 * @return the performance recognitions
	 */
	public static List<PerformanceRecognition> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the performance recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of performance recognitions
	 * @param end the upper bound of the range of performance recognitions (not inclusive)
	 * @return the range of performance recognitions
	 */
	public static List<PerformanceRecognition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the performance recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of performance recognitions
	 * @param end the upper bound of the range of performance recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of performance recognitions
	 */
	public static List<PerformanceRecognition> findAll(
		int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the performance recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PerformanceRecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of performance recognitions
	 * @param end the upper bound of the range of performance recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of performance recognitions
	 */
	public static List<PerformanceRecognition> findAll(
		int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the performance recognitions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of performance recognitions.
	 *
	 * @return the number of performance recognitions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PerformanceRecognitionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PerformanceRecognitionPersistence, PerformanceRecognitionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PerformanceRecognitionPersistence.class);

		ServiceTracker
			<PerformanceRecognitionPersistence,
			 PerformanceRecognitionPersistence> serviceTracker =
				new ServiceTracker
					<PerformanceRecognitionPersistence,
					 PerformanceRecognitionPersistence>(
						 bundle.getBundleContext(),
						 PerformanceRecognitionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}