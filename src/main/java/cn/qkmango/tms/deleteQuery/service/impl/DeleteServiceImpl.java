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
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    public void deleteBuilding(Integer id) throws DeleteException {
        int affectedRows = deleteDao.deleteBuilding(id);
        if (affectedRows != 1) {
            throw new DeleteException("删除记录异常，应影响行数为 1，实际影响行数为 "+affectedRows);
        }
    }
}
