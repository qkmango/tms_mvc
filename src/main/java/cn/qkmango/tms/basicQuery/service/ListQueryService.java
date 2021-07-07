package cn.qkmango.tms.basicQuery.service;

import cn.qkmango.tms.domain.*;

import java.util.HashMap;
import java.util.List;

public interface ListQueryService {

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedList(Specialized specialized);

    List<Clazz> getClazzList(Clazz clazz);

    List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap);

    List<Teacher> getTeacherList(Teacher teacher);

    List<Building> getBuildingList(Building building);

    List<Year> getYearList(Year year);
}
