package com.taihui.springboot.db.service;

import com.taihui.springboot.db.entity.User;
import com.taihui.springboot.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *  缓存的key  "UserCache::user.getAllUser"
     * @return
     */
    @Override
    @Cacheable(value = "UserCache",key = "'user.getAllUser'") //添加缓存
    public List<User> getAllUser() {
        System.out.println("select * from tb_user");
        return userMapper.getAllUser();
    }

    /**
     * 移除缓存：
     *   执行新增、修改、删除操作时，
     *      通常情况需要清空缓存，下次加载时重新添加缓存。
     * @param id
     */
    @Override
    @CacheEvict(value = "UserCache",key = "'user.getAllUser'")
    public void delUser(Integer id) {
        System.out.println("delete user");
        userMapper.delUser(id);
    }
}
