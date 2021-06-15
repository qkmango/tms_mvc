package cn.qkmango.tms.domain;

public class StudentScorePagination extends Pagination {

    //学生ID
    private Integer id;
    //学生姓名
    private String name;
    //授课老师ID
    private Integer teacher;
    //院系ID
    private Integer faculty;
    //专业ID
    private Integer specialized;
    //班级ID
    private Integer clazz;
    //学科（专业课）ID
    private Integer course;

    public StudentScorePagination() {
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

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }

    public Integer getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Integer specialized) {
        this.specialized = specialized;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentScorePagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", skipCount=" + skipCount +
                ", id=" + id +
                ", name=" + name +
                ", teacher=" + teacher +
                ", faculty=" + faculty +
                ", specialized=" + specialized +
                ", clazz=" + clazz +
                ", course=" + course +
                '}';
    }
}
