package cn.qkmango.tms.system.controller;


import cn.qkmango.tms.domain.orm.User;
import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.system.service.SystemService;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.Query.login;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(value = "/system")
public class SystemController {


    @Resource
    private SystemService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    /**
     * @param request
     * @param user 户信息，前端传来参数：id，password
     * @return
     * @throws LoginException
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public Map<String, Object> login(@Validated(login.class) User user, BindingResult result, HttpServletRequest request, Locale locale) throws LoginException, PermissionException {

        User loginUser = service.login(user,locale);

        request.getSession(true).setAttribute("user", loginUser);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("response.login.success",null,locale));

        return map;
    }


    @RequestMapping(value = "/logout.do",method = RequestMethod.POST)
    public Map<String, Object> logout(HttpServletRequest request, User user) {
        request.getSession().invalidate();

        HashMap<String, Object> map = new HashMap<>(2);
        map.put("success", true);
        map.put("message", "退出成功！");
        return map;
    }

    @RequestMapping("/getUserInfo.do")
    public Map<String, Object> getUserInfo(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");

        HashMap<String, Object> map = new HashMap<>(2);
        map.put("success", true);
        map.put("user", user);
        return map;
    }

    /**
     * 更改语言环境
     * @param locale 新的语言
     * @return
     */
    @RequestMapping(value = "/setLocale.do")
    public Map setLocale(String locale, Locale localeObj) {
        HashMap<Object, Object> map = new HashMap<>(3);
        map.put("locale",localeObj.getLanguage());
        map.put("success",true);
        map.put("message",messageSource.getMessage("response.setLocale.success",null,localeObj));
        return map;

    }

}
