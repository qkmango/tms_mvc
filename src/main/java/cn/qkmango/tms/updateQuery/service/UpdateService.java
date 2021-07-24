package cn.qkmango.tms.updateQuery.service;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Elective;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.vo.UpdatePasswordVO;

import java.util.HashMap;
import java.util.Locale;

public interface UpdateService {

    void updatePassword(UpdatePasswordVO updatePasswordVO, Locale locale) throws PermissionException, UpdateException;

    void updateStudentScore(Elective elective, Locale locale) throws UpdateException;

    void updateBuilding(Building building, Locale locale) throws UpdateException;

    void updateRoom(Room room, Locale locale) throws UpdateException;

    void updateYear(Integer year,Integer newYear, Locale locale) throws UpdateException;
}
