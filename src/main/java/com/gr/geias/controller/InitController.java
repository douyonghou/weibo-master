package com.gr.geias.controller;


import com.gr.geias.entity.*;
import com.gr.geias.enums.EnableStatusEnums;
import com.gr.geias.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author maotentai
 * @since 2021-03-06
 */
@RestController
@RequestMapping("/init")
public class InitController {
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

    /**
     * 获取高级分类信息 如：班级 专业 学院 权限 0，1，2
     * @param levelId
     * @param request
     * @return
     */
    @RequestMapping("/getleve")
    public Map<String,Object> getLeve(@Param("levelId")Integer levelId,HttpServletRequest request){

        Map<String,Object> map = new HashMap<>(3);
        PersonInfo person = (PersonInfo)request.getSession().getAttribute("person");
        if (levelId!=null && levelId==0){
            if (person.getEnableStatus()==EnableStatusEnums.schoolmaster.getState()){
                List<College> college = collegeService.getCollege(null);
                map.put("success",true);
                map.put("list",college);
                map.put("level", 2);
            }
            if (person.getEnableStatus()==EnableStatusEnums.PREXY.getState()){
                List<College> college = collegeService.getCollege(person.getPersonId());
                College college1 = college.get(0);
                List<Specialty> specialty = specialtyService.getSpecialty(college1.getCollegeId());
                map.put("success",true);
                map.put("list",specialty);
                map.put("level", 1);
            }
            if (person.getEnableStatus()==EnableStatusEnums.TEACHER.getState()){
                List<ClassGrade> classGrade = classGradeService.getClassGrade(null, person.getPersonId());
                map.put("success",true);
                map.put("list",classGrade);
                map.put("level", 0);
            }
        }
        return map;
    }


}
