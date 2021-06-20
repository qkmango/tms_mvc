package cn.qkmango.tms.basicQuery.service;

import cn.qkmango.tms.domain.*;
import cn.qkmango.tms.domain.paginstion.RoomPagination;
import cn.qkmango.tms.domain.paginstion.StudentScorePagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface QueryService {

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedListByFaculty(Integer faculty);

    List<Clazz> getClazzListBySpecializedAndClazzYear(Map<String, Object> requestMap);

    List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap);

    HashMap<String,Object> getStudentScorePagination(StudentScorePagination pagination);

    List<Teacher> getTeacherList(Teacher teacher);

    List<Building> getBuildingList(Building building);

    HashMap<String, Object> getRoomPagination(RoomPagination pagination);
}
