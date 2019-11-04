package cn.gc.gtdclear.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宫成 on 2019/1/24.
 */
//@RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "hello world bro小星星! ";
    }
}
