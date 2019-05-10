package com.taihui.springboot.db.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Table(name = "t_user")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @ManyToOne
    @JoinColumn(name = "depart_id")
    @JsonBackReference  //为了解决对象中存在双向引用导致的无限递归（infinite recursion）问题。
                        // 这些标注均可用在属性或对应的get、set方法中。
                        //https://blog.csdn.net/qq_35357001/article/details/55505659
    private Department department;

    @ManyToMany(cascade = {},fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {
                @JoinColumn(name = "user_id")},
              inverseJoinColumns = {@JoinColumn(name = "role_id")}
                )
    private List<Role> roles = new ArrayList<>();

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
