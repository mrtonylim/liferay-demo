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

import hong.recog.exception.NoSuchPerformanceRecognitionException;
import hong.recog.model.PerformanceRecognition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the performance recognition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @see PerformanceRecognitionUtil
 * @generated
 */
@ProviderType
public interface PerformanceRecognitionPersistence
	extends BasePersistence<PerformanceRecognition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PerformanceRecognitionUtil} to access the performance recognition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the performance recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching performance recognitions
	 */
	public java.util.List<PerformanceRecognition> findByUuid(String uuid);

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
	public java.util.List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PerformanceRecognition>
			orderByComparator);

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
	public java.util.List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PerformanceRecognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	public PerformanceRecognition findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PerformanceRecognition> orderByComparator)
		throws NoSuchPerformanceRecognitionException;

	/**
	 * Returns the first performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	public PerformanceRecognition fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PerformanceRecognition>
			orderByComparator);

	/**
	 * Returns the last performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	public PerformanceRecognition findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PerformanceRecognition> orderByComparator)
		throws NoSuchPerformanceRecognitionException;

	/**
	 * Returns the last performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	public PerformanceRecognition fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PerformanceRecognition>
			orderByComparator);

	/**
	 * Returns the performance recognitions before and after the current performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param recognitionId the primary key of the current performance recognition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	public PerformanceRecognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PerformanceRecognition> orderByComparator)
		throws NoSuchPerformanceRecognitionException;

	/**
	 * Removes all the performance recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of performance recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching performance recognitions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the performance recognition where recognitionId = &#63; or throws a <code>NoSuchPerformanceRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	public PerformanceRecognition findByRecognitionId(long recognitionId)
		throws NoSuchPerformanceRecognitionException;

	/**
	 * Returns the performance recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	public PerformanceRecognition fetchByRecognitionId(long recognitionId);

	/**
	 * Returns the performance recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	public PerformanceRecognition fetchByRecognitionId(
		long recognitionId, boolean useFinderCache);

	/**
	 * Removes the performance recognition where recognitionId = &#63; from the database.
	 *
	 * @param recognitionId the recognition ID
	 * @return the performance recognition that was removed
	 */
	public PerformanceRecognition removeByRecognitionId(long recognitionId)
		throws NoSuchPerformanceRecognitionException;

	/**
	 * Returns the number of performance recognitions where recognitionId = &#63;.
	 *
	 * @param recognitionId the recognition ID
	 * @return the number of matching performance recognitions
	 */
	public int countByRecognitionId(long recognitionId);

	/**
	 * Caches the performance recognition in the entity cache if it is enabled.
	 *
	 * @param performanceRecognition the performance recognition
	 */
	public void cacheResult(PerformanceRecognition performanceRecognition);

	/**
	 * Caches the performance recognitions in the entity cache if it is enabled.
	 *
	 * @param performanceRecognitions the performance recognitions
	 */
	public void cacheResult(
		java.util.List<PerformanceRecognition> performanceRecognitions);

	/**
	 * Creates a new performance recognition with the primary key. Does not add the performance recognition to the database.
	 *
	 * @param recognitionId the primary key for the new performance recognition
	 * @return the new performance recognition
	 */
	public PerformanceRecognition create(long recognitionId);

	/**
	 * Removes the performance recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition that was removed
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	public PerformanceRecognition remove(long recognitionId)
		throws NoSuchPerformanceRecognitionException;

	public PerformanceRecognition updateImpl(
		PerformanceRecognition performanceRecognition);

	/**
	 * Returns the performance recognition with the primary key or throws a <code>NoSuchPerformanceRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	public PerformanceRecognition findByPrimaryKey(long recognitionId)
		throws NoSuchPerformanceRecognitionException;

	/**
	 * Returns the performance recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition, or <code>null</code> if a performance recognition with the primary key could not be found
	 */
	public PerformanceRecognition fetchByPrimaryKey(long recognitionId);

	/**
	 * Returns all the performance recognitions.
	 *
	 * @return the performance recognitions
	 */
	public java.util.List<PerformanceRecognition> findAll();

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
	public java.util.List<PerformanceRecognition> findAll(int start, int end);

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
	public java.util.List<PerformanceRecognition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PerformanceRecognition>
			orderByComparator);

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
	public java.util.List<PerformanceRecognition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PerformanceRecognition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the performance recognitions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of performance recognitions.
	 *
	 * @return the number of performance recognitions
	 */
	public int countAll();

}