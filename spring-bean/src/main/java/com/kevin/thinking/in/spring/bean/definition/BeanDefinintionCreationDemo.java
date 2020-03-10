package com.kevin.thinking.in.spring.bean.definition;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author kevin
 * @Description {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @Date Created on 2020/3/5 10:10
 */
public class BeanDefinintionCreationDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 1. 通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        // 通过属性的方式赋值
        beanDefinitionBuilder
                .addPropertyValue("id", 2)
                .addPropertyValue("name", "BeanDefinitionBuilder kevin");
        // BeanDefinitionBuilder不是bean的最终状态，可以自定义修改

        //???? BeanDefinition 定义的Bean 如何获取
        User user = applicationContext.getBean(User.class);
        System.out.println("获取到的 User bean:" + user);


        //2. 通过通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues
                .add("id", 2)
                .add("name", "kevin");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
