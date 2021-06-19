package cn.qkmango.tms.insertQuery.dao;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.domain.CourseInfo;
import cn.qkmango.tms.domain.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsertDao {

    int insertCourse(Course course);

    int lastInsertId();

    int insertCourseInfo(List<CourseInfo> courseInfoList);

    int insertBuilding(Building building);

    int insertRoom(Room room);
}
