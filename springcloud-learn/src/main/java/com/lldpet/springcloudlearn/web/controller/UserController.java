package com.lldpet.springcloudlearn.web.controller;

import com.lldpet.springcloudlearn.entity.demo.User;
import com.lldpet.springcloudlearn.service.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author llduo
 * @Description
 * @create 2019-01-14 10:55
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("username")String userName){
        return userService.findByUserName(userName);
    }

}
