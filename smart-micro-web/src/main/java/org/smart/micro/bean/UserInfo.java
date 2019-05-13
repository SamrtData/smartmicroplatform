package org.smart.micro.bean;

import lombok.Data;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author jiangsida
 * @VERSION 1.0
 */
@Data
public class UserInfo {

    String name;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
