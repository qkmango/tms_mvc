package cn.qkmango.tms.system.dao;

import cn.qkmango.tms.domain.User;

public interface SystemDao {
    User login(User user);
}
