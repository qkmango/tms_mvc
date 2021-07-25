package cn.qkmango.tms.insertQuery.service.impl;

import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.insertQuery.dao.InsertDao;
import cn.qkmango.tms.insertQuery.service.InsertService;
import cn.qkmango.tms.domain.model.CourseInfoModel;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


@Service
public class InsertServiceImpl implements InsertService {

    @Resource
    private InsertDao insertDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    public void insertCourse(Course course, CourseInfoModel courseInfoModel, Locale locale) throws InsertException {

        int affectedRows = insertDao.insertCourse(course);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertCourse.failure",null,locale));
        }

        int courseId = insertDao.lastInsertId();

        List<CourseInfo> courseInfoList = courseInfoModel.getCourseInfos();
        for (CourseInfo courseInfo : courseInfoList) {
            courseInfo.setCourse(courseId);
        }

        insertCourseInfo(courseInfoList,locale);
    }

    /**
     * 插入 课程信息，仅供 insertCourse(..)方法使用
     * @param courseInfoList
     * @throws InsertException
     */
    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class
    )
    protected void insertCourseInfo(List<CourseInfo> courseInfoList,Locale locale) throws InsertException {
        int affectedRows = insertDao.insertCourseInfo(courseInfoList);
        if (affectedRows != courseInfoList.size()) {
            throw new InsertException(messageSource.getMessage("db.insertCourse.failure",null,locale));
        }
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    public void insertBuilding(Building building, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertBuilding(building);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertBuilding.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertRoom(Room room, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertRoom(room);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertRoom.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertYear(Year year, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertYear(year);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertYear.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertElective(HashMap<String, Object> param, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertElective(param);
        // Integer[] ids = (Integer[]) param.get("ids");
        // if (affectedRows != ids.length) {
        //     throw new InsertException(messageSource.getMessage("db.insertElective.failure",null,locale));
        // }
    }
}
