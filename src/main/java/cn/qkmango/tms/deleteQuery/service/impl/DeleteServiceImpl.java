package cn.qkmango.tms.deleteQuery.service.impl;

import cn.qkmango.tms.deleteQuery.dao.DeleteDao;
import cn.qkmango.tms.deleteQuery.service.DeleteService;
import cn.qkmango.tms.exception.DeleteException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DeleteServiceImpl implements DeleteService {

    @Resource
    private DeleteDao deleteDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBuilding(Integer id) throws DeleteException {
        int affectedRows = deleteDao.deleteBuilding(id);
        if (affectedRows != 1) {
            throw new DeleteException(1,affectedRows);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRoom(Integer id) throws DeleteException {
        int affectedRows = deleteDao.deleteRoom(id);
        if (affectedRows != 1) {
            throw new DeleteException(1,affectedRows);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteYear(Integer year) throws DeleteException {
        int affectedRows = deleteDao.deleteYear(year);
        if (affectedRows != 1) {
            throw new DeleteException(1,affectedRows);
        }
    }
}
