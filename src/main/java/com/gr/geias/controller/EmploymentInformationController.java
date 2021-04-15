package com.gr.geias.controller;


import com.gr.geias.dto.CollegeAndPerson;
import com.gr.geias.dto.EmploymentInformationMsg;
import com.gr.geias.entity.*;
import com.gr.geias.enums.EnableStatusEnums;
import com.gr.geias.service.EmploymentInformationService;
import com.gr.geias.service.EmploymentWayService;
import com.gr.geias.service.UnitKindService;
import com.gr.geias.util.ExcalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2021-03-06
 */
@RestController
@RequestMapping("/employmentinformation")
public class EmploymentInformationController {
    @Autowired
    EmploymentInformationService informationService;
    @Autowired
    EmploymentWayService employmentWayService;
    @Autowired
    UnitKindService unitKindService;
    @Autowired
    ExcalUtil excalUtil;

    /**
     * @return
     */
    @RequestMapping("/getemploymentinfo")
    public Map<String, Object> getemploymentinfo() {
        Map<String,Object> map = new HashMap<>(3);
        List<EmploymentInformation> list = new ArrayList<>();
        EmploymentInformation employmentInformation = new EmploymentInformation();
        List<EmploymentInformation> employmentInfoList = informationService.getEmploymentInfoList(employmentInformation, 0).getList();
        for (EmploymentInformation employmentInfo: employmentInfoList) {
            System.out.println(employmentInfo.getId());
            list.add(employmentInfo);
        }
        map.put("success", true);
        map.put("List", list);
        return map;
    }




}
