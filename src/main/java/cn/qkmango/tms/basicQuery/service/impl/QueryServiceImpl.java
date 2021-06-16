package cn.qkmango.tms.basicQuery.service.impl;

import cn.qkmango.tms.basicQuery.dao.QueryDao;
import cn.qkmango.tms.basicQuery.service.QueryService;
import cn.qkmango.tms.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {


    @Resource
    private QueryDao queryDao;

    @Override
    public List<Faculty> getFacultyList() {
        List<Faculty> facultyList = queryDao.getFacultyList();
        return facultyList;
    }

    @Override
    public List<Specialized> getSpecializedListByFaculty(Integer faculty) {

        List<Specialized> specializedList = queryDao.getSpecializedListByFaculty(faculty);

        return specializedList;
    }

    @Override
    public List<Clazz> getClazzListBySpecialized(Integer specialized) {
        List<Clazz> clazzList = queryDao.getClazzListBySpecialized(specialized);

        return clazzList;
    }

    @Override
    public List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap) {

        List<Course> courseList = queryDao.getCourseListByTeacherAndClazz(paramsMap);

        return courseList;
    }


    @Override
    @Transactional(
            propagation = Propagation.SUPPORTS,
            readOnly = true
    )
    public HashMap<String,Object> getStudentScorePagination(StudentScorePagination pagination) {

        List<HashMap<String, Object>> data = queryDao.getStudentScorePagination(pagination);
        int count = queryDao.getCount();

        HashMap<String, Object> map = new HashMap<>();
        map.put("count",count);
        map.put("data",data);

        return map;
    }

    @Override
    public List<Teacher> getTeacherList(Teacher teacher) {

        System.out.println(teacher);
        List<Teacher> list = queryDao.getTeacherList(teacher);
        return list;
    }
}
