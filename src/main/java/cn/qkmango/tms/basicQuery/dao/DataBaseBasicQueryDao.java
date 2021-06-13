package cn.qkmango.tms.basicQuery.dao;

import cn.qkmango.tms.domain.Clazz;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.domain.Faculty;
import cn.qkmango.tms.domain.Specialized;

import java.util.HashMap;
import java.util.List;

public interface DataBaseBasicQueryDao {
    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedListByFaculty(Integer faculty);

    List<Clazz> getClazzListBySpecialized(Integer specialized);

    List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap);
}
