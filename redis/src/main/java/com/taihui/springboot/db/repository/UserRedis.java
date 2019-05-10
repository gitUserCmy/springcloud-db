package com.taihui.springboot.db.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taihui.springboot.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRedis {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //添加key,value(用户实体)
    public void add(String key, Long time, User user){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(user),time, TimeUnit.MINUTES);
    }
    //添加key,value(用户集合)
    public void add(String key, Long time, List<User> users){
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(users),time,TimeUnit.MINUTES);
    }

    //通过key，获取用户信息
    public User get(String key){
        Gson gson = new Gson();
        User user = null;
        String userStr = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(userStr)){
            user = gson.fromJson(userStr,User.class);
        }
        return user;
    }
    //通过key,获取用户集合
    public List<User> getList(String key){
        Gson gson = new Gson();
        List<User> users = null;
        String listJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(listJson)){
            users = gson.fromJson(listJson,new TypeToken<User>(){}.getType());
        }
        return users;
    }

    //通过key 删除数据
    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }




}
