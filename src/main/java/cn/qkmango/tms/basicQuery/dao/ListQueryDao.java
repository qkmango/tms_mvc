package cn.qkmango.tms.basicQuery.dao;

import cn.qkmango.tms.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ListQueryDao {
    int getCount();

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedList(Specialized specialized);

    List<Clazz> getClazzList(Clazz clazz);

    List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap);

    List<Teacher> getTeacherList(Teacher teacher);

    List<Building> getBuildingList(Building building);

    List<Year> getYearList(Year year);

    List<Map> getStudentElectiveCourseList(HashMap<String, Object> params);

    List<Map> getStudentTimetable(Integer studentId);
}
