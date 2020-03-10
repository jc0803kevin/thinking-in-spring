package com.kevin.thinking.in.spring.bean.factory;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;

/**
 * @Author kevin
 * @Description 工厂
 * @Date Created on 2020/3/10 15:46
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }
}
