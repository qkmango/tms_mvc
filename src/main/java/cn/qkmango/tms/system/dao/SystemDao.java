package cn.qkmango.tms.system.dao;

import cn.qkmango.tms.domain.orm.User;

public interface SystemDao {
    User login(User user);
}
