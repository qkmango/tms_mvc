package cn.qkmango.tms.deleteQuery.controller;


import cn.qkmango.tms.deleteQuery.service.DeleteService;
import cn.qkmango.tms.exception.DeleteException;
import cn.qkmango.tms.web.anno.Permission;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/delete")
public class DeleteController {

    @Resource
    private DeleteService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Permission(PermissionType.admin)
    @RequestMapping("/deleteBuilding.do")
    public Map<String, Object> deleteBuilding(Integer id, Locale locale) throws DeleteException {

        service.deleteBuilding(id,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.deleteBuilding.success",null,locale));

        return map;
    }

    @Permission(PermissionType.admin)
    @RequestMapping("/deleteRoom.do")
    public Map<String, Object> deleteRoom(Integer id, Locale locale) throws DeleteException {

        service.deleteRoom(id,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.deleteRoom.success",null,locale));

        return map;
    }

    @Permission(PermissionType.admin)
    @RequestMapping("/deleteYear.do")
    public Map<String, Object> deleteYear(Integer year,Locale locale) throws DeleteException {

        service.deleteYear(year,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.deleteYear.success",null,locale));

        return map;
    }


}
