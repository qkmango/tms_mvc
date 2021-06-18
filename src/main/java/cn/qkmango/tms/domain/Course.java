package cn.qkmango.tms.domain;

/**
 * 课程实体类
 */
public class Course {

    private Integer id;
    private String name;
    private Integer credit;
    private Integer clazz;
    private Integer teacher;

    public Course() {
    }

    public Course(Integer id, String name, Integer credit, Integer clazz, Integer teacher) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.clazz = clazz;
        this.teacher = teacher;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", clazz=" + clazz +
                ", teacher=" + teacher +
                '}';
    }
}
