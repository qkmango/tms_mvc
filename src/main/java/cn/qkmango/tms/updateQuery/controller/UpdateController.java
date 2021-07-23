package cn.qkmango.tms.updateQuery.controller;


import cn.qkmango.tms.domain.Building;
import cn.qkmango.tms.domain.Elective;
import cn.qkmango.tms.domain.Room;
import cn.qkmango.tms.domain.User;
import cn.qkmango.tms.common.exception.ParamVerifyError;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.vo.UpdatePasswordVO;
import cn.qkmango.tms.updateQuery.service.UpdateService;
import cn.qkmango.tms.common.anno.Permission;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.web.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.update.updateRoom;
import cn.qkmango.tms.common.validate.group.update.updateStudentScore;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(value="/update",method = RequestMethod.POST)

/**
 * 用户基本信息修改的控制器
 */
public class UpdateController {

    @Resource
    private UpdateService updateService;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    /**
     * 更改用户密码
     * @param session
     * @param updatePasswordVO
     * @param locale
     * @return
     * @throws PermissionException
     * @throws UpdateException
     */
    @Permission
    @RequestMapping("/updatePassword.do")
    public Map<String, Object> updatePassword(HttpSession session,
                                              UpdatePasswordVO updatePasswordVO,
                                              Locale locale) throws PermissionException, UpdateException {

        //获取用户ID
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        //获取用户权限类型
        PermissionType thisUserPermissionType = user.getPermissionType();

        updatePasswordVO.setId(id);
        updatePasswordVO.setPermissionType(thisUserPermissionType);

        updateService.updatePassword(updatePasswordVO,locale);

        ResponseMap map = new ResponseMap();

        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updatePassword.success",null,locale));

        return map;
    }

    /**
     * 更新学生成绩
     * @Validated true
     * @param elective
     * @param result
     * @return
     * @throws UpdateException
     */
    @Permission(PermissionType.teacher)
    @RequestMapping("updateStudentScore.do")
    public Map<String, Object> updateStudentScore(@Validated(updateStudentScore.class) Elective elective, BindingResult result) throws UpdateException {

        if (result.hasErrors()) {
            throw new ParamVerifyError(result);
        }

        updateService.updateStudentScore(elective);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage("修改学生成绩成功");

        return map;
    }

    /**
     * 更新楼宇信息
     * @Validated false
     * @param building
     * @return
     * @throws UpdateException
     */
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
     * 修改 教室信息
     * @validated true
     * @param room
     * @return
     * @throws UpdateException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("updateRoom.do")
    public Map<String, Object> updateRoom(@Validated(updateRoom.class) Room room, BindingResult result, Locale locale) throws UpdateException {

        if (result.hasErrors()) {
            throw new ParamVerifyError(result);
        }

        updateService.updateRoom(room,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateRoom.success",null,locale));

        return map;
    }


    /**
     * 更新修改 年份
     * @Validated false
     * @param year
     * @return
     * @throws UpdateException
     */
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
