package cn.qkmango.tms.web.model;

import cn.qkmango.tms.domain.CourseInfo;

import java.util.List;

public class CourseInfoModel {
    private List<CourseInfo> courseInfos;

    public List<CourseInfo> getCourseInfos() {
        return courseInfos;
    }

    public void setCourseInfos(List<CourseInfo> courseInfos) {
        this.courseInfos = courseInfos;
    }

    public CourseInfoModel(List<CourseInfo> courseInfos) {
        super();
        this.courseInfos = courseInfos;
    }

    public CourseInfoModel() {
        super();
    }

    public int size() {
        return courseInfos.size();
    }
}
