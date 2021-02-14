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

import hong.recog.exception.NoSuchFriendshipRecognitionException;
import hong.recog.model.FriendshipRecognition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the friendship recognition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @see FriendshipRecognitionUtil
 * @generated
 */
@ProviderType
public interface FriendshipRecognitionPersistence
	extends BasePersistence<FriendshipRecognition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FriendshipRecognitionUtil} to access the friendship recognition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the friendship recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching friendship recognitions
	 */
	public java.util.List<FriendshipRecognition> findByUuid(String uuid);

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
	public java.util.List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FriendshipRecognition>
			orderByComparator);

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
	public java.util.List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FriendshipRecognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	public FriendshipRecognition findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FriendshipRecognition> orderByComparator)
		throws NoSuchFriendshipRecognitionException;

	/**
	 * Returns the first friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	public FriendshipRecognition fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FriendshipRecognition>
			orderByComparator);

	/**
	 * Returns the last friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	public FriendshipRecognition findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FriendshipRecognition> orderByComparator)
		throws NoSuchFriendshipRecognitionException;

	/**
	 * Returns the last friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	public FriendshipRecognition fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FriendshipRecognition>
			orderByComparator);

	/**
	 * Returns the friendship recognitions before and after the current friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param recognitionId the primary key of the current friendship recognition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	public FriendshipRecognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<FriendshipRecognition> orderByComparator)
		throws NoSuchFriendshipRecognitionException;

	/**
	 * Removes all the friendship recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of friendship recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching friendship recognitions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or throws a <code>NoSuchFriendshipRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	public FriendshipRecognition findByRecognitionId(long recognitionId)
		throws NoSuchFriendshipRecognitionException;

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	public FriendshipRecognition fetchByRecognitionId(long recognitionId);

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	public FriendshipRecognition fetchByRecognitionId(
		long recognitionId, boolean useFinderCache);

	/**
	 * Removes the friendship recognition where recognitionId = &#63; from the database.
	 *
	 * @param recognitionId the recognition ID
	 * @return the friendship recognition that was removed
	 */
	public FriendshipRecognition removeByRecognitionId(long recognitionId)
		throws NoSuchFriendshipRecognitionException;

	/**
	 * Returns the number of friendship recognitions where recognitionId = &#63;.
	 *
	 * @param recognitionId the recognition ID
	 * @return the number of matching friendship recognitions
	 */
	public int countByRecognitionId(long recognitionId);

	/**
	 * Caches the friendship recognition in the entity cache if it is enabled.
	 *
	 * @param friendshipRecognition the friendship recognition
	 */
	public void cacheResult(FriendshipRecognition friendshipRecognition);

	/**
	 * Caches the friendship recognitions in the entity cache if it is enabled.
	 *
	 * @param friendshipRecognitions the friendship recognitions
	 */
	public void cacheResult(
		java.util.List<FriendshipRecognition> friendshipRecognitions);

	/**
	 * Creates a new friendship recognition with the primary key. Does not add the friendship recognition to the database.
	 *
	 * @param recognitionId the primary key for the new friendship recognition
	 * @return the new friendship recognition
	 */
	public FriendshipRecognition create(long recognitionId);

	/**
	 * Removes the friendship recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition that was removed
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	public FriendshipRecognition remove(long recognitionId)
		throws NoSuchFriendshipRecognitionException;

	public FriendshipRecognition updateImpl(
		FriendshipRecognition friendshipRecognition);

	/**
	 * Returns the friendship recognition with the primary key or throws a <code>NoSuchFriendshipRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	public FriendshipRecognition findByPrimaryKey(long recognitionId)
		throws NoSuchFriendshipRecognitionException;

	/**
	 * Returns the friendship recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition, or <code>null</code> if a friendship recognition with the primary key could not be found
	 */
	public FriendshipRecognition fetchByPrimaryKey(long recognitionId);

	/**
	 * Returns all the friendship recognitions.
	 *
	 * @return the friendship recognitions
	 */
	public java.util.List<FriendshipRecognition> findAll();

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
	public java.util.List<FriendshipRecognition> findAll(int start, int end);

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
	public java.util.List<FriendshipRecognition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FriendshipRecognition>
			orderByComparator);

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
	public java.util.List<FriendshipRecognition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FriendshipRecognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the friendship recognitions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of friendship recognitions.
	 *
	 * @return the number of friendship recognitions
	 */
	public int countAll();

}