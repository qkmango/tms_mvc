package cn.qkmango.tms.basicQuery.controller;


import cn.qkmango.tms.basicQuery.service.QueryService;
import cn.qkmango.tms.domain.*;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/query")
public class QueryController {


    @Resource
    private QueryService queryService;


    @Permission({PermissionType.teacher, PermissionType.student})
    @RequestMapping("/test.do")
    @ResponseBody
    public String test() {
        return "test";
    }

    /**
     * 查询院系列表
     * @return
     */
    @RequestMapping("/getFacultyList.do")
    @ResponseBody
    public Map<String, Object> getFacultyList() {

        List<Faculty> facultyList = queryService.getFacultyList();

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(facultyList);

        return map;
    }

    /**
     * 查询指定院系的所有专业
     * faculty 表示院系的id，数据库中存储的为 int类型，但是前端请求的是 String类型
     * @return
     */
    @RequestMapping("/getSpecializedListByFaculty.do")
    @ResponseBody
    public Map<String, Object> getSpecializedListByFaculty(Integer faculty) {

        List<Specialized> SpecializedList = queryService.getSpecializedListByFaculty(faculty);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(SpecializedList);

        return map;
    }


    /**
     * 查询指定专业的所有班级
     * faculty 表示院系的id，数据库中存储的为 int类型，但是前端请求的是 String类型
     * @return
     */
    @RequestMapping("/getClazzListBySpecialized.do")
    @ResponseBody
    public Map<String, Object> getClazzListBySpecialized(Integer specialized) {

        List<Clazz> ClazzList = queryService.getClazzListBySpecialized(specialized);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(ClazzList);

        return map;
    }

    /**
     * 获取指定的老师和班级的 科目列表
     * @param clazz 前端传入的 班级id
     * @param teacher 前端传入的 老师id
     * @return
     */
    @RequestMapping("/getCourseListByTeacherAndClazz.do")
    @ResponseBody
    public Map<String, Object> getCourseListByTeacherAndClazz(Integer clazz,Integer teacher) {

        HashMap<String, Integer> paramsMap = new HashMap<>();
        paramsMap.put("clazz", clazz);
        paramsMap.put("teacher",teacher);
        List<Course> CourseList = queryService.getCourseListByTeacherAndClazz(paramsMap);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(CourseList);

        return map;
    }

    /**
     * 获取学生成绩列表分页
     * @return
     */
    @RequestMapping("/getStudentScorePagination.do")
    @Permission({PermissionType.admin,PermissionType.teacher})
    @ResponseBody
    public Map<String, Object> getStudentScorePagination(StudentScorePagination pagination) {

        HashMap<String,Object> map = queryService.getStudentScorePagination(pagination);

        map.put("code",0);
        map.put("success",true);
        map.put("message","获取学生成绩分页列表成功");

        return map;
    }

}
