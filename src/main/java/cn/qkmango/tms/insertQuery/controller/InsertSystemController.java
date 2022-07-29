package cn.qkmango.tms.insertQuery.controller;

import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.Insert;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.orm.SystemKeyValue;
import cn.qkmango.tms.insertQuery.service.InsertSystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

/**
 * @author qkmango
 * @version 1.0
 * @className SystemInsterController
 * @Description TODO
 * @date 2022-07-28 19:18
 */

@RestController
@RequestMapping(value = "/insert/system",method = RequestMethod.POST)
public class InsertSystemController {

    @Resource
    private InsertSystemService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Permission(PermissionType.admin)
    @RequestMapping("/insertSystemKeyValue.do")
    public Map insertSystemKeyValue(@Validated(Insert.InsertSystemKeyValue.class) SystemKeyValue systemKeyValue, BindingResult result, HttpSession session, Locale locale) throws InsertException {

        service.insertSystemKeyValue(systemKeyValue,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);

        map.setMessage(messageSource.getMessage("db.insertSystemKeyValue.success",null,locale));
        return map;
    }


}
