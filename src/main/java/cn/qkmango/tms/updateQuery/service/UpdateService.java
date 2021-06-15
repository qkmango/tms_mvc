package cn.qkmango.tms.updateQuery.service;

import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.exception.UpdateException;

import java.util.HashMap;

public interface UpdateService {

    void updatePassword(HashMap<String, Object> map) throws PermissionException, UpdateException;

    void updateStudentScore(HashMap<String, Object> map) throws UpdateException;
}
