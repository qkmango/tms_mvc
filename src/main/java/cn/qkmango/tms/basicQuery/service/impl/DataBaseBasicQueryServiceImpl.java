package cn.qkmango.tms.basicQuery.service.impl;

import cn.qkmango.tms.basicQuery.dao.DataBaseBasicQueryDao;
import cn.qkmango.tms.basicQuery.service.DataBaseBasicQueryService;
import cn.qkmango.tms.domain.Clazz;
import cn.qkmango.tms.domain.Course;
import cn.qkmango.tms.domain.Faculty;
import cn.qkmango.tms.domain.Specialized;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class DataBaseBasicQueryServiceImpl implements DataBaseBasicQueryService {


    @Resource
    private DataBaseBasicQueryDao dataBaseBasicQueryDao;

    @Override
    public List<Faculty> getFacultyList() {
        List<Faculty> facultyList = dataBaseBasicQueryDao.getFacultyList();
        return facultyList;
    }

    @Override
    public List<Specialized> getSpecializedListByFaculty(Integer faculty) {

        List<Specialized> specializedList = dataBaseBasicQueryDao.getSpecializedListByFaculty(faculty);

        return specializedList;
    }

    @Override
    public List<Clazz> getClazzListBySpecialized(Integer specialized) {
        List<Clazz> clazzList = dataBaseBasicQueryDao.getClazzListBySpecialized(specialized);

        return clazzList;
    }

    @Override
    public List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap) {

        List<Course> courseList = dataBaseBasicQueryDao.getCourseListByTeacherAndClazz(paramsMap);

        return courseList;
    }
}
