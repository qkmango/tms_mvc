package cn.qkmango.tms.insertQuery.controller;


import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.domain.Year;
import cn.qkmango.tms.exception.InsertException;
import cn.qkmango.tms.exception.ParamVerifyError;
import cn.qkmango.tms.insertQuery.service.InsertService;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import cn.qkmango.tms.web.model.CourseInfoModel;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(value = "/insert",method = RequestMethod.POST)
public class InsertController {

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

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
                                            @Validated CourseInfoModel courseInfoModel, BindingResult CourseInfoModelResult,
                                            Locale locale) throws InsertException {

        if (courseResult.hasErrors()||CourseInfoModelResult.hasErrors()) {
            throw new ParamVerifyError(courseResult,CourseInfoModelResult);
        }
        service.insertCourse(course,courseInfoModel,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.insertCourse.success",null,locale));

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
    public Map<String, Object> insertBuilding(@Validated Building building,BindingResult result,Locale locale) throws InsertException {

        if (result.hasErrors()) {
            throw new ParamVerifyError(result);
        }

        service.insertBuilding(building,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.insertBuilding.success",null,locale));

        return map;
    }

    /**
     * 添加教室
     * @validated true
     * @param room
     * @return
     * @throws InsertException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("insertRoom.do")
    public Map<String, Object> insertRoom(@Validated Room room,BindingResult result,Locale locale) throws InsertException {

        if (result.hasErrors()) {
            throw new ParamVerifyError(result);
        }

        service.insertRoom(room,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.insertRoom.success",null,locale));

        return map;
    }

    /**
     * 添加年度
     * @validated true
     * @param year 年度
     * @param result
     * @param locale
     * @return
     * @throws InsertException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("insertYear.do")
    public Map<String, Object> insertYear(@Validated Year year,BindingResult result,Locale locale) throws InsertException {

        if (result.hasErrors()) {
            throw new ParamVerifyError(result);
        }
        service.insertYear(year,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);

        map.setMessage(messageSource.getMessage("db.insertYear.success",null,locale));
        return map;
    }

}
