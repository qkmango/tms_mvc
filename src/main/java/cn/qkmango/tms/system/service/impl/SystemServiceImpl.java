package cn.qkmango.tms.system.service.impl;

import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.system.dao.SystemDao;
import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.LoginException;
import cn.qkmango.tms.system.service.SystemService;
import cn.qkmango.tms.web.bind.PermissionType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SystemServiceImpl implements SystemService {


    @Resource
    private SystemDao systemDao;

    @Override
    public User login(User user) throws LoginException, PermissionException {

        User loginUser = systemDao.login(user);

        if (loginUser == null) {
            throw new LoginException("登陆失败，用户名或密码错误！");
        }

        loginUser.setPermissionType(user.getPermissionType());
        return loginUser;
    }

}
