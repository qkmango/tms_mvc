package cn.qkmango.tms.basicQuery.service;

import cn.qkmango.tms.domain.pagination.RoomPagination;
import cn.qkmango.tms.domain.pagination.StudentScorePagination;

import java.util.HashMap;

public interface PaginationQueryService {

    HashMap<String,Object> getStudentScorePagination(StudentScorePagination pagination);

    HashMap<String, Object> getRoomPagination(RoomPagination pagination);

}
