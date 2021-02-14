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

package hong.recog.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import hong.recog.exception.NoSuchFriendshipRecognitionException;
import hong.recog.model.FriendshipRecognition;
import hong.recog.model.impl.FriendshipRecognitionImpl;
import hong.recog.model.impl.FriendshipRecognitionModelImpl;
import hong.recog.service.persistence.FriendshipRecognitionPersistence;
import hong.recog.service.persistence.impl.constants.RECOGPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the friendship recognition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @generated
 */
@Component(service = FriendshipRecognitionPersistence.class)
public class FriendshipRecognitionPersistenceImpl
	extends BasePersistenceImpl<FriendshipRecognition>
	implements FriendshipRecognitionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FriendshipRecognitionUtil</code> to access the friendship recognition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FriendshipRecognitionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the friendship recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching friendship recognitions
	 */
	@Override
	public List<FriendshipRecognition> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<FriendshipRecognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<FriendshipRecognition> list = null;

		if (useFinderCache) {
			list = (List<FriendshipRecognition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FriendshipRecognition friendshipRecognition : list) {
					if (!uuid.equals(friendshipRecognition.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FRIENDSHIPRECOGNITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FriendshipRecognitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<FriendshipRecognition>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	@Override
	public FriendshipRecognition findByUuid_First(
			String uuid,
			OrderByComparator<FriendshipRecognition> orderByComparator)
		throws NoSuchFriendshipRecognitionException {

		FriendshipRecognition friendshipRecognition = fetchByUuid_First(
			uuid, orderByComparator);

		if (friendshipRecognition != null) {
			return friendshipRecognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFriendshipRecognitionException(sb.toString());
	}

	/**
	 * Returns the first friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	@Override
	public FriendshipRecognition fetchByUuid_First(
		String uuid,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		List<FriendshipRecognition> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	@Override
	public FriendshipRecognition findByUuid_Last(
			String uuid,
			OrderByComparator<FriendshipRecognition> orderByComparator)
		throws NoSuchFriendshipRecognitionException {

		FriendshipRecognition friendshipRecognition = fetchByUuid_Last(
			uuid, orderByComparator);

		if (friendshipRecognition != null) {
			return friendshipRecognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFriendshipRecognitionException(sb.toString());
	}

	/**
	 * Returns the last friendship recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	@Override
	public FriendshipRecognition fetchByUuid_Last(
		String uuid,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FriendshipRecognition> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FriendshipRecognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			OrderByComparator<FriendshipRecognition> orderByComparator)
		throws NoSuchFriendshipRecognitionException {

		uuid = Objects.toString(uuid, "");

		FriendshipRecognition friendshipRecognition = findByPrimaryKey(
			recognitionId);

		Session session = null;

		try {
			session = openSession();

			FriendshipRecognition[] array = new FriendshipRecognitionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, friendshipRecognition, uuid, orderByComparator, true);

			array[1] = friendshipRecognition;

			array[2] = getByUuid_PrevAndNext(
				session, friendshipRecognition, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FriendshipRecognition getByUuid_PrevAndNext(
		Session session, FriendshipRecognition friendshipRecognition,
		String uuid, OrderByComparator<FriendshipRecognition> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FRIENDSHIPRECOGNITION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FriendshipRecognitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						friendshipRecognition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FriendshipRecognition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the friendship recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FriendshipRecognition friendshipRecognition :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(friendshipRecognition);
		}
	}

	/**
	 * Returns the number of friendship recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching friendship recognitions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FRIENDSHIPRECOGNITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"friendshipRecognition.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(friendshipRecognition.uuid IS NULL OR friendshipRecognition.uuid = '')";

	private FinderPath _finderPathFetchByRecognitionId;
	private FinderPath _finderPathCountByRecognitionId;

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or throws a <code>NoSuchFriendshipRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a matching friendship recognition could not be found
	 */
	@Override
	public FriendshipRecognition findByRecognitionId(long recognitionId)
		throws NoSuchFriendshipRecognitionException {

		FriendshipRecognition friendshipRecognition = fetchByRecognitionId(
			recognitionId);

		if (friendshipRecognition == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("recognitionId=");
			sb.append(recognitionId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFriendshipRecognitionException(sb.toString());
		}

		return friendshipRecognition;
	}

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	@Override
	public FriendshipRecognition fetchByRecognitionId(long recognitionId) {
		return fetchByRecognitionId(recognitionId, true);
	}

	/**
	 * Returns the friendship recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching friendship recognition, or <code>null</code> if a matching friendship recognition could not be found
	 */
	@Override
	public FriendshipRecognition fetchByRecognitionId(
		long recognitionId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {recognitionId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRecognitionId, finderArgs, this);
		}

		if (result instanceof FriendshipRecognition) {
			FriendshipRecognition friendshipRecognition =
				(FriendshipRecognition)result;

			if (recognitionId != friendshipRecognition.getRecognitionId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_FRIENDSHIPRECOGNITION_WHERE);

			sb.append(_FINDER_COLUMN_RECOGNITIONID_RECOGNITIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(recognitionId);

				List<FriendshipRecognition> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRecognitionId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {recognitionId};
							}

							_log.warn(
								"FriendshipRecognitionPersistenceImpl.fetchByRecognitionId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FriendshipRecognition friendshipRecognition = list.get(0);

					result = friendshipRecognition;

					cacheResult(friendshipRecognition);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FriendshipRecognition)result;
		}
	}

	/**
	 * Removes the friendship recognition where recognitionId = &#63; from the database.
	 *
	 * @param recognitionId the recognition ID
	 * @return the friendship recognition that was removed
	 */
	@Override
	public FriendshipRecognition removeByRecognitionId(long recognitionId)
		throws NoSuchFriendshipRecognitionException {

		FriendshipRecognition friendshipRecognition = findByRecognitionId(
			recognitionId);

		return remove(friendshipRecognition);
	}

	/**
	 * Returns the number of friendship recognitions where recognitionId = &#63;.
	 *
	 * @param recognitionId the recognition ID
	 * @return the number of matching friendship recognitions
	 */
	@Override
	public int countByRecognitionId(long recognitionId) {
		FinderPath finderPath = _finderPathCountByRecognitionId;

		Object[] finderArgs = new Object[] {recognitionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FRIENDSHIPRECOGNITION_WHERE);

			sb.append(_FINDER_COLUMN_RECOGNITIONID_RECOGNITIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(recognitionId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RECOGNITIONID_RECOGNITIONID_2 =
		"friendshipRecognition.recognitionId = ?";

	public FriendshipRecognitionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FriendshipRecognition.class);

		setModelImplClass(FriendshipRecognitionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the friendship recognition in the entity cache if it is enabled.
	 *
	 * @param friendshipRecognition the friendship recognition
	 */
	@Override
	public void cacheResult(FriendshipRecognition friendshipRecognition) {
		entityCache.putResult(
			FriendshipRecognitionImpl.class,
			friendshipRecognition.getPrimaryKey(), friendshipRecognition);

		finderCache.putResult(
			_finderPathFetchByRecognitionId,
			new Object[] {friendshipRecognition.getRecognitionId()},
			friendshipRecognition);
	}

	/**
	 * Caches the friendship recognitions in the entity cache if it is enabled.
	 *
	 * @param friendshipRecognitions the friendship recognitions
	 */
	@Override
	public void cacheResult(
		List<FriendshipRecognition> friendshipRecognitions) {

		for (FriendshipRecognition friendshipRecognition :
				friendshipRecognitions) {

			if (entityCache.getResult(
					FriendshipRecognitionImpl.class,
					friendshipRecognition.getPrimaryKey()) == null) {

				cacheResult(friendshipRecognition);
			}
		}
	}

	/**
	 * Clears the cache for all friendship recognitions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FriendshipRecognitionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the friendship recognition.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FriendshipRecognition friendshipRecognition) {
		entityCache.removeResult(
			FriendshipRecognitionImpl.class, friendshipRecognition);
	}

	@Override
	public void clearCache(List<FriendshipRecognition> friendshipRecognitions) {
		for (FriendshipRecognition friendshipRecognition :
				friendshipRecognitions) {

			entityCache.removeResult(
				FriendshipRecognitionImpl.class, friendshipRecognition);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				FriendshipRecognitionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FriendshipRecognitionModelImpl friendshipRecognitionModelImpl) {

		Object[] args = new Object[] {
			friendshipRecognitionModelImpl.getRecognitionId()
		};

		finderCache.putResult(
			_finderPathCountByRecognitionId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByRecognitionId, args,
			friendshipRecognitionModelImpl, false);
	}

	/**
	 * Creates a new friendship recognition with the primary key. Does not add the friendship recognition to the database.
	 *
	 * @param recognitionId the primary key for the new friendship recognition
	 * @return the new friendship recognition
	 */
	@Override
	public FriendshipRecognition create(long recognitionId) {
		FriendshipRecognition friendshipRecognition =
			new FriendshipRecognitionImpl();

		friendshipRecognition.setNew(true);
		friendshipRecognition.setPrimaryKey(recognitionId);

		String uuid = PortalUUIDUtil.generate();

		friendshipRecognition.setUuid(uuid);

		return friendshipRecognition;
	}

	/**
	 * Removes the friendship recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition that was removed
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	@Override
	public FriendshipRecognition remove(long recognitionId)
		throws NoSuchFriendshipRecognitionException {

		return remove((Serializable)recognitionId);
	}

	/**
	 * Removes the friendship recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the friendship recognition
	 * @return the friendship recognition that was removed
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	@Override
	public FriendshipRecognition remove(Serializable primaryKey)
		throws NoSuchFriendshipRecognitionException {

		Session session = null;

		try {
			session = openSession();

			FriendshipRecognition friendshipRecognition =
				(FriendshipRecognition)session.get(
					FriendshipRecognitionImpl.class, primaryKey);

			if (friendshipRecognition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFriendshipRecognitionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(friendshipRecognition);
		}
		catch (NoSuchFriendshipRecognitionException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FriendshipRecognition removeImpl(
		FriendshipRecognition friendshipRecognition) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(friendshipRecognition)) {
				friendshipRecognition = (FriendshipRecognition)session.get(
					FriendshipRecognitionImpl.class,
					friendshipRecognition.getPrimaryKeyObj());
			}

			if (friendshipRecognition != null) {
				session.delete(friendshipRecognition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (friendshipRecognition != null) {
			clearCache(friendshipRecognition);
		}

		return friendshipRecognition;
	}

	@Override
	public FriendshipRecognition updateImpl(
		FriendshipRecognition friendshipRecognition) {

		boolean isNew = friendshipRecognition.isNew();

		if (!(friendshipRecognition instanceof
				FriendshipRecognitionModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(friendshipRecognition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					friendshipRecognition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in friendshipRecognition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FriendshipRecognition implementation " +
					friendshipRecognition.getClass());
		}

		FriendshipRecognitionModelImpl friendshipRecognitionModelImpl =
			(FriendshipRecognitionModelImpl)friendshipRecognition;

		if (Validator.isNull(friendshipRecognition.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			friendshipRecognition.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(friendshipRecognition);
			}
			else {
				friendshipRecognition = (FriendshipRecognition)session.merge(
					friendshipRecognition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FriendshipRecognitionImpl.class, friendshipRecognitionModelImpl,
			false, true);

		cacheUniqueFindersCache(friendshipRecognitionModelImpl);

		if (isNew) {
			friendshipRecognition.setNew(false);
		}

		friendshipRecognition.resetOriginalValues();

		return friendshipRecognition;
	}

	/**
	 * Returns the friendship recognition with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the friendship recognition
	 * @return the friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	@Override
	public FriendshipRecognition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFriendshipRecognitionException {

		FriendshipRecognition friendshipRecognition = fetchByPrimaryKey(
			primaryKey);

		if (friendshipRecognition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFriendshipRecognitionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return friendshipRecognition;
	}

	/**
	 * Returns the friendship recognition with the primary key or throws a <code>NoSuchFriendshipRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition
	 * @throws NoSuchFriendshipRecognitionException if a friendship recognition with the primary key could not be found
	 */
	@Override
	public FriendshipRecognition findByPrimaryKey(long recognitionId)
		throws NoSuchFriendshipRecognitionException {

		return findByPrimaryKey((Serializable)recognitionId);
	}

	/**
	 * Returns the friendship recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the friendship recognition
	 * @return the friendship recognition, or <code>null</code> if a friendship recognition with the primary key could not be found
	 */
	@Override
	public FriendshipRecognition fetchByPrimaryKey(long recognitionId) {
		return fetchByPrimaryKey((Serializable)recognitionId);
	}

	/**
	 * Returns all the friendship recognitions.
	 *
	 * @return the friendship recognitions
	 */
	@Override
	public List<FriendshipRecognition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FriendshipRecognition> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<FriendshipRecognition> findAll(
		int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<FriendshipRecognition> findAll(
		int start, int end,
		OrderByComparator<FriendshipRecognition> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<FriendshipRecognition> list = null;

		if (useFinderCache) {
			list = (List<FriendshipRecognition>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FRIENDSHIPRECOGNITION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FRIENDSHIPRECOGNITION;

				sql = sql.concat(FriendshipRecognitionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FriendshipRecognition>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the friendship recognitions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FriendshipRecognition friendshipRecognition : findAll()) {
			remove(friendshipRecognition);
		}
	}

	/**
	 * Returns the number of friendship recognitions.
	 *
	 * @return the number of friendship recognitions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_FRIENDSHIPRECOGNITION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "recognitionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FRIENDSHIPRECOGNITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FriendshipRecognitionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the friendship recognition persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new FriendshipRecognitionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", FriendshipRecognition.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByRecognitionId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRecognitionId",
			new String[] {Long.class.getName()}, new String[] {"recognitionId"},
			true);

		_finderPathCountByRecognitionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecognitionId",
			new String[] {Long.class.getName()}, new String[] {"recognitionId"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(FriendshipRecognitionImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = RECOGPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = RECOGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = RECOGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FRIENDSHIPRECOGNITION =
		"SELECT friendshipRecognition FROM FriendshipRecognition friendshipRecognition";

	private static final String _SQL_SELECT_FRIENDSHIPRECOGNITION_WHERE =
		"SELECT friendshipRecognition FROM FriendshipRecognition friendshipRecognition WHERE ";

	private static final String _SQL_COUNT_FRIENDSHIPRECOGNITION =
		"SELECT COUNT(friendshipRecognition) FROM FriendshipRecognition friendshipRecognition";

	private static final String _SQL_COUNT_FRIENDSHIPRECOGNITION_WHERE =
		"SELECT COUNT(friendshipRecognition) FROM FriendshipRecognition friendshipRecognition WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"friendshipRecognition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FriendshipRecognition exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FriendshipRecognition exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FriendshipRecognitionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(RECOGPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class FriendshipRecognitionModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			FriendshipRecognitionModelImpl friendshipRecognitionModelImpl =
				(FriendshipRecognitionModelImpl)baseModel;

			long columnBitmask =
				friendshipRecognitionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					friendshipRecognitionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						friendshipRecognitionModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					friendshipRecognitionModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			FriendshipRecognitionModelImpl friendshipRecognitionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						friendshipRecognitionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						friendshipRecognitionModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}