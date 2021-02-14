/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package hong.recog.service.impl;

import com.liferay.portal.aop.AopService;
import hong.recog.model.PerformanceRecognition;
import hong.recog.service.RecognitionLocalService;
import hong.recog.service.base.PerformanceRecognitionLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the performance recognition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the <code>hong.recog.service.PerformanceRecognitionLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hong
 * @see PerformanceRecognitionLocalServiceBaseImpl
 */
@Component(
    property = "model.class.name=hong.recog.model.PerformanceRecognition",
    service = AopService.class
)
public class PerformanceRecognitionLocalServiceImpl
    extends PerformanceRecognitionLocalServiceBaseImpl {

  public PerformanceRecognition addPerformanceRecognition(
      long recognitionId,
      String detail1,
      String detail2) {
    PerformanceRecognition performanceRecognition = createPerformanceRecognition(recognitionId);
    performanceRecognition.setRecognitionId(recognitionId);
    performanceRecognition.setDetail1(detail1);
    performanceRecognition.setDetail2(detail2);
    performanceRecognitionPersistence.update(performanceRecognition);
    return performanceRecognition;
  }

  @Reference
  private RecognitionLocalService recognitionLocalService;

  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never reference this class directly. Use <code>hong.recog.service.PerformanceRecognitionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>hong.recog.service.PerformanceRecognitionLocalServiceUtil</code>.
   */
}