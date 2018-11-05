package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/world")
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/chinese", produces = "text/json; charset=UTF-8")
    @ResponseBody
    public String chinese(){
        return "你好";
    }

    /*
    * 测试接收raw形式的参数
    * 用一个bean去接收
    * */
    @RequestMapping(value = "/raw")
    public void raw(@RequestBody User user){
        System.out.println(user.getUsername());
    }
}
