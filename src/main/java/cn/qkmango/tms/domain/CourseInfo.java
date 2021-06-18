package cn.qkmango.tms.domain;

import cn.qkmango.tms.web.bind.course.CourseType;
import cn.qkmango.tms.web.bind.course.WeekDay;
import cn.qkmango.tms.web.bind.course.WeekType;

public class CourseInfo {

    private Integer id;
    private Integer course;
    private CourseType courseType;
    private WeekType weekType;
    private Integer startWeek;
    private Integer endWeek;
    private WeekDay weekDay;
    private Integer begin;
    private Integer length;
    private Integer address;

    public CourseInfo() {
    }

    public CourseInfo(Integer id, Integer course, CourseType courseType, WeekType weekType, Integer startWeek, Integer endWeek, WeekDay weekDay, Integer begin, Integer length, Integer address) {
        this.id = id;
        this.course = course;
        this.courseType = courseType;
        this.weekType = weekType;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.weekDay = weekDay;
        this.begin = begin;
        this.length = length;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public WeekType getWeekType() {
        return weekType;
    }

    public void setWeekType(WeekType weekType) {
        this.weekType = weekType;
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "id=" + id +
                ", course=" + course +
                ", courseType=" + courseType +
                ", weekType=" + weekType +
                ", startWeek=" + startWeek +
                ", endWeek=" + endWeek +
                ", weekDay=" + weekDay +
                ", begin=" + begin +
                ", length=" + length +
                ", address=" + address +
                '}';
    }
}
