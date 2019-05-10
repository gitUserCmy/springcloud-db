package com.taihui.springboot.db.controller;

import com.taihui.springboot.db.entity.User;
import com.taihui.springboot.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    /**
     * 路径参数
     * @param id 通过路径传递过来
     */
    @RequestMapping("/delUser/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userService.delUser(id);
    }

}
