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

import hong.recog.exception.NoSuchPerformanceRecognitionException;
import hong.recog.model.PerformanceRecognition;
import hong.recog.model.impl.PerformanceRecognitionImpl;
import hong.recog.model.impl.PerformanceRecognitionModelImpl;
import hong.recog.service.persistence.PerformanceRecognitionPersistence;
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
 * The persistence implementation for the performance recognition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @generated
 */
@Component(service = PerformanceRecognitionPersistence.class)
public class PerformanceRecognitionPersistenceImpl
	extends BasePersistenceImpl<PerformanceRecognition>
	implements PerformanceRecognitionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PerformanceRecognitionUtil</code> to access the performance recognition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PerformanceRecognitionImpl.class.getName();

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
	 * Returns all the performance recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching performance recognitions
	 */
	@Override
	public List<PerformanceRecognition> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<PerformanceRecognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator,
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

		List<PerformanceRecognition> list = null;

		if (useFinderCache) {
			list = (List<PerformanceRecognition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PerformanceRecognition performanceRecognition : list) {
					if (!uuid.equals(performanceRecognition.getUuid())) {
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

			sb.append(_SQL_SELECT_PERFORMANCERECOGNITION_WHERE);

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
				sb.append(PerformanceRecognitionModelImpl.ORDER_BY_JPQL);
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

				list = (List<PerformanceRecognition>)QueryUtil.list(
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
	 * Returns the first performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	@Override
	public PerformanceRecognition findByUuid_First(
			String uuid,
			OrderByComparator<PerformanceRecognition> orderByComparator)
		throws NoSuchPerformanceRecognitionException {

		PerformanceRecognition performanceRecognition = fetchByUuid_First(
			uuid, orderByComparator);

		if (performanceRecognition != null) {
			return performanceRecognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPerformanceRecognitionException(sb.toString());
	}

	/**
	 * Returns the first performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	@Override
	public PerformanceRecognition fetchByUuid_First(
		String uuid,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		List<PerformanceRecognition> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	@Override
	public PerformanceRecognition findByUuid_Last(
			String uuid,
			OrderByComparator<PerformanceRecognition> orderByComparator)
		throws NoSuchPerformanceRecognitionException {

		PerformanceRecognition performanceRecognition = fetchByUuid_Last(
			uuid, orderByComparator);

		if (performanceRecognition != null) {
			return performanceRecognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPerformanceRecognitionException(sb.toString());
	}

	/**
	 * Returns the last performance recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	@Override
	public PerformanceRecognition fetchByUuid_Last(
		String uuid,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PerformanceRecognition> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PerformanceRecognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			OrderByComparator<PerformanceRecognition> orderByComparator)
		throws NoSuchPerformanceRecognitionException {

		uuid = Objects.toString(uuid, "");

		PerformanceRecognition performanceRecognition = findByPrimaryKey(
			recognitionId);

		Session session = null;

		try {
			session = openSession();

			PerformanceRecognition[] array = new PerformanceRecognitionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, performanceRecognition, uuid, orderByComparator, true);

			array[1] = performanceRecognition;

			array[2] = getByUuid_PrevAndNext(
				session, performanceRecognition, uuid, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PerformanceRecognition getByUuid_PrevAndNext(
		Session session, PerformanceRecognition performanceRecognition,
		String uuid,
		OrderByComparator<PerformanceRecognition> orderByComparator,
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

		sb.append(_SQL_SELECT_PERFORMANCERECOGNITION_WHERE);

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
			sb.append(PerformanceRecognitionModelImpl.ORDER_BY_JPQL);
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
						performanceRecognition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PerformanceRecognition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the performance recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PerformanceRecognition performanceRecognition :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(performanceRecognition);
		}
	}

	/**
	 * Returns the number of performance recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching performance recognitions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERFORMANCERECOGNITION_WHERE);

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
		"performanceRecognition.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(performanceRecognition.uuid IS NULL OR performanceRecognition.uuid = '')";

	private FinderPath _finderPathFetchByRecognitionId;
	private FinderPath _finderPathCountByRecognitionId;

	/**
	 * Returns the performance recognition where recognitionId = &#63; or throws a <code>NoSuchPerformanceRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a matching performance recognition could not be found
	 */
	@Override
	public PerformanceRecognition findByRecognitionId(long recognitionId)
		throws NoSuchPerformanceRecognitionException {

		PerformanceRecognition performanceRecognition = fetchByRecognitionId(
			recognitionId);

		if (performanceRecognition == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("recognitionId=");
			sb.append(recognitionId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPerformanceRecognitionException(sb.toString());
		}

		return performanceRecognition;
	}

	/**
	 * Returns the performance recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @return the matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	@Override
	public PerformanceRecognition fetchByRecognitionId(long recognitionId) {
		return fetchByRecognitionId(recognitionId, true);
	}

	/**
	 * Returns the performance recognition where recognitionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param recognitionId the recognition ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching performance recognition, or <code>null</code> if a matching performance recognition could not be found
	 */
	@Override
	public PerformanceRecognition fetchByRecognitionId(
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

		if (result instanceof PerformanceRecognition) {
			PerformanceRecognition performanceRecognition =
				(PerformanceRecognition)result;

			if (recognitionId != performanceRecognition.getRecognitionId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PERFORMANCERECOGNITION_WHERE);

			sb.append(_FINDER_COLUMN_RECOGNITIONID_RECOGNITIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(recognitionId);

				List<PerformanceRecognition> list = query.list();

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
								"PerformanceRecognitionPersistenceImpl.fetchByRecognitionId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PerformanceRecognition performanceRecognition = list.get(0);

					result = performanceRecognition;

					cacheResult(performanceRecognition);
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
			return (PerformanceRecognition)result;
		}
	}

	/**
	 * Removes the performance recognition where recognitionId = &#63; from the database.
	 *
	 * @param recognitionId the recognition ID
	 * @return the performance recognition that was removed
	 */
	@Override
	public PerformanceRecognition removeByRecognitionId(long recognitionId)
		throws NoSuchPerformanceRecognitionException {

		PerformanceRecognition performanceRecognition = findByRecognitionId(
			recognitionId);

		return remove(performanceRecognition);
	}

	/**
	 * Returns the number of performance recognitions where recognitionId = &#63;.
	 *
	 * @param recognitionId the recognition ID
	 * @return the number of matching performance recognitions
	 */
	@Override
	public int countByRecognitionId(long recognitionId) {
		FinderPath finderPath = _finderPathCountByRecognitionId;

		Object[] finderArgs = new Object[] {recognitionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERFORMANCERECOGNITION_WHERE);

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
		"performanceRecognition.recognitionId = ?";

	public PerformanceRecognitionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PerformanceRecognition.class);

		setModelImplClass(PerformanceRecognitionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the performance recognition in the entity cache if it is enabled.
	 *
	 * @param performanceRecognition the performance recognition
	 */
	@Override
	public void cacheResult(PerformanceRecognition performanceRecognition) {
		entityCache.putResult(
			PerformanceRecognitionImpl.class,
			performanceRecognition.getPrimaryKey(), performanceRecognition);

		finderCache.putResult(
			_finderPathFetchByRecognitionId,
			new Object[] {performanceRecognition.getRecognitionId()},
			performanceRecognition);
	}

	/**
	 * Caches the performance recognitions in the entity cache if it is enabled.
	 *
	 * @param performanceRecognitions the performance recognitions
	 */
	@Override
	public void cacheResult(
		List<PerformanceRecognition> performanceRecognitions) {

		for (PerformanceRecognition performanceRecognition :
				performanceRecognitions) {

			if (entityCache.getResult(
					PerformanceRecognitionImpl.class,
					performanceRecognition.getPrimaryKey()) == null) {

				cacheResult(performanceRecognition);
			}
		}
	}

	/**
	 * Clears the cache for all performance recognitions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PerformanceRecognitionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the performance recognition.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PerformanceRecognition performanceRecognition) {
		entityCache.removeResult(
			PerformanceRecognitionImpl.class, performanceRecognition);
	}

	@Override
	public void clearCache(
		List<PerformanceRecognition> performanceRecognitions) {

		for (PerformanceRecognition performanceRecognition :
				performanceRecognitions) {

			entityCache.removeResult(
				PerformanceRecognitionImpl.class, performanceRecognition);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				PerformanceRecognitionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PerformanceRecognitionModelImpl performanceRecognitionModelImpl) {

		Object[] args = new Object[] {
			performanceRecognitionModelImpl.getRecognitionId()
		};

		finderCache.putResult(
			_finderPathCountByRecognitionId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByRecognitionId, args,
			performanceRecognitionModelImpl, false);
	}

	/**
	 * Creates a new performance recognition with the primary key. Does not add the performance recognition to the database.
	 *
	 * @param recognitionId the primary key for the new performance recognition
	 * @return the new performance recognition
	 */
	@Override
	public PerformanceRecognition create(long recognitionId) {
		PerformanceRecognition performanceRecognition =
			new PerformanceRecognitionImpl();

		performanceRecognition.setNew(true);
		performanceRecognition.setPrimaryKey(recognitionId);

		String uuid = PortalUUIDUtil.generate();

		performanceRecognition.setUuid(uuid);

		return performanceRecognition;
	}

	/**
	 * Removes the performance recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition that was removed
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	@Override
	public PerformanceRecognition remove(long recognitionId)
		throws NoSuchPerformanceRecognitionException {

		return remove((Serializable)recognitionId);
	}

	/**
	 * Removes the performance recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the performance recognition
	 * @return the performance recognition that was removed
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	@Override
	public PerformanceRecognition remove(Serializable primaryKey)
		throws NoSuchPerformanceRecognitionException {

		Session session = null;

		try {
			session = openSession();

			PerformanceRecognition performanceRecognition =
				(PerformanceRecognition)session.get(
					PerformanceRecognitionImpl.class, primaryKey);

			if (performanceRecognition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPerformanceRecognitionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(performanceRecognition);
		}
		catch (NoSuchPerformanceRecognitionException noSuchEntityException) {
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
	protected PerformanceRecognition removeImpl(
		PerformanceRecognition performanceRecognition) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(performanceRecognition)) {
				performanceRecognition = (PerformanceRecognition)session.get(
					PerformanceRecognitionImpl.class,
					performanceRecognition.getPrimaryKeyObj());
			}

			if (performanceRecognition != null) {
				session.delete(performanceRecognition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (performanceRecognition != null) {
			clearCache(performanceRecognition);
		}

		return performanceRecognition;
	}

	@Override
	public PerformanceRecognition updateImpl(
		PerformanceRecognition performanceRecognition) {

		boolean isNew = performanceRecognition.isNew();

		if (!(performanceRecognition instanceof
				PerformanceRecognitionModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(performanceRecognition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					performanceRecognition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in performanceRecognition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PerformanceRecognition implementation " +
					performanceRecognition.getClass());
		}

		PerformanceRecognitionModelImpl performanceRecognitionModelImpl =
			(PerformanceRecognitionModelImpl)performanceRecognition;

		if (Validator.isNull(performanceRecognition.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			performanceRecognition.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(performanceRecognition);
			}
			else {
				performanceRecognition = (PerformanceRecognition)session.merge(
					performanceRecognition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PerformanceRecognitionImpl.class, performanceRecognitionModelImpl,
			false, true);

		cacheUniqueFindersCache(performanceRecognitionModelImpl);

		if (isNew) {
			performanceRecognition.setNew(false);
		}

		performanceRecognition.resetOriginalValues();

		return performanceRecognition;
	}

	/**
	 * Returns the performance recognition with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the performance recognition
	 * @return the performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	@Override
	public PerformanceRecognition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPerformanceRecognitionException {

		PerformanceRecognition performanceRecognition = fetchByPrimaryKey(
			primaryKey);

		if (performanceRecognition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPerformanceRecognitionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return performanceRecognition;
	}

	/**
	 * Returns the performance recognition with the primary key or throws a <code>NoSuchPerformanceRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition
	 * @throws NoSuchPerformanceRecognitionException if a performance recognition with the primary key could not be found
	 */
	@Override
	public PerformanceRecognition findByPrimaryKey(long recognitionId)
		throws NoSuchPerformanceRecognitionException {

		return findByPrimaryKey((Serializable)recognitionId);
	}

	/**
	 * Returns the performance recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the performance recognition
	 * @return the performance recognition, or <code>null</code> if a performance recognition with the primary key could not be found
	 */
	@Override
	public PerformanceRecognition fetchByPrimaryKey(long recognitionId) {
		return fetchByPrimaryKey((Serializable)recognitionId);
	}

	/**
	 * Returns all the performance recognitions.
	 *
	 * @return the performance recognitions
	 */
	@Override
	public List<PerformanceRecognition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PerformanceRecognition> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PerformanceRecognition> findAll(
		int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PerformanceRecognition> findAll(
		int start, int end,
		OrderByComparator<PerformanceRecognition> orderByComparator,
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

		List<PerformanceRecognition> list = null;

		if (useFinderCache) {
			list = (List<PerformanceRecognition>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERFORMANCERECOGNITION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERFORMANCERECOGNITION;

				sql = sql.concat(PerformanceRecognitionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PerformanceRecognition>)QueryUtil.list(
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
	 * Removes all the performance recognitions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PerformanceRecognition performanceRecognition : findAll()) {
			remove(performanceRecognition);
		}
	}

	/**
	 * Returns the number of performance recognitions.
	 *
	 * @return the number of performance recognitions
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
					_SQL_COUNT_PERFORMANCERECOGNITION);

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
		return _SQL_SELECT_PERFORMANCERECOGNITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PerformanceRecognitionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the performance recognition persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new PerformanceRecognitionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PerformanceRecognition.class.getName()));

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
		entityCache.removeCache(PerformanceRecognitionImpl.class.getName());

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

	private static final String _SQL_SELECT_PERFORMANCERECOGNITION =
		"SELECT performanceRecognition FROM PerformanceRecognition performanceRecognition";

	private static final String _SQL_SELECT_PERFORMANCERECOGNITION_WHERE =
		"SELECT performanceRecognition FROM PerformanceRecognition performanceRecognition WHERE ";

	private static final String _SQL_COUNT_PERFORMANCERECOGNITION =
		"SELECT COUNT(performanceRecognition) FROM PerformanceRecognition performanceRecognition";

	private static final String _SQL_COUNT_PERFORMANCERECOGNITION_WHERE =
		"SELECT COUNT(performanceRecognition) FROM PerformanceRecognition performanceRecognition WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"performanceRecognition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PerformanceRecognition exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PerformanceRecognition exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PerformanceRecognitionPersistenceImpl.class);

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

	private static class PerformanceRecognitionModelArgumentsResolver
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

			PerformanceRecognitionModelImpl performanceRecognitionModelImpl =
				(PerformanceRecognitionModelImpl)baseModel;

			long columnBitmask =
				performanceRecognitionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					performanceRecognitionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						performanceRecognitionModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					performanceRecognitionModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PerformanceRecognitionModelImpl performanceRecognitionModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						performanceRecognitionModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						performanceRecognitionModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}