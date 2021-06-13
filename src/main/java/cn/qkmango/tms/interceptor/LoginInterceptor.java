package cn.qkmango.tms.interceptor;

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

        System.out.println(path);
        if ("/system/login.do".equals(path)) {
            return true;
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            return true;
        }

        response.getWriter().write("{\"success\":false,\"message\":\"未登录!\"}");
        return false;

    }

    // @Override
    // public void postHandle(HttpServletRequest request,
    //                        HttpServletResponse response,
    //                        Object handler,
    //                        ModelAndView modelAndView) throws Exception {
    //     System.out.println("[拦截器1] MyInterceptor.postHandle() 后处理方法");
    // }

    // @Override
    // public void afterCompletion(HttpServletRequest request,
    //                             HttpServletResponse response,
    //                             Object handler,
    //                             Exception ex) throws Exception {
    //     System.out.println("[拦截器1] MyInterceptor.afterCompletion() 最后执行的方法");
    // }
}
