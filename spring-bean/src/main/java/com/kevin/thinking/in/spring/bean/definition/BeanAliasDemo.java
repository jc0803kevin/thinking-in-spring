package com.kevin.thinking.in.spring.bean.definition;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author kevin
 * @Description Bean 别名示例
 * @Date Created on 2020/3/5 11:03
 */
public class BeanAliasDemo {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-alias-context.xml");

        User user = applicationContext.getBean("user", User.class);
        User kevinUser = applicationContext.getBean("kevin-user", User.class);

        System.out.printf("user Bean 是否和 别名 kevin-user 对等： "+  (user == kevinUser));

    }

}
