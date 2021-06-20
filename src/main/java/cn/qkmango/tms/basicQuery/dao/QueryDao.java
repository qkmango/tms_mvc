package cn.qkmango.tms.basicQuery.dao;

import cn.qkmango.tms.domain.*;
import cn.qkmango.tms.domain.paginstion.RoomPagination;
import cn.qkmango.tms.domain.paginstion.StudentScorePagination;

import java.util.HashMap;
import java.util.List;

public interface QueryDao {
    int getCount();

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedListByFaculty(Integer faculty);

    List<Clazz> getClazzListBySpecialized(Integer specialized);

    List<Course> getCoursePagination(HashMap<String, Integer> paramsMap);

    List<HashMap<String, Object>> getStudentScorePagination(StudentScorePagination pagination);

    List<Teacher> getTeacherList(Teacher teacher);

    List<Building> getBuildingList(Building building);

    List<HashMap<String, Object>> getRoomPagination(RoomPagination pagination);
}
