package cn.qkmango.tms.system.service;

import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;

public interface SystemService {

    User login(User user) throws LoginException, PermissionException;
}
