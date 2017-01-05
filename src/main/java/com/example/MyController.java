package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  velocity 测试
 *  直接添加依赖即可  spring-boot-starter-velocity
 *
 * @author sxp
 * @create 2016/12/30.
 */
@Controller
@ConfigurationProperties(prefix = "sxp")
public class MyController {


    @Value("${myName}")
    String myNmae;

    String prop;

    public void setProp(String prop) {
        this.prop = prop;
    }

    @RequestMapping("/index")
    public String Index(){
        System.out.println("hello"+myNmae);
        System.out.println("you are "+prop);
        return "index";
    }

}
