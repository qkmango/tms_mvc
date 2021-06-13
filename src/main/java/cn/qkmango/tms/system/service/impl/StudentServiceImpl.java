package cn.qkmango.tms.system.service.impl;

import cn.qkmango.tms.system.dao.StudentDao;
import cn.qkmango.tms.domain.Student;
import cn.qkmango.tms.system.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //引用类型自动注入：@Autowired、@Resource
    @Resource
    private StudentDao studentDao;

    @Override
    public int insertStudent(Student student) {
        int affectRows = studentDao.insertStudent(student);
        return affectRows;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> studentList = studentDao.queryStudents();
        return studentList;
    }
}
