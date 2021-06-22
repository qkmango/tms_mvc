package cn.qkmango.tms.updateQuery.controller;


import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Room;
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

    @ResponseBody
    @Permission
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

    @ResponseBody
    @Permission(PermissionType.teacher)
    @RequestMapping("updateStudentScore.do")
    public Map<String, Object> updateStudentScore(Integer elective, Integer score) throws UpdateException {

        HashMap<String, Object> requestMap = new HashMap<>();
        requestMap.put("elective",elective);
        requestMap.put("score",score);

        updateService.updateStudentScore(requestMap);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("修改学生成绩成功");

        return map;
    }

    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("updateBuilding.do")
    public Map<String, Object> updateBuilding(Building building) throws UpdateException {

        updateService.updateBuilding(building);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("修改教学楼信息成功");

        return map;
    }

    /**
     * 更新修改 教室信息
     * @param room
     * @return
     * @throws UpdateException
     */
    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("updateRoom.do")
    public Map<String, Object> updateRoom(Room room) throws UpdateException {

        updateService.updateRoom(room);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("修改教室信息成功");

        return map;
    }


    /**
     * 更新修改 年份
     * @param year
     * @return
     * @throws UpdateException
     */
    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("updateYear.do")
    public Map<String, Object> updateYear(Integer year,Integer newYear) throws UpdateException {

        updateService.updateYear(year,newYear);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("修改年份信息成功");

        return map;
    }


}
