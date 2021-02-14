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

import hong.recog.model.Recognition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the recognition service. This utility wraps <code>hong.recog.service.persistence.impl.RecognitionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @see RecognitionPersistence
 * @generated
 */
public class RecognitionUtil {

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
	public static void clearCache(Recognition recognition) {
		getPersistence().clearCache(recognition);
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
	public static Map<Serializable, Recognition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Recognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Recognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Recognition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Recognition update(Recognition recognition) {
		return getPersistence().update(recognition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Recognition update(
		Recognition recognition, ServiceContext serviceContext) {

		return getPersistence().update(recognition, serviceContext);
	}

	/**
	 * Returns all the recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching recognitions
	 */
	public static List<Recognition> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @return the range of matching recognitions
	 */
	public static List<Recognition> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the recognitions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByUuid_First(
			String uuid, OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByUuid_First(
		String uuid, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByUuid_Last(
			String uuid, OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByUuid_Last(
		String uuid, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where uuid = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public static Recognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUuid_PrevAndNext(
			recognitionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching recognitions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRecognitionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByUUID_G(String uuid, long groupId)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the recognition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the recognition that was removed
	 */
	public static Recognition removeByUUID_G(String uuid, long groupId)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of recognitions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching recognitions
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching recognitions
	 */
	public static List<Recognition> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @return the range of matching recognitions
	 */
	public static List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public static Recognition[] findByUuid_C_PrevAndNext(
			long recognitionId, String uuid, long companyId,
			OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUuid_C_PrevAndNext(
			recognitionId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the recognitions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching recognitions
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the recognitions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching recognitions
	 */
	public static List<Recognition> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the recognitions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @return the range of matching recognitions
	 */
	public static List<Recognition> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the recognitions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the recognitions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByUserId_First(
			long userId, OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByUserId_First(
		long userId, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByUserId_Last(
			long userId, OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByUserId_Last(
		long userId, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where userId = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public static Recognition[] findByUserId_PrevAndNext(
			long recognitionId, long userId,
			OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByUserId_PrevAndNext(
			recognitionId, userId, orderByComparator);
	}

	/**
	 * Removes all the recognitions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of recognitions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching recognitions
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the recognitions where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @return the matching recognitions
	 */
	public static List<Recognition> findByToUserId(long toUserId) {
		return getPersistence().findByToUserId(toUserId);
	}

	/**
	 * Returns a range of all the recognitions where toUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param toUserId the to user ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @return the range of matching recognitions
	 */
	public static List<Recognition> findByToUserId(
		long toUserId, int start, int end) {

		return getPersistence().findByToUserId(toUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the recognitions where toUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param toUserId the to user ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByToUserId(
		long toUserId, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().findByToUserId(
			toUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the recognitions where toUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param toUserId the to user ID
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByToUserId(
		long toUserId, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByToUserId(
			toUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByToUserId_First(
			long toUserId, OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByToUserId_First(
			toUserId, orderByComparator);
	}

	/**
	 * Returns the first recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByToUserId_First(
		long toUserId, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByToUserId_First(
			toUserId, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByToUserId_Last(
			long toUserId, OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByToUserId_Last(
			toUserId, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByToUserId_Last(
		long toUserId, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByToUserId_Last(
			toUserId, orderByComparator);
	}

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public static Recognition[] findByToUserId_PrevAndNext(
			long recognitionId, long toUserId,
			OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByToUserId_PrevAndNext(
			recognitionId, toUserId, orderByComparator);
	}

	/**
	 * Removes all the recognitions where toUserId = &#63; from the database.
	 *
	 * @param toUserId the to user ID
	 */
	public static void removeByToUserId(long toUserId) {
		getPersistence().removeByToUserId(toUserId);
	}

	/**
	 * Returns the number of recognitions where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @return the number of matching recognitions
	 */
	public static int countByToUserId(long toUserId) {
		return getPersistence().countByToUserId(toUserId);
	}

	/**
	 * Returns all the recognitions where value = &#63;.
	 *
	 * @param value the value
	 * @return the matching recognitions
	 */
	public static List<Recognition> findByValue(String value) {
		return getPersistence().findByValue(value);
	}

	/**
	 * Returns a range of all the recognitions where value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param value the value
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @return the range of matching recognitions
	 */
	public static List<Recognition> findByValue(
		String value, int start, int end) {

		return getPersistence().findByValue(value, start, end);
	}

	/**
	 * Returns an ordered range of all the recognitions where value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param value the value
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByValue(
		String value, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().findByValue(
			value, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the recognitions where value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param value the value
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching recognitions
	 */
	public static List<Recognition> findByValue(
		String value, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByValue(
			value, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByValue_First(
			String value, OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByValue_First(value, orderByComparator);
	}

	/**
	 * Returns the first recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByValue_First(
		String value, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByValue_First(value, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public static Recognition findByValue_Last(
			String value, OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByValue_Last(value, orderByComparator);
	}

	/**
	 * Returns the last recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public static Recognition fetchByValue_Last(
		String value, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().fetchByValue_Last(value, orderByComparator);
	}

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where value = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public static Recognition[] findByValue_PrevAndNext(
			long recognitionId, String value,
			OrderByComparator<Recognition> orderByComparator)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByValue_PrevAndNext(
			recognitionId, value, orderByComparator);
	}

	/**
	 * Removes all the recognitions where value = &#63; from the database.
	 *
	 * @param value the value
	 */
	public static void removeByValue(String value) {
		getPersistence().removeByValue(value);
	}

	/**
	 * Returns the number of recognitions where value = &#63;.
	 *
	 * @param value the value
	 * @return the number of matching recognitions
	 */
	public static int countByValue(String value) {
		return getPersistence().countByValue(value);
	}

	/**
	 * Caches the recognition in the entity cache if it is enabled.
	 *
	 * @param recognition the recognition
	 */
	public static void cacheResult(Recognition recognition) {
		getPersistence().cacheResult(recognition);
	}

	/**
	 * Caches the recognitions in the entity cache if it is enabled.
	 *
	 * @param recognitions the recognitions
	 */
	public static void cacheResult(List<Recognition> recognitions) {
		getPersistence().cacheResult(recognitions);
	}

	/**
	 * Creates a new recognition with the primary key. Does not add the recognition to the database.
	 *
	 * @param recognitionId the primary key for the new recognition
	 * @return the new recognition
	 */
	public static Recognition create(long recognitionId) {
		return getPersistence().create(recognitionId);
	}

	/**
	 * Removes the recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition that was removed
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public static Recognition remove(long recognitionId)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().remove(recognitionId);
	}

	public static Recognition updateImpl(Recognition recognition) {
		return getPersistence().updateImpl(recognition);
	}

	/**
	 * Returns the recognition with the primary key or throws a <code>NoSuchRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public static Recognition findByPrimaryKey(long recognitionId)
		throws hong.recog.exception.NoSuchRecognitionException {

		return getPersistence().findByPrimaryKey(recognitionId);
	}

	/**
	 * Returns the recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition, or <code>null</code> if a recognition with the primary key could not be found
	 */
	public static Recognition fetchByPrimaryKey(long recognitionId) {
		return getPersistence().fetchByPrimaryKey(recognitionId);
	}

	/**
	 * Returns all the recognitions.
	 *
	 * @return the recognitions
	 */
	public static List<Recognition> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @return the range of recognitions
	 */
	public static List<Recognition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of recognitions
	 */
	public static List<Recognition> findAll(
		int start, int end, OrderByComparator<Recognition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the recognitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RecognitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of recognitions
	 * @param end the upper bound of the range of recognitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of recognitions
	 */
	public static List<Recognition> findAll(
		int start, int end, OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the recognitions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of recognitions.
	 *
	 * @return the number of recognitions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RecognitionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RecognitionPersistence, RecognitionPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RecognitionPersistence.class);

		ServiceTracker<RecognitionPersistence, RecognitionPersistence>
			serviceTracker =
				new ServiceTracker
					<RecognitionPersistence, RecognitionPersistence>(
						bundle.getBundleContext(), RecognitionPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}