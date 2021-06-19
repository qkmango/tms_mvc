package cn.qkmango.tms.insertQuery.controller;


import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.domain.CourseInfo;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.exception.InsertException;
import cn.qkmango.tms.insertQuery.service.InsertService;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import cn.qkmango.tms.web.model.CourseInfoModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/insert")
public class InsertController {


    @Resource
    private InsertService service;

    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("/insertCourse.do")
    public Map<String, Object> insertCourse(Course course, CourseInfoModel courseInfoModel) throws InsertException {

        service.insertCourse(course,courseInfoModel);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("添加课程成功");

        return map;
    }


    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("insertBuilding.do")
    public Map<String, Object> insertBuilding(Building building) throws InsertException {

        service.insertBuilding(building);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("添加楼成功");

        return map;
    }

    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("insertRoom.do")
    public Map<String, Object> insertRoom(Room room) throws InsertException {

        service.insertRoom(room);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("添加教室成功");

        return map;
    }

}
