package com.example;

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
public class MyController {

    @RequestMapping("/index")
    public String Index(){
        return "index";
    }

}
