package cn.qkmango.tms.insertQuery.controller;


import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.exception.InsertException;
import cn.qkmango.tms.exception.ParamVerifyError;
import cn.qkmango.tms.insertQuery.service.InsertService;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import cn.qkmango.tms.web.model.CourseInfoModel;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/insert")
public class InsertController {


    @Resource
    private InsertService service;


    /**
     * 插入课程
     * @validated true
     * @param course 课程
     * @param courseResult
     * @param courseInfoModel 课程信息（每次上课的信息）
     * @param CourseInfoModelResult
     * @return
     * @throws InsertException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/insertCourse.do")
    public Map<String, Object> insertCourse(@Validated Course course, BindingResult courseResult,
                                            @Validated CourseInfoModel courseInfoModel, BindingResult CourseInfoModelResult) throws InsertException {

        if (courseResult.hasErrors()||CourseInfoModelResult.hasErrors()) {
            throw new ParamVerifyError(courseResult,CourseInfoModelResult);
        }
        service.insertCourse(course,courseInfoModel);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("添加课程成功");

        return map;
    }


    /**
     * 添加楼宇
     * @validated true
     * @param building 楼宇对象（楼号，楼名称）
     * @param result
     * @return
     * @throws InsertException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("insertBuilding.do")
    public Map<String, Object> insertBuilding(@Validated Building building,BindingResult result) throws InsertException {

        if (result.hasErrors()) {
            throw new ParamVerifyError(result);
        }

        service.insertBuilding(building);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("添加楼成功");

        return map;
    }

    @Permission(PermissionType.admin)
    @RequestMapping("insertRoom.do")
    public Map<String, Object> insertRoom(Room room) throws InsertException {

        service.insertRoom(room);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("添加教室成功");

        return map;
    }

    @Permission(PermissionType.admin)
    @RequestMapping("insertYear.do")
    public Map<String, Object> insertYear(Integer year) throws InsertException {

        service.insertYear(year);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("添加年度成功");

        return map;
    }

}
