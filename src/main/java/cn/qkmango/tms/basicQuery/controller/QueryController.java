package cn.qkmango.tms.basicQuery.controller;


import cn.qkmango.tms.basicQuery.service.QueryService;
import cn.qkmango.tms.domain.*;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import cn.qkmango.tms.web.model.CourseInfoModel;
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


    @ResponseBody
    @RequestMapping("/test.do")
    public String test(Course course, CourseInfoModel courseInfos) {

        System.out.println(course);

        System.out.println("size "+courseInfos.size());
        List<CourseInfo> courseInfoList = courseInfos.getCourseInfos();
        for (int i = 0; i < 2; i++) {
            System.out.println(courseInfoList.get(i));
        }

        return null;
    }

    /**
     * 查询院系列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getFacultyList.do")
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
    @ResponseBody
    @RequestMapping("/getSpecializedListByFaculty.do")
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
    @ResponseBody
    @RequestMapping("/getClazzListBySpecialized.do")
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
    @ResponseBody
    @RequestMapping("/getCourseListByTeacherAndClazz.do")
    public Map<String, Object> getCourseListByTeacherAndClazz(Integer clazz,Integer teacher) {

        HashMap<String, Integer> paramsMap = new HashMap<>();
        paramsMap.put("clazz", clazz);
        paramsMap.put("teacher",teacher);
        List<Course> CourseList = queryService.getCourseListByTeacherAndClazz(paramsMap);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("条件(TeacherAndClazz)获取学科列表成功");
        map.setData(CourseList);

        return map;
    }

    /**
     * 获取学生成绩列表分页
     * @return
     */
    @ResponseBody
    @Permission({PermissionType.admin,PermissionType.teacher})
    @RequestMapping("/getStudentScorePagination.do")
    public Map<String, Object> getStudentScorePagination(StudentScorePagination pagination) {

        HashMap<String,Object> map = queryService.getStudentScorePagination(pagination);

        map.put("success",true);
        map.put("message","获取学生成绩分页列表成功");

        return map;
    }


    @ResponseBody
    @RequestMapping("/getTeacherList.do")
    public Map<String, Object> getTeacherList(Teacher teacher) {

        List<Teacher> data = queryService.getTeacherList(teacher);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("获取老师列表成功");
        map.setData(data);

        return map;
    }

    /**
     * 条件获取 楼 列表（不分页）
     * @param building
     * @return
     */
    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("/getBuildingList.do")
    public Map<String, Object> getBuildingList(Building building) {

        List<Building> data = queryService.getBuildingList(building);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("获取教学楼列表成功");
        map.setData(data);

        return map;
    }


}
