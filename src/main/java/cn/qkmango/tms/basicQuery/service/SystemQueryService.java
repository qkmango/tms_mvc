package cn.qkmango.tms.basicQuery.service;

import cn.qkmango.tms.domain.orm.SystemKeyValue;

import java.util.List;

/**
 * @className: SystemQueryService
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-08-17 21:47
 * @version: 1.0
 */
public interface SystemQueryService {
    List<SystemKeyValue> getSystemCurrYearAndTerm();

    List<SystemKeyValue> getSystemKeyValueList();
}
