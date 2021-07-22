package cn.qkmango.tms.common.aspect;

import cn.qkmango.tms.common.exception.ParamVerifyError;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

/**
 * @className: 控制器方法参数校验切面
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-07-20 21:04
 * @version: 1.0
 */
@Aspect
@Component
public class ControllerParamValidAspect {
    @Around("execution(* cn.qkmango.tms.test.controller.*Controller.*(..))")
    public Object myBefore2(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("切面————前");

        Object[] args = jp.getArgs();
        ArrayList<BindingResult> bindingResultList = null;

        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    if (bindingResultList == null) {
                        bindingResultList = new ArrayList<>();
                    }
                    bindingResultList.add(result);
                }
            }
        }

        if (bindingResultList != null) {
            throw new ParamVerifyError(bindingResultList);
        }

        Object proceed = jp.proceed();

        System.out.println("切面————后");
        return proceed;
    }
}
