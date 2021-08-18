package cn.qkmango.tms.basicQuery.controller;

import cn.qkmango.tms.basicQuery.service.SystemQueryService;
import cn.qkmango.tms.common.map.ResponseMap;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @className: SystemQueryController
 * @Description: 查询一些系统信息，如当前学期，当前学年
 * @author: qkmango
 * @date: 2021-08-17 21:31
 * @version: 1.0
 */

@RestController
@RequestMapping("/query/system")
public class SystemQueryController {

    @Resource
    private SystemQueryService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    /**
     * 获取系统基本信息
     * @return
     */
    @RequestMapping("/getSystemBasicInfo.do")
    public Map getSystemBasicInfo() {

        Map<String, String> resMap = service.getSystemBasicInfo();

        ResponseMap res = new ResponseMap();
        res.setSuccess(true);
        res.setData(resMap);

        return res;
    }
}
