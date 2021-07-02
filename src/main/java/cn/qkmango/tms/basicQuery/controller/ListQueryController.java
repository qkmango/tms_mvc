package cn.qkmango.tms.basicQuery.controller;


import cn.qkmango.tms.basicQuery.service.QueryService;
import cn.qkmango.tms.domain.*;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query")
public class ListQueryController {


    @Resource
    private QueryService queryService;


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

    @RequestMapping("/test2.do")
    public Map test2(@Validated User user, BindingResult resultUser) {


        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        map.put("message",list);

        if (resultUser.hasErrors()) {
            map.put("success",false);

            List<ObjectError> errors = resultUser.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
                list.add(error.getDefaultMessage());
            }
        }
        return map;
    }


    /**
     * 查询院系列表
     * @return
     */
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
