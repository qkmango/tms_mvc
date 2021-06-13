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

    // @Override
    // public User login(User user) throws LoginException {
    //     User loginUser = systemDao.login(user);
    //     if (loginUser == null) {
    //         throw new LoginException();
    //     }
    //     return loginUser;
    // }

    @Override
    public User studentLogin(User user) throws LoginException {
        User loginUser = systemDao.studentLogin(user);
        if (loginUser == null) {
            throw new LoginException();
        }
        return loginUser;
    }

    @Override
    public User teacherLogin(User user) throws LoginException {
        User loginUser = systemDao.teacherLogin(user);
        if (loginUser == null) {
            throw new LoginException();
        }
        return loginUser;
    }

    // @Override
    // public User adminLogin(User user) throws LoginException {
    //     User loginUser = systemDao.adminLogin(user);
    //     if (loginUser == null) {
    //         throw new LoginException();
    //     }
    //     return loginUser;
    // }
}
