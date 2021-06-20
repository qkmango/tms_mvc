package cn.qkmango.tms.basicQuery.service.impl;

import cn.qkmango.tms.basicQuery.dao.QueryDao;
import cn.qkmango.tms.basicQuery.service.QueryService;
import cn.qkmango.tms.domain.*;
import cn.qkmango.tms.domain.paginstion.RoomPagination;
import cn.qkmango.tms.domain.paginstion.StudentScorePagination;
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
    public List<Course> getCoursePagination(HashMap<String, Integer> paramsMap) {

        List<Course> courseList = queryDao.getCoursePagination(paramsMap);

        return courseList;
    }


    @Override
    @Transactional(
            propagation = Propagation.SUPPORTS,
            readOnly = true
    )
    public HashMap<String,Object> getStudentScorePagination(StudentScorePagination pagination) {

        List<HashMap<String, Object>> data = queryDao.getStudentScorePagination(pagination);

        HashMap<String, Object> map = new HashMap<>();

        if (pagination.getPagination() != false) {
            int count = queryDao.getCount();
            map.put("count",count);
        }

        map.put("data",data);
        map.put("pagination",pagination.getPagination());

        return map;
    }

    @Override
    public List<Teacher> getTeacherList(Teacher teacher) {

        List<Teacher> list = queryDao.getTeacherList(teacher);
        return list;
    }

    @Override
    public List<Building> getBuildingList(Building building) {

        List<Building> list = queryDao.getBuildingList(building);

        return list;
    }

    @Override
    public HashMap<String, Object> getRoomPagination(RoomPagination pagination) {

        List<HashMap<String, Object>> data = queryDao.getRoomPagination(pagination);

        HashMap<String, Object> map = new HashMap<>();

        if (pagination.getPagination() != false) {
            int count = queryDao.getCount();
            map.put("count",count);
        }

        map.put("data",data);
        map.put("pagination",pagination.getPagination());

        return map;
    }
}
