package com.kevin.thinking.in.spring.bean.definition;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @Author kevin
 * @Description 注解 BeanDefinition 示例
 * @Date Created on 2020/3/5 11:12
 */
//3. 通过@impor 导入的方式
//@Import(AnnotationBeanDefinitionDemo.Config.class)

//@ComponentScan("com.kevin.thinking.in.spring.bean.definition")
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class 配置类
        applicationContext.register(Config.class);
        // 通过 BeanDefinition 注册 API 实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext, "kevin-user");
        // 2. 非命名 Bean 的注册方法
        registerUserBeanDefinition(applicationContext);


        //启动应用上下文
        applicationContext.refresh();

        System.out.println("Config 类型的所有bean: " + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有bean: " + applicationContext.getBeansOfType(User.class));

        //显示的关闭应用上下文
        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "kevin");

        // 判断如果 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            // 注册 BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 非命名 Bean 注册方法
            //com.kevin.thinking.in.spring.ioc.overview.domian.User#0
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
            //com.kevin.thinking.in.spring.ioc.overview.domian.User#1
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    //2. 通过 @Component 方式
    //@Component
    public static class Config{

        //1. 通过@Bean 定义
        @Bean(name = {"kevin-user-alias"})
        public User user(){
            User user = new User();
            user.setId(100L);
            user.setName("kevin-user-alias");
            return user;
        }
    }
}
