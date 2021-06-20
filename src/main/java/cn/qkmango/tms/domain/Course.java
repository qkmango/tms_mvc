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
    private Integer year;
    //false 0：表示第一学期；true 1：表示第二学期
    private Boolean term;

    public Course() {
    }

    public Course(Integer id, String name, Integer credit, Integer clazz, Integer teacher, Integer year, Boolean term) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.clazz = clazz;
        this.teacher = teacher;
        this.year = year;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
                ", year=" + year +
                ", term=" + term +
                '}';
    }
}
