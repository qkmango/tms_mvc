package cn.qkmango.tms.updateQuery.dao;

import cn.qkmango.tms.domain.Building;

import java.util.HashMap;

public interface UpdateDao {

    int updateStudentPassword(HashMap<String, Object> map);

    int updateTeacherPassword(HashMap<String, Object> map);

    int updateAdminPassword(HashMap<String, Object> map);

    int updateStudentScore(HashMap<String, Object> map);

    int updateBuilding(Building building);
}
