package cn.qkmango.tms.basicQuery.dao;

import cn.qkmango.tms.domain.orm.SystemKeyValue;

import java.util.List;

/**
 * @className: SystemQueryDao
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-08-17 21:41
 * @version: 1.0
 */
public interface SystemQueryDao {
    List<SystemKeyValue> getSystemCurrYearAndTerm();

    List<SystemKeyValue> getSystemKeyValueList();
}
