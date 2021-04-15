package com.gr.geias.controller;

import com.gr.geias.entity.*;
import com.gr.geias.enums.EnableStatusEnums;
import com.gr.geias.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-12 23:02
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    OrganizationNumService organizationNumService;
    @Autowired
    EmploymentInformationService employmentInformationService;
    @Autowired
    ClassGradeService classGradeService;
    @Autowired
    CollegeService collegeService;
    @Autowired
    SpecialtyService specialtyService;


    private static final Integer[][] SALARY = {{0, 3000}, {3000, 4000}, {4000, 5000}, {5000, 6000}, {6000, 7000}, {7000, 8000}, {8000, 9000}, {9000, 10000}, {10000, 11000}, {11000, 12000}, {12000, 13000}, {13000, 14000}, {14000, 100000000}};

    @RequestMapping(value = "/getcountbyarea", method = RequestMethod.GET)
    public Map<String, Object> getCountByArea(HttpServletRequest request) {
        Map<String, Object> ruslt = new HashMap<>(4);
        List<SexCnt> sexList = organizationNumService.getSexList();
        for (SexCnt sexCnt: sexList) {
            System.out.println(sexCnt.getSex()+sexCnt.getCnt());
            String type = sexCnt.getSex();
            int cnt = sexCnt.getCnt();
            switch (type){
                case "男": ruslt.put("yijiuye", cnt) ;
                break;
                case "女": ruslt.put("weijiuye", cnt);
                break;
            }
        }

        ruslt.put("success", true);
        return ruslt;
    }

    @RequestMapping(value = "/getcountbysalary", method = RequestMethod.GET)
    public Map<String, Object> getCountBySalary(HttpServletRequest request) {
        Map<String, Object> ruslt = new HashMap<>(4);
        List<String> cityTypeList = new ArrayList<>();
        List<Integer> cityCntList = new ArrayList<>();
        List<CityCnt> cityList = organizationNumService.getCityList();

        for (CityCnt cityCnt: cityList) {
            System.out.println(cityCnt.getCity()+cityCnt.getCnt());
            String type = cityCnt.getCity();
            int cnt = cityCnt.getCnt();
            cityCntList.add(cnt);
            cityTypeList.add(type);


        }
        ruslt.put("success", true);
        ruslt.put("cityType", cityTypeList);
        ruslt.put("cityCnt", cityCntList);
        return ruslt;
    }


    @RequestMapping(value = "/getcountorgratio", method = RequestMethod.GET)
    public Map<String, Object> getCountOrgRatio(HttpServletRequest request) {
        Map<String, Object> ruslt = new HashMap<>(4);
        List<String> timeTypeList = new ArrayList<>();
        List<Integer> timeCntList = new ArrayList<>();
        List<TimeCnt> timeList = organizationNumService.getTimeList();

        for (TimeCnt timeCnt: timeList) {
            System.out.println(timeCnt.getDt()+timeCnt.getCnt());
            String type = timeCnt.getDt();
            int cnt = timeCnt.getCnt();
            timeCntList.add(cnt);
            timeTypeList.add(type);


        }
        ruslt.put("success", true);
        ruslt.put("timeType", timeTypeList);
        ruslt.put("timeCnt", timeCntList);
        return ruslt;
    }



}
