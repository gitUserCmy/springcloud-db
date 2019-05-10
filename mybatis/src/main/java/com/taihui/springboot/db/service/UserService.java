package com.taihui.springboot.db.service;


import com.taihui.springboot.db.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUser();

    /**
     * 删除用户
     * @param id
     */
    void delUser(Integer id);

}
