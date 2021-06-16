package cn.qkmango.tms.system.controller;


import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.LoginException;
import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.web.map.ResponseMap;
import cn.qkmango.tms.system.service.SystemService;
import cn.qkmango.tms.web.bind.PermissionType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {


    @Resource
    private SystemService service;


    /**
     * @param request
     * @param user 户信息，前端传来参数：id，password
     * @return
     * @throws LoginException
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, User user) throws LoginException, PermissionException {

        ResponseMap map = new ResponseMap();

        User loginUser = service.login(user);

        request.getSession(true).setAttribute("user", loginUser);
        map.setSuccess(true);
        map.setMessage("登陆成功！");

        return map;
    }


    @RequestMapping(value = "/logout.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest request, User user) {
        request.getSession().invalidate();

        HashMap<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("message", "退出成功！");
        return map;
    }

    @RequestMapping("/getUserInfo.do")
    @ResponseBody
    public Map<String, Object> getUserInfo(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");

        HashMap<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("user", user);
        return map;
    }
}
