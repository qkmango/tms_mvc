package cn.qkmango.tms.basicQuery.dao;

import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

/**
 * @className: SystemQueryDao
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-08-17 21:41
 * @version: 1.0
 */
public interface SystemQueryDao {
    @MapKey("key")
    Map getSystemBasicInfo();
}
