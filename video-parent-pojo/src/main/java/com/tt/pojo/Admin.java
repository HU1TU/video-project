package com.tt.pojo;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-10-20 10:54:19
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -87106808367311659L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    /**
    * 角色
    */
    private String roles;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}