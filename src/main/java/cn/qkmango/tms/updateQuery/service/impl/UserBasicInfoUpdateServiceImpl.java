package cn.qkmango.tms.updateQuery.service.impl;


import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.exception.UpdateUserInfoException;
import cn.qkmango.tms.updateQuery.dao.UserBasicInfoUpdateDao;
import cn.qkmango.tms.updateQuery.service.UserBasicInfoUpdateService;
import cn.qkmango.tms.web.bind.PermissionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class UserBasicInfoUpdateServiceImpl implements UserBasicInfoUpdateService {

    @Resource
    private UserBasicInfoUpdateDao userBasicInfoUpdateDao;


    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public void updatePassword(HashMap<String, Object> map) throws PermissionException, UpdateUserInfoException {

        // Integer id = (Integer) map.get("id");
        // String oldPassword = (String) map.get("oldPassword");
        // String newPassword = (String) map.get("newPassword");
        PermissionType thisUserPermissionType = (PermissionType) map.get("thisUserPermissionType");

        int affectedRows = 0;

        switch (thisUserPermissionType) {
            case student:
                affectedRows = userBasicInfoUpdateDao.updateStudentPassword(map);
                break;
            case teacher:
                affectedRows = userBasicInfoUpdateDao.updateTeacherPassword(map);
                break;
            case admin:
                affectedRows = userBasicInfoUpdateDao.updateAdminPassword(map);
                break;
            default:
                throw new PermissionException("未知的用户权限");
        }

        //判断影行数
        if (affectedRows != 1) {
            throw new UpdateUserInfoException("更改密码异常，因为影响行数不为1，实际影响行数为：" + affectedRows);
        }


    }

}
