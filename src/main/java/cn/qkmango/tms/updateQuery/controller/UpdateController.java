package cn.qkmango.tms.updateQuery.controller;


import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.exception.PermissionException;
import cn.qkmango.tms.exception.UpdateException;
import cn.qkmango.tms.updateQuery.service.UpdateService;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/update",method = RequestMethod.POST)

/**
 * 用户基本信息修改的控制器
 */
public class UpdateController {

    @Resource
    private UpdateService updateService;

    @Permission
    @ResponseBody
    @RequestMapping("/updatePassword.do")
    public Map<String, Object> updatePassword(HttpServletRequest request,
                                              String oldPassword,
                                              String newPassword) throws PermissionException, UpdateException {

        User user = (User) request.getSession().getAttribute("user");
        Integer id = user.getId();
        //获取用户权限类型
        PermissionType thisUserPermissionType = user.getPermissionType();

        HashMap<String, Object> requestMap = new HashMap<>();


        requestMap.put("id",id);
        requestMap.put("oldPassword",oldPassword);
        requestMap.put("newPassword",newPassword);
        requestMap.put("thisUserPermissionType",thisUserPermissionType);

        updateService.updatePassword(requestMap);

        ResponseMap map = new ResponseMap();

        map.setSuccess(true);
        map.setMessage("密码更改成功");

        return map;


    }

}
