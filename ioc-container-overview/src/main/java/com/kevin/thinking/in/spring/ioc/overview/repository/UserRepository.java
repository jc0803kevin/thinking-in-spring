package com.kevin.thinking.in.spring.ioc.overview.repository;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.Collection;

/**
 * @Author kevin
 * @Description 模拟信息存储
 * @Date Created on 2020/3/4 12:35
 */
public class UserRepository {

    private Collection<User> users;// 自定义bean

    private BeanFactory beanFactory;// 内建非bean 对象

    private ObjectFactory<User> userObjectFactory;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<User> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }
}
