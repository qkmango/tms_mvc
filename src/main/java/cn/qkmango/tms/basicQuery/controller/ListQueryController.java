package cn.qkmango.tms.basicQuery.controller;


import cn.qkmango.tms.basicQuery.service.ListQueryService;
import cn.qkmango.tms.common.anno.Permission;
import cn.qkmango.tms.domain.*;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.common.map.ResponseMap;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author qkmango
 */
@RestController
@RequestMapping("/query")
public class ListQueryController {


    @Resource
    private ListQueryService listQueryService;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    @RequestMapping("/test.do")
    public Map test(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        User user;
        if (session == null) {
            user = new User(1,null,"芒果小洛",PermissionType.student);
            request.getSession(true).setAttribute("user",user);
        } else {
            user = (User)request.getSession().getAttribute("user");
        }

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.put("user",user);

        return map;
    }

    /**
     * 查询院系列表
     * @return
     */
    @RequestMapping("/getFacultyList.do")
    public Map<String, Object> getFacultyList() {

        List<Faculty> facultyList = listQueryService.getFacultyList();

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(facultyList);

        return map;
    }

    /**
     * 条件查询专业列表
     * @return
     */
    @RequestMapping("/getSpecializedList.do")
    public Map<String, Object> getSpecializedList(Specialized specialized) {

        List<Specialized> specializedList = listQueryService.getSpecializedList(specialized);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(specializedList);

        return map;
    }


    /**
     * 查询指定专业的所有班级
     * teacher 角色 在使用学生成绩修改模块时，条件查询时获取下拉列表使用的
     * Map接收的参数有
     *      faculty     表示院系的id，数据库中存储的为 int类型，但是前端请求的是 String类型
     *      courseYear  学科开设的年份
     *      term        学科开设的学期
     *      clazzYear   班级年级（如2020级）
     * @return
     */
    @Permission(PermissionType.teacher)
    @RequestMapping("/getClazzList.do")
    public Map<String, Object> getClazzList(Clazz clazz) {

        List<Clazz> clazzList = listQueryService.getClazzList(clazz);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(clazzList);

        return map;
    }

    /**
     * 获取指定的老师和班级的 科目列表
     * @param clazz 前端传入的 班级id
     * @param teacher 前端传入的 老师id
     * @return
     */
    @Permission(PermissionType.teacher)
    @RequestMapping("/getCourseListByTeacherAndClazz.do")
    public Map<String, Object> getCourseListByTeacherAndClazz(Integer clazz, Integer teacher) {

        HashMap<String, Integer> params = new HashMap<>(2);
        params.put("clazz", clazz);
        params.put("teacher",teacher);
        List<Course> courseList = listQueryService.getCourseListByTeacherAndClazz(params);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(courseList);

        return map;
    }

    @RequestMapping("/getTeacherList.do")
    public Map<String, Object> getTeacherList(Teacher teacher) {

        List<Teacher> data = listQueryService.getTeacherList(teacher);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }

    /**
     * 条件获取 楼 列表（不分页）
     * @param building
     * @return
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/getBuildingList.do")
    public Map<String, Object> getBuildingList(Building building) {

        List<Building> data = listQueryService.getBuildingList(building);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }


    /**
     * 条件获取 年份 列表
     * @param year
     * @return
     */
    @RequestMapping("/getYearList.do")
    public Map<String, Object> getYearList(Year year) {

        List<Year> data = listQueryService.getYearList(year);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }


    /**
     * 获取 当前学生选课列表（）包括已选和未选的课程
     * @return
     */
    @RequestMapping("/getStudentElectiveCourseList.do")
    public Map<String, Object> getStudentElectiveCourseList(Boolean alreadyElective, HttpSession session) {

        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        HashMap<String, Object> params = new HashMap<>(2);
        params.put("id",id);
        params.put("alreadyElective",alreadyElective);

        List<Map> data = listQueryService.getStudentElectiveCourseList(params);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }


    /**
     * 获取学生课表
     * @param session
     * @return
     */
    @RequestMapping("/getStudentTimetable.do")
    public Map<String,Object> getStudentTimetable(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer studentId = user.getId();

        List<Map> data = listQueryService.getStudentTimetable(studentId);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;

    }



}
