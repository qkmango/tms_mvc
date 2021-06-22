package cn.qkmango.tms.updateQuery.dao;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Room;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface UpdateDao {

    int updateStudentPassword(HashMap<String, Object> map);

    int updateTeacherPassword(HashMap<String, Object> map);

    int updateAdminPassword(HashMap<String, Object> map);

    int updateStudentScore(HashMap<String, Object> map);

    int updateBuilding(Building building);

    int updateRoom(Room room);

    int updateYear(@Param("year") Integer year, @Param("newYear") Integer newYear);
}
