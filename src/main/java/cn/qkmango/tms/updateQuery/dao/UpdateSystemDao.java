package cn.qkmango.tms.updateQuery.dao;

import cn.qkmango.tms.domain.orm.SystemKeyValue;

/**
 * @author qkmango
 * @version 1.0
 * @className UpdateSystemDao
 * @Description TODO
 * @date 2022-07-28 19:57
 */
public interface UpdateSystemDao {
    int updateSystemKeyValue(SystemKeyValue systemKeyValue);
}
