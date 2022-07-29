package cn.qkmango.tms.deleteQuery.dao;

import cn.qkmango.tms.domain.orm.SystemKeyValue;

/**
 * @author qkmango
 * @version 1.0
 * @className DeleteSystemDao
 * @Description TODO
 * @date 2022-07-28 17:55
 */
public interface DeleteSystemDao {
    int deleteSystemKeyValue(SystemKeyValue systemKeyValue);
}
