package cn.qkmango.tms.system.service;

import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.LoginException;

public interface SystemService {

    // User login(User user) throws LoginException;
    User studentLogin(User user) throws LoginException;
    User teacherLogin(User user) throws LoginException;
    // User adminLogin(User user) throws LoginException;
}
