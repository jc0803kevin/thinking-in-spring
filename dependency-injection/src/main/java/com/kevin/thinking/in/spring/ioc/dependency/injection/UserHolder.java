package com.kevin.thinking.in.spring.ioc.dependency.injection;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;

/**
 * @Author kevin
 * @Description User Holder 类
 * @Date Created on 2020/3/29 17:43
 */
public class UserHolder {


    private User user;

    public UserHolder(){}

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
