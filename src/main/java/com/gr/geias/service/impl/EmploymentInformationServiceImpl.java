package com.gr.geias.service.impl;

import com.gr.geias.dto.EmploymentInformationMsg;
import com.gr.geias.entity.EmploymentInformation;
import com.gr.geias.entity.PersonInfo;
import com.gr.geias.mapper.EmploymentInformationMapper;
import com.gr.geias.service.EmploymentInformationService;
import com.gr.geias.util.PageMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @since 2020-03-06
 */
@Service
class EmploymentInformationServiceImpl implements EmploymentInformationService {


    @Autowired
    EmploymentInformationMapper informationMapper;

    @Override
    public EmploymentInformationMsg getEmploymentInfoList(EmploymentInformation information, int i) {
        List<EmploymentInformation> employmentInformations = informationMapper.queryList(information);
        EmploymentInformationMsg employmentInformationMsg = new EmploymentInformationMsg();
        employmentInformationMsg.setList(employmentInformations);
        return employmentInformationMsg;
    }

    @Override
    public Integer getCount(EmploymentInformation information, PersonInfo personInfo,Integer[] salary) {
        return informationMapper.queryListCount(information, personInfo, salary);
    }

    @Override
    public Integer addEmpoymentInfo(EmploymentInformation employmentInformation) {
        return informationMapper.insertEmploymentInformation(employmentInformation);
    }

    @Override
    public EmploymentInformation getInfoByStudentNum(Integer studentNum) {
        return informationMapper.qureyInfoByStudentNum(studentNum);
    }

    @Override
    public Integer updateInfo(EmploymentInformation employmentInformation) {
        return informationMapper.updayeInfo(employmentInformation);
    }
}
