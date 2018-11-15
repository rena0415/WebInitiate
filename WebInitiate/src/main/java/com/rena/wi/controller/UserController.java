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

    @ResponseBody
    @PostMapping("login")
    public boolean login(@RequestParam String username, @RequestParam String password) {
        logger.info(username + "," + password);
        UserVO userVO = new UserVO();
        userVO.setUsername(username);
        userVO.setPassword(password);
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

/*    @GetMapping("register")
    public String register(){
        return "register";
    }*/
}