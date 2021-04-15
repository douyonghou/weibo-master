package com.gr.geias.controller;

import com.gr.geias.entity.*;
import com.gr.geias.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @version 1.0
 * @date 2021-03-12 18:03
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    CollegeService collegeService;
    @Autowired
    SpecialtyService specialtyService;
    @Autowired
    ClassGradeService classGradeService;
    @Autowired
    EmploymentWayService employmentWayService;
    @Autowired
    UnitKindService unitKindService;
    @Autowired
    EmploymentInformationService employmentInformationService;

    @RequestMapping("/getcollege")
    public Map<String, Object> getCollege() {
        Map<String, Object> map = new HashMap<>(3);
        List<College> collegeList = collegeService.getCollege(null);
        map.put("success", true);
        map.put("collegeList", collegeList);
        return map;
    }

    @RequestMapping("/getspecialty")
    public Map<String, Object> getSpecialty(@RequestParam("collegeId") Integer collegeId) {
        Map<String, Object> map = new HashMap<>(3);
        List<Specialty> specialty = specialtyService.getSpecialty(collegeId);
        map.put("success", true);
        map.put("specialtyList", specialty);
        return map;
    }

    @RequestMapping("/getclassgrade")
    public Map<String, Object> getClassGrade(@RequestParam("specialtyId") Integer specialtyId) {
        Map<String, Object> map = new HashMap<>(3);
        List<ClassGrade> classGrade = classGradeService.getClassGrade(specialtyId, null);
        map.put("success", true);
        map.put("classGradeList", classGrade);
        return map;
    }

    @RequestMapping("/getinit")
    public Map<String, Object> getinit() {
        Map<String, Object> map = new HashMap<>(4);
        List<EmploymentWay> employmentWay = employmentWayService.getEmploymentWay();
        map.put("employmentWayList", employmentWay);
        List<UnitKind> unitKind = unitKindService.getUnitKind();
        map.put("unitKindList", unitKind);
        map.put("success", true);
        return map;
    }


}
