package cn.qkmango.tms.insertQuery.service;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.exception.InsertException;
import cn.qkmango.tms.web.model.CourseInfoModel;

public interface InsertService {
    void insertCourse(Course course, CourseInfoModel courseInfoModel) throws InsertException;

    void insertBuilding(Building building) throws InsertException;
    // void insertCourseInfo(CourseInfoModel courseInfos);
}
