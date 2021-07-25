package cn.qkmango.tms.basicQuery.service.impl;

import cn.qkmango.tms.basicQuery.dao.ListQueryDao;
import cn.qkmango.tms.basicQuery.service.ListQueryService;
import cn.qkmango.tms.domain.model.OnceCourseInfo;
import cn.qkmango.tms.domain.model.TimeTable;
import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.domain.vo.GetStudentTimetableVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qkmango
 */
@Service
public class ListQueryServiceImpl implements ListQueryService {


    @Resource
    private ListQueryDao listQueryDao;

    @Override
    public List<Faculty> getFacultyList() {
        List<Faculty> facultyList = listQueryDao.getFacultyList();
        return facultyList;
    }

    @Override
    public List<Specialized> getSpecializedList(Specialized specialized) {

        List<Specialized> specializedList = listQueryDao.getSpecializedList(specialized);

        return specializedList;
    }

    @Override
    public List<Clazz> getClazzList(Clazz clazz) {
        List<Clazz> clazzList = listQueryDao.getClazzList(clazz);

        return clazzList;
    }

    @Override
    public List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap) {

        List<Course> courseList = listQueryDao.getCourseListByTeacherAndClazz(paramsMap);

        return courseList;
    }

    @Override
    public List<Teacher> getTeacherList(Teacher teacher) {

        List<Teacher> list = listQueryDao.getTeacherList(teacher);
        return list;
    }

    @Override
    public List<Building> getBuildingList(Building building) {

        List<Building> list = listQueryDao.getBuildingList(building);

        return list;
    }

    @Override
    public List<Year> getYearList(Year year) {
        List<Year> list = listQueryDao.getYearList(year);
        return list;
    }

    @Override
    public List<Map> getStudentElectiveCourseList(HashMap<String, Object> params) {

        List<Map> list = listQueryDao.getStudentElectiveCourseList(params);
        return list;
    }

    @Override
    public TimeTable getStudentTimetable(GetStudentTimetableVO vo) {

        List<OnceCourseInfo> list = listQueryDao.getStudentTimetable(vo);
        TimeTable timeTable = listQueryDao.getInfoOfTimeTable(vo.getId());

        timeTable.setList(list);
        timeTable.setStudentId(vo.getId());
        timeTable.setYear(vo.getYear());
        timeTable.setTerm(vo.getTerm());
        return timeTable;
    }




}
