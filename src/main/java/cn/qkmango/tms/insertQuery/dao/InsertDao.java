package cn.qkmango.tms.insertQuery.dao;

import cn.qkmango.tms.domain.orm.*;

import java.util.HashMap;
import java.util.List;

public interface InsertDao {

    int insertCourse(Course course);

    int lastInsertId();

    int insertCourseInfo(List<CourseInfo> courseInfoList);

    int insertBuilding(Building building);

    int insertRoom(Room room);

    int insertYear(Year id);

    int insertElective(HashMap<String, Object> param);
}
