package cn.qkmango.tms.system.service;

import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.LoginException;
import cn.qkmango.tms.exception.PermissionException;

public interface SystemService {

    User login(User user) throws LoginException, PermissionException;
}
