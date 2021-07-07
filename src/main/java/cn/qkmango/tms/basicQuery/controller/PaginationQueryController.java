package cn.qkmango.tms.basicQuery.controller;

import cn.qkmango.tms.basicQuery.service.PaginationQueryService;
import cn.qkmango.tms.domain.pagination.RoomPagination;
import cn.qkmango.tms.domain.pagination.StudentScorePagination;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.domain.bind.PermissionType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/query/pagination")
public class PaginationQueryController {

    @Resource
    private PaginationQueryService paginationQueryService;


    /**
     * 获取学生成绩列表分页
     * @return
     */
    @Permission({PermissionType.admin,PermissionType.teacher})
    @RequestMapping("/getStudentScorePagination.do")
    public Map<String, Object> getStudentScorePagination(StudentScorePagination pagination) {

        HashMap<String,Object> map = paginationQueryService.getStudentScorePagination(pagination);

        map.put("success",true);
        map.put("message","获取学生成绩分页列表成功");

        return map;
    }

    /**
     * 条件获取教室列表 分页
     * @param pagination
     * @return
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/getRoomPagination.do")
    public Map<String, Object> getRoomPagination(RoomPagination pagination) {

        HashMap<String,Object> map = paginationQueryService.getRoomPagination(pagination);

        // ResponseMap map = new ResponseMap();
        map.put("success",true);
        map.put("message","获取教室列表成功");

        return map;
    }



}
