package cn.qkmango.tms.basicQuery.service;

import cn.qkmango.tms.domain.Clazz;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.domain.Faculty;
import cn.qkmango.tms.domain.Specialized;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface DataBaseBasicQueryService {

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedListByFaculty(Integer faculty);

    List<Clazz> getClazzListBySpecialized(Integer specialized);

    List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap);
}
