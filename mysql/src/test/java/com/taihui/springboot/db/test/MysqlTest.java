package com.taihui.springboot.db.test;

import com.taihui.springboot.db.entity.Department;
import com.taihui.springboot.db.entity.Role;
import com.taihui.springboot.db.entity.User;
import com.taihui.springboot.db.repository.DepartmentRepository;
import com.taihui.springboot.db.repository.RoleRepository;
import com.taihui.springboot.db.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MysqlTest {

    private Logger logger = LoggerFactory.getLogger(JpaConfiguration.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RoleRepository roleRepository;

    @Before
    public void before(){
        Department department = new Department();
        department.setName("开发部");
        department.setCreateDate(new Date());
        departmentRepository.save(department);
        Assert.notNull(department.getId(),"depart_id null");

        Role role = new Role();
        role.setName("经理");
        role.setCreateDate(new Date());
        roleRepository.save(role);
        Assert.notNull(role.getId(),"role_id null");
//        role.setName("员工");
//        role.setCreateDate(new Date());


        User user = new User();
        user.setName("xiaoming");
        user.setDepartment(department);
        List<Role> roles = roleRepository.findAll();
        user.setRoles(roles);
        user.setCreateDate(new Date());
        userRepository.save(user);
        Assert.notNull(user.getId(),"user_id null");
    }

    @Test
    public void findPage(){
       List<User> users = userRepository.findAll();
        for (User user:users
             ) {
            System.out.println(user.getName());
        }
    }

}
