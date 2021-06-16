package cn.qkmango.tms.insertQuery.service;

import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.exception.InsertException;

public interface InsertService {
    void insertCourse(Course course) throws InsertException;
}
