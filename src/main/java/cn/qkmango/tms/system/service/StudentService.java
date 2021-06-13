package cn.qkmango.tms.system.service;

import cn.qkmango.tms.domain.Student;

import java.util.List;

public interface StudentService {

    int insertStudent(Student student);
    List<Student> queryStudents();
}
