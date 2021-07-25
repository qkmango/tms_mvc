package cn.qkmango.tms.system.service.impl;

import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.system.dao.SystemDao;
import cn.qkmango.tms.domain.orm.User;
import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.system.service.SystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Locale;


@Service
public class SystemServiceImpl implements SystemService {


    @Resource
    private SystemDao systemDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    public User login(User user, Locale locale) throws LoginException, PermissionException {

        User loginUser = systemDao.login(user);

        if (loginUser == null) {
            throw new LoginException(messageSource.getMessage("response.login.failure",null,locale));
        }

        loginUser.setPermissionType(user.getPermissionType());
        return loginUser;
    }

}
