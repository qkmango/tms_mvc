package cn.qkmango.tms.web.interceptor;

import cn.qkmango.tms.util.ResponseUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String path = request.getServletPath();

        //如果是登陆请求，则放行
        if ("/system/login.do".equals(path)) {
            return true;
        }

        //如果session存在，说明已经登陆过了，则放行
        HttpSession session = request.getSession(false);
        if (session != null) {
            return true;
        }

        ResponseUtil.responseJson(response,"{\"success\":false,\"message\":\"未登录!\"}");
        return false;

    }
}
