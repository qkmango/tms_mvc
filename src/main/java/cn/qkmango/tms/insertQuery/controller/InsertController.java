package cn.qkmango.tms.insertQuery.controller;


import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.domain.vo.InsertElectiveVO;
import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.insertQuery.service.InsertService;
import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.domain.model.CourseInfoModel;
import cn.qkmango.tms.common.validate.group.Insert.InsertRoom;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * 插入数据控制器
 *
 * 所有需要校验的字段都需要在字段后面跟 BindingResult result，
 * 类切面会自动拦截方法，
 * ControllerAspect 判断 result 对象中是否保存的有字段校验错误信息，如果有则直接响应给前端
 * @see cn.qkmango.tms.common.aspect.ControllerAspect
 */
@RestController
@RequestMapping(value = "/insert",method = RequestMethod.POST)
public class InsertController {

    @Resource
    private InsertService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    /**
     * 插入课程
     * @validated true
     * @param course 课程
     * @param courseResult
     * @param courseInfoModel 课程信息（每次上课的信息）
     * @param courseInfoModelResult
     * @return
     * @throws InsertException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/insertCourse.do")
    public Map<String, Object> insertCourse(@Validated Course course, BindingResult courseResult,
                                            @Validated CourseInfoModel courseInfoModel, BindingResult courseInfoModelResult,
                                            Locale locale) throws InsertException {

        // if (courseResult.hasErrors()|| courseInfoModelResult.hasErrors()) {
        //     throw new ParamVerifyException(courseResult, courseInfoModelResult);
        // }
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
    @RequestMapping("/insertBuilding.do")
    public Map<String, Object> insertBuilding(@Validated Building building, BindingResult result, Locale locale) throws InsertException {

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
    @RequestMapping("/insertRoom.do")
    public Map<String, Object> insertRoom(@Validated(InsertRoom.class) Room room, BindingResult result, Locale locale) throws InsertException {

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
    @RequestMapping("/insertYear.do")
    public Map<String, Object> insertYear(@Validated Year year, BindingResult result, Locale locale) throws InsertException {
        service.insertYear(year,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);

        map.setMessage(messageSource.getMessage("db.insertYear.success",null,locale));
        return map;
    }


    /**
     * 批量插入选课，学生进行选课
     * @validated true
     * @param electiveVO
     * @param session
     * @param locale
     * @return
     * @throws InsertException
     */
    @Permission(PermissionType.student)
    @RequestMapping("/insertElective.do")
    public Map<String, Object> insertElective(@Validated InsertElectiveVO electiveVO,
                                              BindingResult result,
                                              HttpSession session,
                                              Locale locale) throws InsertException {

        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        HashMap<String, Object> param = new HashMap<>(2);
        param.put("studentId",id);
        param.put("courseIds",electiveVO.getCourseIds());

        service.insertElective(param,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);

        map.setMessage(messageSource.getMessage("db.insertElective.success",null,locale));
        return map;
    }


    /**
     * 添加教学评价
     */
    @Permission(PermissionType.student)
    @RequestMapping("/insertTeachEvaluate.do")
    public Map insertTeachEvaluate(@Validated TeachEvaluate teachEvaluate,BindingResult result,HttpSession session, Locale locale) throws InsertException {

        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        teachEvaluate.setStudent(id);
        service.insertTeachEvaluate(teachEvaluate,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);

        map.setMessage(messageSource.getMessage("db.insertTeachEvaluate.success",null,locale));
        return map;
    }

}
