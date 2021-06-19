package cn.qkmango.tms.updateQuery.service.impl;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.exception.UpdateException;
import cn.qkmango.tms.updateQuery.dao.UpdateDao;
import cn.qkmango.tms.updateQuery.service.UpdateService;
import cn.qkmango.tms.web.bind.PermissionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Resource
    private UpdateDao updateDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(HashMap<String, Object> map) throws PermissionException, UpdateException {

        PermissionType thisUserPermissionType = (PermissionType) map.get("thisUserPermissionType");

        int affectedRows = 0;

        //判断用户权限类型，选择合适的Dao层的方法
        switch (thisUserPermissionType) {
            case student:
                affectedRows = updateDao.updateStudentPassword(map);
                break;
            case teacher:
                affectedRows = updateDao.updateTeacherPassword(map);
                break;
            case admin:
                affectedRows = updateDao.updateAdminPassword(map);
                break;
            default:
                throw new PermissionException("未知的用户权限");
        }

        //判断影行数
        if (affectedRows != 1) {
            throw new UpdateException("更改密码异常，因为影响行数不为1，实际影响行数为：" + affectedRows);
        }


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStudentScore(HashMap<String, Object> map) throws UpdateException {
        int affectedRows = updateDao.updateStudentScore(map);
        if (affectedRows != 1) {
            throw new UpdateException("更改学生成绩异常，因为影响行数不为1，实际影响行数为：" + affectedRows);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBuilding(Building building) throws UpdateException {
        int affectedRows = updateDao.updateBuilding(building);
        if (affectedRows != 1) {
            throw new UpdateException("更改楼栋信息异常，因为影响行数不为1，实际影响行数为：" + affectedRows);
        }
    }

}
