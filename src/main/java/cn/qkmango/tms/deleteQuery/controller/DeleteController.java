package cn.qkmango.tms.deleteQuery.controller;


import cn.qkmango.tms.deleteQuery.service.DeleteService;
import cn.qkmango.tms.exception.DeleteException;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.web.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/delete")
public class DeleteController {

    @Resource
    private DeleteService service;


    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("/deleteBuilding.do")
    public Map<String, Object> deleteBuilding(Integer id) throws DeleteException {

        service.deleteBuilding(id);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("删除楼成功");

        return map;
    }

    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("/deleteRoom.do")
    public Map<String, Object> deleteRoom(Integer id) throws DeleteException {

        service.deleteRoom(id);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("删除教室成功");

        return map;
    }

    @ResponseBody
    @Permission(PermissionType.admin)
    @RequestMapping("/deleteYear.do")
    public Map<String, Object> deleteYear(Integer year) throws DeleteException {

        service.deleteYear(year);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("删除年份成功");

        return map;
    }


}
