package cn.qkmango.tms.insertQuery.dao;

import cn.qkmango.tms.domain.orm.SystemKeyValue;

/**
 * @author qkmango
 * @version 1.0
 * @className InsertSystemDao
 * @Description TODO
 * @date 2022-07-28 19:24
 */
public interface InsertSystemDao {
    int insertSystemKeyValue(SystemKeyValue systemKeyValue);
}
