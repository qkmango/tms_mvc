package cn.qkmango.tms.system.controller;


import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.LoginException;
import cn.qkmango.tms.map.ResponseMap;
import cn.qkmango.tms.system.service.SystemService;
import cn.qkmango.tms.web.bind.UserPower;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/system", method = RequestMethod.POST)
public class SystemController {


    @Resource
    private SystemService service;


    /**
     * @param request
     * @param user      用户信息，前端传来参数：id，password
     * @param userPower 用户类型
     * @return
     * @throws LoginException
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, User user, Integer userPower) throws LoginException {


        User loginUser = null;
        ResponseMap map = new ResponseMap();
        if (UserPower.student.ordinal() == userPower) {
            loginUser = service.studentLogin(user);
            loginUser.setUserPower(UserPower.student.ordinal());
        } else if (UserPower.teacher.ordinal() == userPower) {
            loginUser = service.teacherLogin(user);
            loginUser.setUserPower(UserPower.teacher.ordinal());
        } else if (UserPower.admin.ordinal() == userPower) {
            // loginUser = service.adminLogin(user);
            // loginUser.setUserPower(UserPower.admin.ordinal());
        } else {
            map.setSuccess(false);
            map.setMessage("用户类型错误！");
            return map;
        }

        // loginUser = service.login(user);
        request.getSession(true).setAttribute("user", loginUser);


        map.setSuccess(true);
        map.setMessage("登陆成功！");

        return map;
    }


    @RequestMapping("/logout.do")
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
