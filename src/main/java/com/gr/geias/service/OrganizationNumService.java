package com.gr.geias.service;

import com.gr.geias.entity.*;

import java.util.List;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-09 09:13
 */
public interface OrganizationNumService {
    /**
     * @param collegeId
     * @return
     */
    Integer getcollegeCount(Integer collegeId);

    /**
     * @param specialtyId 专业id
     * @return
     */
    Integer getspecialtyCount(Integer specialtyId);

    /**
     * @param classId
     * @return
     */
    Integer getClassGradeCount(Integer classId);

    /**
     * @param organizationNum
     * @return
     */
    Boolean updateClassGradesum(OrganizationNum organizationNum);

    /**
     * @return
     */
    Integer geiAllCollegeSum();

    /**
     * 获取性别
     * @return
     */
    List<SexCnt> getSexList();
    List<CityCnt> getCityList();
    List<TimeCnt> getTimeList();
}
