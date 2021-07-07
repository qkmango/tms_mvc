package cn.qkmango.tms.deleteQuery.service.impl;

import cn.qkmango.tms.deleteQuery.dao.DeleteDao;
import cn.qkmango.tms.deleteQuery.service.DeleteService;
import cn.qkmango.tms.exception.DeleteException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;

@Service
public class DeleteServiceImpl implements DeleteService {

    @Resource
    private DeleteDao deleteDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBuilding(Integer id, Locale locale) throws DeleteException {
        int affectedRows = deleteDao.deleteBuilding(id);
        if (affectedRows != 1) {
            throw new DeleteException(messageSource.getMessage("db.deleteBuilding.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRoom(Integer id, Locale locale) throws DeleteException {
        int affectedRows = deleteDao.deleteRoom(id);
        if (affectedRows != 1) {
            throw new DeleteException(messageSource.getMessage("db.deleteRoom.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteYear(Integer year,Locale locale) throws DeleteException {
        int affectedRows = deleteDao.deleteYear(year);
        if (affectedRows != 1) {
            throw new DeleteException(messageSource.getMessage("db.deleteYear.failure",null,locale));
        }
    }
}
