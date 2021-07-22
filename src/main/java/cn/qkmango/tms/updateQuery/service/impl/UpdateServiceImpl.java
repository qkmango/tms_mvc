package cn.qkmango.tms.updateQuery.service.impl;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Elective;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.updateQuery.dao.UpdateDao;
import cn.qkmango.tms.updateQuery.service.UpdateService;
import cn.qkmango.tms.domain.bind.PermissionType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Locale;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Resource
    private UpdateDao updateDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


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
            throw new UpdateException(1,affectedRows);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStudentScore(Elective elective) throws UpdateException {
        int affectedRows = updateDao.updateStudentScore(elective);
        if (affectedRows != 1) {
            throw new UpdateException(1,affectedRows);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBuilding(Building building) throws UpdateException {
        int affectedRows = updateDao.updateBuilding(building);
        if (affectedRows != 1) {
            throw new UpdateException(1,affectedRows);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRoom(Room room, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateRoom(room);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateRoom.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateYear(Integer year,Integer newYear) throws UpdateException {
        int affectedRows = updateDao.updateYear(year,newYear);
        if (affectedRows != 1) {
            throw new UpdateException(1,affectedRows);
        }
    }
}
