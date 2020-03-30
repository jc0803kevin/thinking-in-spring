package com.kevin.thinking.in.spring.ioc.dependency.injection;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author kevin
 * @Description 基础xml的 手动 Setter方法注入实例
 * @Date Created on 2020/3/29 12:20
 */
public class XmlDenpendencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-setter-context.xml");

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);

        System.out.println("userHolder :" + userHolder);
    }
}
