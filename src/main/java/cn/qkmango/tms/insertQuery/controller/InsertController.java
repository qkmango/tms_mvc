package cn.qkmango.tms.insertQuery.controller;


import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.exception.InsertException;
import cn.qkmango.tms.insertQuery.service.InsertService;
import cn.qkmango.tms.web.map.ResponseMap;
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
    @RequestMapping("addCourse.do")
    public Map<String, Object> addCourse(Course course) throws InsertException {
        service.insertCourse(course);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("添加课程成功");

        return map;
    }

}
