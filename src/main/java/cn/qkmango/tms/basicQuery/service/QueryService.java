package cn.qkmango.tms.basicQuery.service;

import cn.qkmango.tms.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface QueryService {

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedListByFaculty(Integer faculty);

    List<Clazz> getClazzListBySpecialized(Integer specialized);

    List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap);

    HashMap<String,Object> getStudentScorePagination(StudentScorePagination pagination);
}
