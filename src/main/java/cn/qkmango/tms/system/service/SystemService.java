package cn.qkmango.tms.system.service;

import cn.qkmango.tms.domain.orm.User;
import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;

import java.util.Locale;

public interface SystemService {

    User login(User user, Locale locale) throws LoginException, PermissionException;
}
