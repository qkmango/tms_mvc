package cn.qkmango.tms.insertQuery.service.impl;

import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.exception.InsertException;
import cn.qkmango.tms.insertQuery.dao.InsertDao;
import cn.qkmango.tms.insertQuery.service.InsertService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class InsertServiceImpl implements InsertService {

    @Resource
    private InsertDao insertDao;

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = {
                    Exception.class,
            }
    )
    public void insertCourse(Course course) throws InsertException {
        int affectedRows = insertDao.insertCourse(course);
        if (affectedRows != 1) {
            throw new InsertException("插入Course异常，因为影响行数不为1，实际影响行数为：" + affectedRows);
        }


    }
}
