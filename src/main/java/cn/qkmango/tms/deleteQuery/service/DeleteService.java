package cn.qkmango.tms.deleteQuery.service;

import cn.qkmango.tms.exception.DeleteException;

import java.util.HashMap;
import java.util.Locale;

public interface DeleteService {
    void deleteBuilding(Integer id, Locale locale) throws DeleteException;

    void deleteRoom(Integer id,Locale locale) throws DeleteException;

    void deleteYear(Integer year,Locale locale) throws DeleteException;

    void deleteElective(HashMap<String, Object> param, Locale locale) throws DeleteException;
}
