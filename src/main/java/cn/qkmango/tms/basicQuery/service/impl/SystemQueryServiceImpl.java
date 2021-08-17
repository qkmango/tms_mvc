package cn.qkmango.tms.basicQuery.service.impl;

import cn.qkmango.tms.basicQuery.dao.SystemQueryDao;
import cn.qkmango.tms.basicQuery.service.SystemQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

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
    public Map getSystemBasicInfo() {
        Map map = dao.getSystemBasicInfo();
        return map;
    }
}
