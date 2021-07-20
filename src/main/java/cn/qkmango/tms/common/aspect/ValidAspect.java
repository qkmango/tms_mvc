package cn.qkmango.tms.common.aspect;

import cn.qkmango.tms.exception.ParamVerifyError;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

/**
 * @className: Aspect
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-07-20 21:04
 * @version: 1.0
 */
@org.aspectj.lang.annotation.Aspect
@Component
public class ValidAspect {
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
