package cn.qkmango.tms.system.service;

import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.LoginException;
import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.web.bind.PermissionType;

public interface SystemService {

    User login(User user) throws LoginException, PermissionException;
}
