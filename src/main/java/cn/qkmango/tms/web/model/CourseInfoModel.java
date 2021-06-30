package cn.qkmango.tms.web.model;

import cn.qkmango.tms.domain.CourseInfo;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CourseInfoModel {
    @Valid
    @NotNull(message = "课程信息不能为空")
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
