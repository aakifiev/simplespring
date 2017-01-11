package ru.aakifiev;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by aakifiev on 22.12.2016.
 */

@Aspect
@Component
public class AspectBean {

    //@Before("execution(* ru.aakifiev.Bean1.execution1())")
    //@AfterReturning("execution(* ru.aakifiev.Bean1.execution1())")
    @After("execution(* ru.aakifiev.Bean1.execution1())")
    private void executionAspect(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution(* ru.aakifiev.Bean1.execution2())",
            returning = "retVal"
    )
    private void executionAspectAfterReturn(Object retVal){
        System.out.println((String)retVal);
    }
}
