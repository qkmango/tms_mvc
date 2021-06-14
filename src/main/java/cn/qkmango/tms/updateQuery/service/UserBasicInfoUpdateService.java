package cn.qkmango.tms.updateQuery.service;

import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.exception.UpdateUserInfoException;

import java.sql.SQLException;
import java.util.HashMap;

public interface UserBasicInfoUpdateService {

    void updatePassword(HashMap<String, Object> map) throws PermissionException, UpdateUserInfoException;

}
