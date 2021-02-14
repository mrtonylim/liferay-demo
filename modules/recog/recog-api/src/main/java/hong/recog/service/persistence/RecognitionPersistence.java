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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hong.recog.exception.NoSuchRecognitionException;
import hong.recog.model.Recognition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the recognition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @see RecognitionUtil
 * @generated
 */
@ProviderType
public interface RecognitionPersistence extends BasePersistence<Recognition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RecognitionUtil} to access the recognition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching recognitions
	 */
	public java.util.List<Recognition> findByUuid(String uuid);

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
	public java.util.List<Recognition> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Recognition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

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
	public java.util.List<Recognition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where uuid = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public Recognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Removes all the recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching recognitions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRecognitionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByUUID_G(String uuid, long groupId)
		throws NoSuchRecognitionException;

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the recognition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the recognition that was removed
	 */
	public Recognition removeByUUID_G(String uuid, long groupId)
		throws NoSuchRecognitionException;

	/**
	 * Returns the number of recognitions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching recognitions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching recognitions
	 */
	public java.util.List<Recognition> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

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
	public java.util.List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

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
	public Recognition[] findByUuid_C_PrevAndNext(
			long recognitionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Removes all the recognitions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching recognitions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the recognitions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching recognitions
	 */
	public java.util.List<Recognition> findByUserId(long userId);

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
	public java.util.List<Recognition> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<Recognition> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

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
	public java.util.List<Recognition> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the first recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the last recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the last recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where userId = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public Recognition[] findByUserId_PrevAndNext(
			long recognitionId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Removes all the recognitions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of recognitions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching recognitions
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the recognitions where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @return the matching recognitions
	 */
	public java.util.List<Recognition> findByToUserId(long toUserId);

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
	public java.util.List<Recognition> findByToUserId(
		long toUserId, int start, int end);

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
	public java.util.List<Recognition> findByToUserId(
		long toUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

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
	public java.util.List<Recognition> findByToUserId(
		long toUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByToUserId_First(
			long toUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the first recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByToUserId_First(
		long toUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the last recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByToUserId_Last(
			long toUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the last recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByToUserId_Last(
		long toUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public Recognition[] findByToUserId_PrevAndNext(
			long recognitionId, long toUserId,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Removes all the recognitions where toUserId = &#63; from the database.
	 *
	 * @param toUserId the to user ID
	 */
	public void removeByToUserId(long toUserId);

	/**
	 * Returns the number of recognitions where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @return the number of matching recognitions
	 */
	public int countByToUserId(long toUserId);

	/**
	 * Returns all the recognitions where value = &#63;.
	 *
	 * @param value the value
	 * @return the matching recognitions
	 */
	public java.util.List<Recognition> findByValue(String value);

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
	public java.util.List<Recognition> findByValue(
		String value, int start, int end);

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
	public java.util.List<Recognition> findByValue(
		String value, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

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
	public java.util.List<Recognition> findByValue(
		String value, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByValue_First(
			String value,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the first recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByValue_First(
		String value,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the last recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	public Recognition findByValue_Last(
			String value,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Returns the last recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	public Recognition fetchByValue_Last(
		String value,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

	/**
	 * Returns the recognitions before and after the current recognition in the ordered set where value = &#63;.
	 *
	 * @param recognitionId the primary key of the current recognition
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public Recognition[] findByValue_PrevAndNext(
			long recognitionId, String value,
			com.liferay.portal.kernel.util.OrderByComparator<Recognition>
				orderByComparator)
		throws NoSuchRecognitionException;

	/**
	 * Removes all the recognitions where value = &#63; from the database.
	 *
	 * @param value the value
	 */
	public void removeByValue(String value);

	/**
	 * Returns the number of recognitions where value = &#63;.
	 *
	 * @param value the value
	 * @return the number of matching recognitions
	 */
	public int countByValue(String value);

	/**
	 * Caches the recognition in the entity cache if it is enabled.
	 *
	 * @param recognition the recognition
	 */
	public void cacheResult(Recognition recognition);

	/**
	 * Caches the recognitions in the entity cache if it is enabled.
	 *
	 * @param recognitions the recognitions
	 */
	public void cacheResult(java.util.List<Recognition> recognitions);

	/**
	 * Creates a new recognition with the primary key. Does not add the recognition to the database.
	 *
	 * @param recognitionId the primary key for the new recognition
	 * @return the new recognition
	 */
	public Recognition create(long recognitionId);

	/**
	 * Removes the recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition that was removed
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public Recognition remove(long recognitionId)
		throws NoSuchRecognitionException;

	public Recognition updateImpl(Recognition recognition);

	/**
	 * Returns the recognition with the primary key or throws a <code>NoSuchRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	public Recognition findByPrimaryKey(long recognitionId)
		throws NoSuchRecognitionException;

	/**
	 * Returns the recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition, or <code>null</code> if a recognition with the primary key could not be found
	 */
	public Recognition fetchByPrimaryKey(long recognitionId);

	/**
	 * Returns all the recognitions.
	 *
	 * @return the recognitions
	 */
	public java.util.List<Recognition> findAll();

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
	public java.util.List<Recognition> findAll(int start, int end);

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
	public java.util.List<Recognition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator);

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
	public java.util.List<Recognition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Recognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the recognitions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of recognitions.
	 *
	 * @return the number of recognitions
	 */
	public int countAll();

}