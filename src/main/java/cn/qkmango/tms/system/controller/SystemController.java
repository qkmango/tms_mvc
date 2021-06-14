package cn.qkmango.tms.system.controller;


import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.LoginException;
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
     * @param permissionType 用户类型，枚举类型
     * @return
     * @throws LoginException
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, User user, PermissionType permissionType) throws LoginException {

        User loginUser = null;
        ResponseMap map = new ResponseMap();

        switch (permissionType) {
            case student:
                loginUser = service.studentLogin(user);
                loginUser.setPermissionType(PermissionType.student);
                break;
            case teacher:
                loginUser = service.teacherLogin(user);
                loginUser.setPermissionType(PermissionType.teacher);
                break;
            case admin:
                break;
            default:
                map.setSuccess(false);
                map.setMessage("用户类型错误！");
                return map;
        }

        // if (PermissionType.student == permissionType) {
        //     loginUser = service.studentLogin(user);
        //     loginUser.setPermissionType(PermissionType.student);
        //
        // } else if (PermissionType.teacher == permissionType) {
        //     loginUser = service.teacherLogin(user);
        //     loginUser.setPermissionType(PermissionType.teacher);
        // } else {
        //     map.setSuccess(false);
        //     map.setMessage("用户类型错误！");
        //     return map;
        // }

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
