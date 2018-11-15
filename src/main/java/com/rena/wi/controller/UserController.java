package com.rena.wi.controller;

import com.rena.wi.service.UserService;
import com.rena.wi.service.impl.UserServiceImpl;
import com.rena.wi.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * description 用户
 *
 * @author rena
 * @date 2018/11/9 23:13
 **/

@Controller
@RequestMapping("user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

//    @ResponseBody
//    @PostMapping("login")
//    public boolean login(@RequestParam String username, @RequestParam String password) {
//        logger.info(username + "," + password);
//        UserVO userVO = new UserVO();
//        userVO.setUsername(username);
//        userVO.setPassword(password);
//        boolean isLoginSuccess = userService.login(userVO);
//        return isLoginSuccess;
//    }

    @ResponseBody
    @PostMapping("login")
    public boolean login(UserVO userVO) {
        logger.info(userVO.getUsername() + "," + userVO.getPassword());
        boolean isLoginSuccess = userService.login(userVO);
        return isLoginSuccess;
    }

    @PostMapping("register")
    public String register(@RequestParam String username, @RequestParam String password) {
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        userVO.setPassword(password);
        userService.register(userVO);
        return "index";
    }

    /**
     * get 传参 http://localhost:8080/user/hello/yuanna
     * @param id
     * @return
     */
    @GetMapping("hello/{id}")
    @ResponseBody
    public String hello(@PathVariable String id){
        return id;
    }

    /**
     * get 传参
     * @param id
     * @return http://localhost:8080/user/helloWorld?id=1&name=rena
     */
    @GetMapping("helloWorld")
    @ResponseBody
    public int helloWorld(@RequestParam int id, @RequestParam String name){
        logger.info(id + ","+name);
        return id;
    }

    /**
     * get 传参 http://localhost:8080/user/test?id=2&username=dengxiangjun
     * @param id
     * @return
     */
    @GetMapping("test")
    @ResponseBody
    public int test(@RequestParam int id, @RequestParam("username") String name){
        logger.info(id + ","+name);
        return id;
    }

//    public UserVO

    @GetMapping("register")
    public String register(){
        return "register";
    }
}