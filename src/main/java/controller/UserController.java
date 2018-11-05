package controller;

import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IUserService;
import util.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @ResponseBody
    @RequestMapping("/login")
    public Result login(User user, HttpServletRequest request, HttpServletResponse response){
        logger.info("用户开始登陆");
        if(user.getUsername() == null || user.getUsername().equals("") || user.getPassword() == null || user.getPassword().equals("")){
            return new Result(500, "用户名，密码不能为空");
        }
        User u = userService.login(user);
        if(u == null){
            return new Result(500, "用户名或密码错误");
        }else{
            logger.info("{}-登录成功", user.getUsername());
            response.addCookie(new Cookie("token", user.getUsername()));
            return new Result(200,"登录成功");
        }
    }

    @ResponseBody
    @RequestMapping("/regist")
    public Result regist(User user){
        if(user.getUsername() == null || user.getUsername().equals("") || user.getPassword() == null || user.getPassword().equals("")){
            return new Result(500, "用户名，密码不能为空");
        }
        User u = userService.selectByName(user);
        if(u != null){
            return new Result(500, "用户已存在");
        }else{
            userService.regist(user);
            return new Result(200, "注册成功");
        }
    }


}
