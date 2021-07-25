package cn.qkmango.tms.domain.model;

import cn.qkmango.tms.domain.orm.CourseInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CourseInfoModel {
    @Valid
    @NotNull(message = "{valid.CourseInfoModel.courseInfos.NotNull}")
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
