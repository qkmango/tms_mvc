package cn.qkmango.tms.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 课程实体类
 */
public class Course {

    private Integer id;
    @NotEmpty(message = "课程名不能为空")
    private String name;
    @NotNull(message = "学分不能为空")
    @Range(min = 1,max = 4,message = "学分取值在1-4")
    private Integer credit;
    @NotNull(message = "所属班级不能为空")
    private Integer clazz;
    @NotNull(message = "授课老师不能为空")
    private Integer teacher;
    @NotNull(message = "所属学年不能为空")
    private Integer courseYear;
    //false 0：表示第一学期；true 1：表示第二学期
    @NotNull(message = "所属学期不能为空")
    private Boolean term;

    public Course() {
    }

    public Course(Integer id, String name, Integer credit, Integer clazz, Integer teacher, Integer courseYear, Boolean term) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.clazz = clazz;
        this.teacher = teacher;
        this.courseYear = courseYear;
        this.term = term;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public Integer getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(Integer courseYear) {
        this.courseYear = courseYear;
    }

    public Boolean getTerm() {
        return term;
    }

    public void setTerm(Boolean term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", clazz=" + clazz +
                ", teacher=" + teacher +
                ", year=" + courseYear +
                ", term=" + term +
                '}';
    }
}
