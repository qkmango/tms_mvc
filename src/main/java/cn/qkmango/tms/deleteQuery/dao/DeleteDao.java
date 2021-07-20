package cn.qkmango.tms.deleteQuery.dao;

import java.util.HashMap;

public interface DeleteDao {
    int deleteBuilding(Integer id);

    int deleteRoom(Integer id);

    int deleteYear(Integer year);

    int deleteElective(HashMap<String, Object> param);
}
