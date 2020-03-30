package com.kevin.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author kevin
 * @Description 基于 byName/byType 自动 的 Setter方法注入实例
 * @Date Created on 2020/3/29 12:20
 */
public class AutoWiringDependencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        // 加载 location
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/autowiring-dependency-setter-context.xml");

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);

        System.out.println("userHolder :" + userHolder);
    }



}
