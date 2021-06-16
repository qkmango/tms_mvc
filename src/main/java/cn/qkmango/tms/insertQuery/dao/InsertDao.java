package cn.qkmango.tms.insertQuery.dao;

import cn.qkmango.tms.domain.Course;

public interface InsertDao {

    int insertCourse(Course course);

    int lastInsertId();


}
