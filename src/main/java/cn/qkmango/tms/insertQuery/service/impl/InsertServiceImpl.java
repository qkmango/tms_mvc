package cn.qkmango.tms.insertQuery.service.impl;

import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.domain.CourseInfo;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.exception.InsertException;
import cn.qkmango.tms.insertQuery.dao.InsertDao;
import cn.qkmango.tms.insertQuery.service.InsertService;
import cn.qkmango.tms.web.model.CourseInfoModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class InsertServiceImpl implements InsertService {

    @Resource
    private InsertDao insertDao;

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    public void insertCourse(Course course, CourseInfoModel courseInfoModel) throws InsertException {

        int affectedRows = insertDao.insertCourse(course);
        if (affectedRows != 1) {
            throw new InsertException("插入记录异常，应影响行数：1，实际影响行数：" + affectedRows);
        }

        int courseId = insertDao.lastInsertId();

        List<CourseInfo> courseInfoList = courseInfoModel.getCourseInfos();
        for (CourseInfo courseInfo : courseInfoList) {
            courseInfo.setCourse(courseId);
        }

        insertCourseInfo(courseInfoList);
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    public void insertBuilding(Building building) throws InsertException {
        int affectedRows = insertDao.insertBuilding(building);
        if (affectedRows != 1) {
            throw new InsertException("插入记录异常，应影响行数：1，实际影响行数：" + affectedRows);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertRoom(Room room) throws InsertException {
        int affectedRows = insertDao.insertRoom(room);
        if (affectedRows != 1) {
            throw new InsertException("插入记录异常，应影响行数：1，实际影响行数：" + affectedRows);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertYear(Integer id) throws InsertException {
        int affectedRows = insertDao.insertYear(id);
        if (affectedRows != 1) {
            throw new InsertException("插入记录异常，应影响行数：1，实际影响行数：" + affectedRows);
        }
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
    protected void insertCourseInfo(List<CourseInfo> courseInfoList) throws InsertException {
        int affectedRows = insertDao.insertCourseInfo(courseInfoList);
        if (affectedRows != courseInfoList.size()) {
            throw new InsertException("插入记录异常，应影响行数："+courseInfoList.size()+"，实际影响行数：" + affectedRows);
        }
    }

}
