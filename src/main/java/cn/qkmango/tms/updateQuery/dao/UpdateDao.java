package cn.qkmango.tms.updateQuery.dao;

import java.util.HashMap;

public interface UpdateDao {

    int updateStudentPassword(HashMap<String, Object> map);

    int updateTeacherPassword(HashMap<String, Object> map);

    int updateAdminPassword(HashMap<String, Object> map);
}
