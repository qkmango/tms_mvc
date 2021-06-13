package cn.qkmango.tms.system.dao;

import cn.qkmango.tms.domain.User;

public interface SystemDao {
    User studentLogin(User user);
    User teacherLogin(User user);
    // User adminLogin(User user);
}
