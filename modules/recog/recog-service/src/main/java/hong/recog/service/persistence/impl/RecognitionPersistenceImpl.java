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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import hong.recog.exception.NoSuchRecognitionException;
import hong.recog.model.Recognition;
import hong.recog.model.impl.RecognitionImpl;
import hong.recog.model.impl.RecognitionModelImpl;
import hong.recog.service.persistence.RecognitionPersistence;
import hong.recog.service.persistence.impl.constants.RECOGPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the recognition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hong
 * @generated
 */
@Component(service = RecognitionPersistence.class)
public class RecognitionPersistenceImpl
	extends BasePersistenceImpl<Recognition> implements RecognitionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RecognitionUtil</code> to access the recognition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RecognitionImpl.class.getName();

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
	 * Returns all the recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching recognitions
	 */
	@Override
	public List<Recognition> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Recognition> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Recognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Recognition> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
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

		List<Recognition> list = null;

		if (useFinderCache) {
			list = (List<Recognition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Recognition recognition : list) {
					if (!uuid.equals(recognition.getUuid())) {
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

			sb.append(_SQL_SELECT_RECOGNITION_WHERE);

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
				sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
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

				list = (List<Recognition>)QueryUtil.list(
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
	 * Returns the first recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByUuid_First(
			String uuid, OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByUuid_First(uuid, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByUuid_First(
		String uuid, OrderByComparator<Recognition> orderByComparator) {

		List<Recognition> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByUuid_Last(
			String uuid, OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByUuid_Last(uuid, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByUuid_Last(
		String uuid, OrderByComparator<Recognition> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Recognition> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Recognition[] findByUuid_PrevAndNext(
			long recognitionId, String uuid,
			OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		uuid = Objects.toString(uuid, "");

		Recognition recognition = findByPrimaryKey(recognitionId);

		Session session = null;

		try {
			session = openSession();

			Recognition[] array = new RecognitionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, recognition, uuid, orderByComparator, true);

			array[1] = recognition;

			array[2] = getByUuid_PrevAndNext(
				session, recognition, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Recognition getByUuid_PrevAndNext(
		Session session, Recognition recognition, String uuid,
		OrderByComparator<Recognition> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RECOGNITION_WHERE);

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
			sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(recognition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Recognition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the recognitions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Recognition recognition :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(recognition);
		}
	}

	/**
	 * Returns the number of recognitions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching recognitions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RECOGNITION_WHERE);

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
		"recognition.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(recognition.uuid IS NULL OR recognition.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRecognitionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByUUID_G(String uuid, long groupId)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByUUID_G(uuid, groupId);

		if (recognition == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRecognitionException(sb.toString());
		}

		return recognition;
	}

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the recognition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Recognition) {
			Recognition recognition = (Recognition)result;

			if (!Objects.equals(uuid, recognition.getUuid()) ||
				(groupId != recognition.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RECOGNITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Recognition> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Recognition recognition = list.get(0);

					result = recognition;

					cacheResult(recognition);
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
			return (Recognition)result;
		}
	}

	/**
	 * Removes the recognition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the recognition that was removed
	 */
	@Override
	public Recognition removeByUUID_G(String uuid, long groupId)
		throws NoSuchRecognitionException {

		Recognition recognition = findByUUID_G(uuid, groupId);

		return remove(recognition);
	}

	/**
	 * Returns the number of recognitions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching recognitions
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RECOGNITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"recognition.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(recognition.uuid IS NULL OR recognition.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"recognition.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching recognitions
	 */
	@Override
	public List<Recognition> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Recognition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Recognition> list = null;

		if (useFinderCache) {
			list = (List<Recognition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Recognition recognition : list) {
					if (!uuid.equals(recognition.getUuid()) ||
						(companyId != recognition.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_RECOGNITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<Recognition>)QueryUtil.list(
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
	 * Returns the first recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the first recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Recognition> orderByComparator) {

		List<Recognition> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Recognition findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the last recognition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Recognition> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Recognition> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Recognition[] findByUuid_C_PrevAndNext(
			long recognitionId, String uuid, long companyId,
			OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		uuid = Objects.toString(uuid, "");

		Recognition recognition = findByPrimaryKey(recognitionId);

		Session session = null;

		try {
			session = openSession();

			Recognition[] array = new RecognitionImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, recognition, uuid, companyId, orderByComparator, true);

			array[1] = recognition;

			array[2] = getByUuid_C_PrevAndNext(
				session, recognition, uuid, companyId, orderByComparator,
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

	protected Recognition getByUuid_C_PrevAndNext(
		Session session, Recognition recognition, String uuid, long companyId,
		OrderByComparator<Recognition> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_RECOGNITION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(recognition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Recognition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the recognitions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Recognition recognition :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(recognition);
		}
	}

	/**
	 * Returns the number of recognitions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching recognitions
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RECOGNITION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"recognition.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(recognition.uuid IS NULL OR recognition.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"recognition.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the recognitions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching recognitions
	 */
	@Override
	public List<Recognition> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Recognition> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Recognition> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Recognition> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Recognition> list = null;

		if (useFinderCache) {
			list = (List<Recognition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Recognition recognition : list) {
					if (userId != recognition.getUserId()) {
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

			sb.append(_SQL_SELECT_RECOGNITION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Recognition>)QueryUtil.list(
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
	 * Returns the first recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByUserId_First(
			long userId, OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByUserId_First(
			userId, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the first recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByUserId_First(
		long userId, OrderByComparator<Recognition> orderByComparator) {

		List<Recognition> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByUserId_Last(
			long userId, OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByUserId_Last(userId, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the last recognition in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByUserId_Last(
		long userId, OrderByComparator<Recognition> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Recognition> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Recognition[] findByUserId_PrevAndNext(
			long recognitionId, long userId,
			OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = findByPrimaryKey(recognitionId);

		Session session = null;

		try {
			session = openSession();

			Recognition[] array = new RecognitionImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, recognition, userId, orderByComparator, true);

			array[1] = recognition;

			array[2] = getByUserId_PrevAndNext(
				session, recognition, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Recognition getByUserId_PrevAndNext(
		Session session, Recognition recognition, long userId,
		OrderByComparator<Recognition> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RECOGNITION_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(recognition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Recognition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the recognitions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (Recognition recognition :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(recognition);
		}
	}

	/**
	 * Returns the number of recognitions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching recognitions
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RECOGNITION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"recognition.userId = ?";

	private FinderPath _finderPathWithPaginationFindByToUserId;
	private FinderPath _finderPathWithoutPaginationFindByToUserId;
	private FinderPath _finderPathCountByToUserId;

	/**
	 * Returns all the recognitions where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @return the matching recognitions
	 */
	@Override
	public List<Recognition> findByToUserId(long toUserId) {
		return findByToUserId(
			toUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Recognition> findByToUserId(long toUserId, int start, int end) {
		return findByToUserId(toUserId, start, end, null);
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
	@Override
	public List<Recognition> findByToUserId(
		long toUserId, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return findByToUserId(toUserId, start, end, orderByComparator, true);
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
	@Override
	public List<Recognition> findByToUserId(
		long toUserId, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByToUserId;
				finderArgs = new Object[] {toUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByToUserId;
			finderArgs = new Object[] {toUserId, start, end, orderByComparator};
		}

		List<Recognition> list = null;

		if (useFinderCache) {
			list = (List<Recognition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Recognition recognition : list) {
					if (toUserId != recognition.getToUserId()) {
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

			sb.append(_SQL_SELECT_RECOGNITION_WHERE);

			sb.append(_FINDER_COLUMN_TOUSERID_TOUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(toUserId);

				list = (List<Recognition>)QueryUtil.list(
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
	 * Returns the first recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByToUserId_First(
			long toUserId, OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByToUserId_First(
			toUserId, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toUserId=");
		sb.append(toUserId);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the first recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByToUserId_First(
		long toUserId, OrderByComparator<Recognition> orderByComparator) {

		List<Recognition> list = findByToUserId(
			toUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByToUserId_Last(
			long toUserId, OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByToUserId_Last(
			toUserId, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("toUserId=");
		sb.append(toUserId);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the last recognition in the ordered set where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByToUserId_Last(
		long toUserId, OrderByComparator<Recognition> orderByComparator) {

		int count = countByToUserId(toUserId);

		if (count == 0) {
			return null;
		}

		List<Recognition> list = findByToUserId(
			toUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Recognition[] findByToUserId_PrevAndNext(
			long recognitionId, long toUserId,
			OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = findByPrimaryKey(recognitionId);

		Session session = null;

		try {
			session = openSession();

			Recognition[] array = new RecognitionImpl[3];

			array[0] = getByToUserId_PrevAndNext(
				session, recognition, toUserId, orderByComparator, true);

			array[1] = recognition;

			array[2] = getByToUserId_PrevAndNext(
				session, recognition, toUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Recognition getByToUserId_PrevAndNext(
		Session session, Recognition recognition, long toUserId,
		OrderByComparator<Recognition> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RECOGNITION_WHERE);

		sb.append(_FINDER_COLUMN_TOUSERID_TOUSERID_2);

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
			sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(toUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(recognition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Recognition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the recognitions where toUserId = &#63; from the database.
	 *
	 * @param toUserId the to user ID
	 */
	@Override
	public void removeByToUserId(long toUserId) {
		for (Recognition recognition :
				findByToUserId(
					toUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(recognition);
		}
	}

	/**
	 * Returns the number of recognitions where toUserId = &#63;.
	 *
	 * @param toUserId the to user ID
	 * @return the number of matching recognitions
	 */
	@Override
	public int countByToUserId(long toUserId) {
		FinderPath finderPath = _finderPathCountByToUserId;

		Object[] finderArgs = new Object[] {toUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RECOGNITION_WHERE);

			sb.append(_FINDER_COLUMN_TOUSERID_TOUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(toUserId);

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

	private static final String _FINDER_COLUMN_TOUSERID_TOUSERID_2 =
		"recognition.toUserId = ?";

	private FinderPath _finderPathWithPaginationFindByValue;
	private FinderPath _finderPathWithoutPaginationFindByValue;
	private FinderPath _finderPathCountByValue;

	/**
	 * Returns all the recognitions where value = &#63;.
	 *
	 * @param value the value
	 * @return the matching recognitions
	 */
	@Override
	public List<Recognition> findByValue(String value) {
		return findByValue(value, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Recognition> findByValue(String value, int start, int end) {
		return findByValue(value, start, end, null);
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
	@Override
	public List<Recognition> findByValue(
		String value, int start, int end,
		OrderByComparator<Recognition> orderByComparator) {

		return findByValue(value, start, end, orderByComparator, true);
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
	@Override
	public List<Recognition> findByValue(
		String value, int start, int end,
		OrderByComparator<Recognition> orderByComparator,
		boolean useFinderCache) {

		value = Objects.toString(value, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByValue;
				finderArgs = new Object[] {value};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByValue;
			finderArgs = new Object[] {value, start, end, orderByComparator};
		}

		List<Recognition> list = null;

		if (useFinderCache) {
			list = (List<Recognition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Recognition recognition : list) {
					if (!value.equals(recognition.getValue())) {
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

			sb.append(_SQL_SELECT_RECOGNITION_WHERE);

			boolean bindValue = false;

			if (value.isEmpty()) {
				sb.append(_FINDER_COLUMN_VALUE_VALUE_3);
			}
			else {
				bindValue = true;

				sb.append(_FINDER_COLUMN_VALUE_VALUE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindValue) {
					queryPos.add(value);
				}

				list = (List<Recognition>)QueryUtil.list(
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
	 * Returns the first recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByValue_First(
			String value, OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByValue_First(value, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("value=");
		sb.append(value);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the first recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByValue_First(
		String value, OrderByComparator<Recognition> orderByComparator) {

		List<Recognition> list = findByValue(value, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition
	 * @throws NoSuchRecognitionException if a matching recognition could not be found
	 */
	@Override
	public Recognition findByValue_Last(
			String value, OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByValue_Last(value, orderByComparator);

		if (recognition != null) {
			return recognition;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("value=");
		sb.append(value);

		sb.append("}");

		throw new NoSuchRecognitionException(sb.toString());
	}

	/**
	 * Returns the last recognition in the ordered set where value = &#63;.
	 *
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching recognition, or <code>null</code> if a matching recognition could not be found
	 */
	@Override
	public Recognition fetchByValue_Last(
		String value, OrderByComparator<Recognition> orderByComparator) {

		int count = countByValue(value);

		if (count == 0) {
			return null;
		}

		List<Recognition> list = findByValue(
			value, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Recognition[] findByValue_PrevAndNext(
			long recognitionId, String value,
			OrderByComparator<Recognition> orderByComparator)
		throws NoSuchRecognitionException {

		value = Objects.toString(value, "");

		Recognition recognition = findByPrimaryKey(recognitionId);

		Session session = null;

		try {
			session = openSession();

			Recognition[] array = new RecognitionImpl[3];

			array[0] = getByValue_PrevAndNext(
				session, recognition, value, orderByComparator, true);

			array[1] = recognition;

			array[2] = getByValue_PrevAndNext(
				session, recognition, value, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Recognition getByValue_PrevAndNext(
		Session session, Recognition recognition, String value,
		OrderByComparator<Recognition> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RECOGNITION_WHERE);

		boolean bindValue = false;

		if (value.isEmpty()) {
			sb.append(_FINDER_COLUMN_VALUE_VALUE_3);
		}
		else {
			bindValue = true;

			sb.append(_FINDER_COLUMN_VALUE_VALUE_2);
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
			sb.append(RecognitionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindValue) {
			queryPos.add(value);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(recognition)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Recognition> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the recognitions where value = &#63; from the database.
	 *
	 * @param value the value
	 */
	@Override
	public void removeByValue(String value) {
		for (Recognition recognition :
				findByValue(
					value, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(recognition);
		}
	}

	/**
	 * Returns the number of recognitions where value = &#63;.
	 *
	 * @param value the value
	 * @return the number of matching recognitions
	 */
	@Override
	public int countByValue(String value) {
		value = Objects.toString(value, "");

		FinderPath finderPath = _finderPathCountByValue;

		Object[] finderArgs = new Object[] {value};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RECOGNITION_WHERE);

			boolean bindValue = false;

			if (value.isEmpty()) {
				sb.append(_FINDER_COLUMN_VALUE_VALUE_3);
			}
			else {
				bindValue = true;

				sb.append(_FINDER_COLUMN_VALUE_VALUE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindValue) {
					queryPos.add(value);
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

	private static final String _FINDER_COLUMN_VALUE_VALUE_2 =
		"recognition.value = ?";

	private static final String _FINDER_COLUMN_VALUE_VALUE_3 =
		"(recognition.value IS NULL OR recognition.value = '')";

	public RecognitionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Recognition.class);

		setModelImplClass(RecognitionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the recognition in the entity cache if it is enabled.
	 *
	 * @param recognition the recognition
	 */
	@Override
	public void cacheResult(Recognition recognition) {
		entityCache.putResult(
			RecognitionImpl.class, recognition.getPrimaryKey(), recognition);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {recognition.getUuid(), recognition.getGroupId()},
			recognition);
	}

	/**
	 * Caches the recognitions in the entity cache if it is enabled.
	 *
	 * @param recognitions the recognitions
	 */
	@Override
	public void cacheResult(List<Recognition> recognitions) {
		for (Recognition recognition : recognitions) {
			if (entityCache.getResult(
					RecognitionImpl.class, recognition.getPrimaryKey()) ==
						null) {

				cacheResult(recognition);
			}
		}
	}

	/**
	 * Clears the cache for all recognitions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RecognitionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the recognition.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Recognition recognition) {
		entityCache.removeResult(RecognitionImpl.class, recognition);
	}

	@Override
	public void clearCache(List<Recognition> recognitions) {
		for (Recognition recognition : recognitions) {
			entityCache.removeResult(RecognitionImpl.class, recognition);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RecognitionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RecognitionModelImpl recognitionModelImpl) {

		Object[] args = new Object[] {
			recognitionModelImpl.getUuid(), recognitionModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, recognitionModelImpl, false);
	}

	/**
	 * Creates a new recognition with the primary key. Does not add the recognition to the database.
	 *
	 * @param recognitionId the primary key for the new recognition
	 * @return the new recognition
	 */
	@Override
	public Recognition create(long recognitionId) {
		Recognition recognition = new RecognitionImpl();

		recognition.setNew(true);
		recognition.setPrimaryKey(recognitionId);

		String uuid = PortalUUIDUtil.generate();

		recognition.setUuid(uuid);

		recognition.setCompanyId(CompanyThreadLocal.getCompanyId());

		return recognition;
	}

	/**
	 * Removes the recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition that was removed
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	@Override
	public Recognition remove(long recognitionId)
		throws NoSuchRecognitionException {

		return remove((Serializable)recognitionId);
	}

	/**
	 * Removes the recognition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the recognition
	 * @return the recognition that was removed
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	@Override
	public Recognition remove(Serializable primaryKey)
		throws NoSuchRecognitionException {

		Session session = null;

		try {
			session = openSession();

			Recognition recognition = (Recognition)session.get(
				RecognitionImpl.class, primaryKey);

			if (recognition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRecognitionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(recognition);
		}
		catch (NoSuchRecognitionException noSuchEntityException) {
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
	protected Recognition removeImpl(Recognition recognition) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(recognition)) {
				recognition = (Recognition)session.get(
					RecognitionImpl.class, recognition.getPrimaryKeyObj());
			}

			if (recognition != null) {
				session.delete(recognition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (recognition != null) {
			clearCache(recognition);
		}

		return recognition;
	}

	@Override
	public Recognition updateImpl(Recognition recognition) {
		boolean isNew = recognition.isNew();

		if (!(recognition instanceof RecognitionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(recognition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(recognition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in recognition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Recognition implementation " +
					recognition.getClass());
		}

		RecognitionModelImpl recognitionModelImpl =
			(RecognitionModelImpl)recognition;

		if (Validator.isNull(recognition.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			recognition.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (recognition.getCreateDate() == null)) {
			if (serviceContext == null) {
				recognition.setCreateDate(now);
			}
			else {
				recognition.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!recognitionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				recognition.setModifiedDate(now);
			}
			else {
				recognition.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(recognition);
			}
			else {
				recognition = (Recognition)session.merge(recognition);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RecognitionImpl.class, recognitionModelImpl, false, true);

		cacheUniqueFindersCache(recognitionModelImpl);

		if (isNew) {
			recognition.setNew(false);
		}

		recognition.resetOriginalValues();

		return recognition;
	}

	/**
	 * Returns the recognition with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the recognition
	 * @return the recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	@Override
	public Recognition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRecognitionException {

		Recognition recognition = fetchByPrimaryKey(primaryKey);

		if (recognition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRecognitionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return recognition;
	}

	/**
	 * Returns the recognition with the primary key or throws a <code>NoSuchRecognitionException</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition
	 * @throws NoSuchRecognitionException if a recognition with the primary key could not be found
	 */
	@Override
	public Recognition findByPrimaryKey(long recognitionId)
		throws NoSuchRecognitionException {

		return findByPrimaryKey((Serializable)recognitionId);
	}

	/**
	 * Returns the recognition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recognitionId the primary key of the recognition
	 * @return the recognition, or <code>null</code> if a recognition with the primary key could not be found
	 */
	@Override
	public Recognition fetchByPrimaryKey(long recognitionId) {
		return fetchByPrimaryKey((Serializable)recognitionId);
	}

	/**
	 * Returns all the recognitions.
	 *
	 * @return the recognitions
	 */
	@Override
	public List<Recognition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Recognition> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Recognition> findAll(
		int start, int end, OrderByComparator<Recognition> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Recognition> findAll(
		int start, int end, OrderByComparator<Recognition> orderByComparator,
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

		List<Recognition> list = null;

		if (useFinderCache) {
			list = (List<Recognition>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RECOGNITION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RECOGNITION;

				sql = sql.concat(RecognitionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Recognition>)QueryUtil.list(
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
	 * Removes all the recognitions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Recognition recognition : findAll()) {
			remove(recognition);
		}
	}

	/**
	 * Returns the number of recognitions.
	 *
	 * @return the number of recognitions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RECOGNITION);

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
		return _SQL_SELECT_RECOGNITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RecognitionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the recognition persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new RecognitionModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Recognition.class.getName()));

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

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByToUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByToUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"toUserId"}, true);

		_finderPathWithoutPaginationFindByToUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByToUserId",
			new String[] {Long.class.getName()}, new String[] {"toUserId"},
			true);

		_finderPathCountByToUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByToUserId",
			new String[] {Long.class.getName()}, new String[] {"toUserId"},
			false);

		_finderPathWithPaginationFindByValue = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByValue",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"value"}, true);

		_finderPathWithoutPaginationFindByValue = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByValue",
			new String[] {String.class.getName()}, new String[] {"value"},
			true);

		_finderPathCountByValue = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByValue",
			new String[] {String.class.getName()}, new String[] {"value"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(RecognitionImpl.class.getName());

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

	private static final String _SQL_SELECT_RECOGNITION =
		"SELECT recognition FROM Recognition recognition";

	private static final String _SQL_SELECT_RECOGNITION_WHERE =
		"SELECT recognition FROM Recognition recognition WHERE ";

	private static final String _SQL_COUNT_RECOGNITION =
		"SELECT COUNT(recognition) FROM Recognition recognition";

	private static final String _SQL_COUNT_RECOGNITION_WHERE =
		"SELECT COUNT(recognition) FROM Recognition recognition WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "recognition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Recognition exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Recognition exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RecognitionPersistenceImpl.class);

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

	private static class RecognitionModelArgumentsResolver
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

			RecognitionModelImpl recognitionModelImpl =
				(RecognitionModelImpl)baseModel;

			long columnBitmask = recognitionModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(recognitionModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						recognitionModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(recognitionModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			RecognitionModelImpl recognitionModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = recognitionModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = recognitionModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}