package cn.qkmango.tms.updateQuery.dao;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Elective;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.domain.vo.UpdatePasswordVO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface UpdateDao {

    int updateStudentScore(Elective elective);

    int updateBuilding(Building building);

    int updateRoom(Room room);

    int updateYear(@Param("year") Integer year, @Param("newYear") Integer newYear);

    int updatePassword(UpdatePasswordVO updatePasswordVO);
}
