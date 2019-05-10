package com.taihui.springboot.db.mapper;

import com.taihui.springboot.db.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from tb_user")
    List<User> getAllUser();

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from tb_user where id=#{id}")
    void delUser(Integer id);



}
