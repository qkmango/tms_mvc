package cn.qkmango.tms.deleteQuery.service;

import cn.qkmango.tms.exception.DeleteException;

public interface DeleteService {
    void deleteBuilding(Integer id) throws DeleteException;
}
