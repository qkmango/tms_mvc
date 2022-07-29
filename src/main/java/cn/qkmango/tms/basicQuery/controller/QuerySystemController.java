package cn.qkmango.tms.basicQuery.controller;

import cn.qkmango.tms.basicQuery.service.SystemQueryService;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.domain.orm.SystemKeyValue;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @className: QuerySystemController
 * @Description: 查询一些系统信息，如当前学期，当前学年
 * @author: qkmango
 * @date: 2021-08-17 21:31
 * @version: 1.0
 */

@RestController
@RequestMapping("/query/system")
public class QuerySystemController {

    @Resource
    private SystemQueryService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    /**
     * 获取系统基本信息
     * @return
     */
    @RequestMapping("/getSystemCurrYearAndTerm.do")
    public Map getSystemCurrYearAndTerm() {

        List<SystemKeyValue> systemKeyValueList = service.getSystemCurrYearAndTerm();

        ResponseMap res = new ResponseMap();
        res.setSuccess(true);
        res.setData(systemKeyValueList);

        return res;
    }

    @RequestMapping("/getSystemKeyValueList.do")
    public Map getSystemKeyValueList() {

        List<SystemKeyValue> resMap = service.getSystemKeyValueList();

        ResponseMap res = new ResponseMap();
        res.setSuccess(true);
        res.setData(resMap);

        return res;
    }
}
