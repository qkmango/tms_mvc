package cn.qkmango.tms.system.dao;

import cn.qkmango.tms.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    List<Student> queryStudents();
}
