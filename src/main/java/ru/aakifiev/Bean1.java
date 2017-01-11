package ru.aakifiev;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by aakifiev on 22.12.2016.
 */

@Component("Bean1")
public class Bean1 {
    public void execution1(){
        System.out.println("execution1");
    }

    public String execution2(){
        System.out.println("execution2");
        return "execution2333333";
    }

    public void execution3() throws Exception {
        System.out.println("execution3");
        throw new Exception();
    }
}
