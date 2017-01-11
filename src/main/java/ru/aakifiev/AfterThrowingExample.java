package ru.aakifiev;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by aakifiev on 25.12.2016.
 */

@Aspect
@Component
public class AfterThrowingExample {

    @AfterThrowing("execution(* ru.aakifiev.Bean1.execution3())")
    public void doRecoveryAction(){
        System.out.println("AfterThrowingEx");
    }
}
