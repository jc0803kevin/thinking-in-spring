package com.kevin.thinking.in.spring.bean.definition;

import com.kevin.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.kevin.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @Author kevin
 * @Description Bean 实例化
 * @Date Created on 2020/3/10 15:42
 */
public class BeanInstantiationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(BeanInstantiationDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 UserFactory
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);

        // 关闭 spring 应用上下文
        applicationContext.close();
    }

    @Bean
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }

}
