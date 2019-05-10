package com.taihui.springboot.db;

import com.taihui.springboot.db.entity.Department;
import com.taihui.springboot.db.entity.Role;
import com.taihui.springboot.db.entity.User;
import com.taihui.springboot.db.repository.UserRedis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestRedisConfig.class, UserRedis.class})
public class TestUser {

    @Autowired
    UserRedis userRedis;


    @Before
    public void setup(){
        Department deparment = new Department();
        deparment.setName("开发部");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("cmy");
        user.setCreateDate(new Date());
        user.setDepartment(deparment);

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

        userRedis.delete(this.getClass().getName()+":userByname:"+user.getName());
        userRedis.add(this.getClass().getName()+":userByname:"+user.getName(), 10L, user);
    }


    @Test
    public void get(){
        User user = userRedis.get(this.getClass().getName()+":userByname:cmy");
        System.out.println(user.getName());
        System.out.println(this.getClass().getName()+":userByname:cmy");
        Assert.assertNotNull(user);
        System.out.println("dd");
    }

}
