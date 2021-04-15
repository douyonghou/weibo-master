package com.gr.geias.service.impl;

import com.gr.geias.entity.*;
import com.gr.geias.mapper.EmploymentInformationMapper;
import com.gr.geias.mapper.OrganizationNumMapper;
import com.gr.geias.service.OrganizationNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-09 09:13
 */
@Service
public class OrganizationNumServiceImpl implements OrganizationNumService {
    @Autowired
    OrganizationNumMapper organizationNumMapper;

    @Autowired
    EmploymentInformationMapper employmentInformationMapper;

    @Override
    public Integer getcollegeCount(Integer collegeId) {
        return organizationNumMapper.queryCountByCollegeId(collegeId);
    }

    @Override
    public Integer getspecialtyCount(Integer specialtyId) {
        return organizationNumMapper.queryCountByspecialtyId(specialtyId);
    }

    @Override
    public Integer getClassGradeCount(Integer classId) {
        return organizationNumMapper.queryCountByclassId(classId);
    }

    @Override
    public Boolean updateClassGradesum(OrganizationNum organizationNum) {
        Integer integer = organizationNumMapper.updateNumByClassGradeId(organizationNum.getSum(), organizationNum.getClassId());
        if (integer > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer geiAllCollegeSum() {
        return organizationNumMapper.queryAllCollegeSum();
    }

    @Override
    public List<SexCnt> getSexList()  {
        return organizationNumMapper.getSextSum();
    }

    @Override
    public List<CityCnt> getCityList() {
        return organizationNumMapper.getCItytSum();
    }

    @Override
    public List<TimeCnt> getTimeList()  {
        return organizationNumMapper.getTimeSum();
    }
}
