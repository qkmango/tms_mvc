package cn.qkmango.tms.basicQuery.service.impl;

import cn.qkmango.tms.basicQuery.dao.SystemQueryDao;
import cn.qkmango.tms.basicQuery.service.SystemQueryService;
import cn.qkmango.tms.domain.orm.SystemKeyValue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: SystemQueryServiceImpl
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-08-17 21:48
 * @version: 1.0
 */

@Service
public class SystemQueryServiceImpl implements SystemQueryService {

    @Resource
    private SystemQueryDao dao;

    @Override
    public List<SystemKeyValue> getSystemCurrYearAndTerm() {
        List<SystemKeyValue> list = dao.getSystemCurrYearAndTerm();

        // HashMap<String, String> resMap = new HashMap<>();

        // for (Map<String, String> map : list) {
        //     String key = map.get("key");
        //     String value = map.get("value");
        //     resMap.put(key,value);
        // }

        return list;
    }

    @Override
    public List<SystemKeyValue> getSystemKeyValueList() {
        List infoList  = dao.getSystemKeyValueList();
        return infoList;
    }
}
