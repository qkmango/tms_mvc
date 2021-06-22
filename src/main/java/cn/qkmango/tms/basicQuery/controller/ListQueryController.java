package cn.qkmango.tms.basicQuery.controller;


import cn.qkmango.tms.basicQuery.service.QueryService;
import cn.qkmango.tms.domain.*;
import cn.qkmango.tms.domain.pagination.RoomPagination;
import cn.qkmango.tms.domain.pagination.StudentScorePagination;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/query")
public class ListQueryController {


    @Resource
    private QueryService queryService;


    @ResponseBody
    @RequestMapping("/test.do")
    public Map test(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        User user;
        if (session == null) {
            user = new User(1,null,"admin",PermissionType.admin);
            request.getSession(true).setAttribute("user",user);
        } else {
            user = (User)request.getSession().getAttribute("user");
        }

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.put("user",user);

        return map;
    }

    @ResponseBody
    @RequestMapping("/test2.do")
    public Map test2(@RequestParam Map<String, Object> map) {

        System.out.println(map);


        return map;
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
     * 条件查询专业列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSpecializedList.do")
    public Map<String, Object> getSpecializedList(Specialized specialized) {

        List<Specialized> SpecializedList = queryService.getSpecializedList(specialized);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(SpecializedList);

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
    @ResponseBody
    @Permission(PermissionType.teacher)
    @RequestMapping("/getClazzList.do")
    public Map<String, Object> getClazzList(Clazz clazz) {

        List<Clazz> ClazzList = queryService.getClazzList(clazz);

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
    @Permission(PermissionType.teacher)
    @RequestMapping("/getCourseListByTeacherAndClazz.do")
    public Map<String, Object> getCourseListByTeacherAndClazz(Integer clazz, Integer teacher) {

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


    /**
     * 条件获取 年份 列表
     * @param year
     * @return
     */
    @ResponseBody
    @RequestMapping("/getYearList.do")
    public Map<String, Object> getYearList(Year year) {

        List<Year> data = queryService.getYearList(year);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("获取年份列表成功");
        map.setData(data);

        return map;
    }



}