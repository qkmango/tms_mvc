package cn.qkmango.tms.system.service.impl;

import cn.qkmango.tms.system.dao.SystemDao;
import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.LoginException;
import cn.qkmango.tms.system.service.SystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SystemServiceImpl implements SystemService {


    @Resource
    private SystemDao systemDao;

    @Override
    public User studentLogin(User user) throws LoginException {
        User loginUser = systemDao.studentLogin(user);
        if (loginUser == null) {
            throw new LoginException("登陆失败，用户名或密码错误！");
        }
        return loginUser;
    }

    @Override
    public User teacherLogin(User user) throws LoginException {
        User loginUser = systemDao.teacherLogin(user);
        if (loginUser == null) {
            throw new LoginException("登陆失败，用户名或密码错误！");
        }
        return loginUser;
    }

}
