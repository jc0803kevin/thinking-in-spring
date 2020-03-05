package com.kevin.thinking.in.spring.ioc.overview.dependency.injection;

import com.kevin.thinking.in.spring.ioc.overview.annotation.Super;
import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import com.kevin.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @Author kevin
 * @Description 依赖注入
 * @Date Created on 2020/3/4 10:59
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 依赖来源一： 自定义bean
        UserRepository userRepository = beanFactory.getBean("userRepository",  UserRepository.class);

        //依赖注入 依赖查找 不同源
        System.out.println(userRepository.getBeanFactory() == beanFactory);//false

        // 依赖来源二: 容器内建依赖
        System.out.println(userRepository.getBeanFactory() == beanFactory);//false

        ObjectFactory userObjectFactory = userRepository.getUserObjectFactory();

        System.out.println(userObjectFactory.getObject());// primary原因 SuperUser{addr='苏州园区'} User{id=1, name='kevin'}

        //依赖来源三：容器内建 Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment Bean 对象： " + environment);
        // 查找通过注入方式 的bean
        //lookupByInjectionBean(beanFactory);
    }



    /**
     * @Author kevin
     * @Description 通过自动注入的方式注入bean
     * 然后进行依赖查找验证是否注入成功
     * @Date Created on 2020/3/4 12:56
     */
    private static void lookupByInjectionBean(BeanFactory beanFactory) {

        UserRepository userRepository = (UserRepository) beanFactory.getBean("userRepository");

        System.out.println(userRepository.getUsers());
    }

}
