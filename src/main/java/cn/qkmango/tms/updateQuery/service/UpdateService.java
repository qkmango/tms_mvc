package cn.qkmango.tms.updateQuery.service;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Elective;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.exception.UpdateException;

import java.util.HashMap;

public interface UpdateService {

    void updatePassword(HashMap<String, Object> map) throws PermissionException, UpdateException;

    void updateStudentScore(Elective elective) throws UpdateException;

    void updateBuilding(Building building) throws UpdateException;

    void updateRoom(Room room) throws UpdateException;

    void updateYear(Integer year,Integer newYear) throws UpdateException;
}
