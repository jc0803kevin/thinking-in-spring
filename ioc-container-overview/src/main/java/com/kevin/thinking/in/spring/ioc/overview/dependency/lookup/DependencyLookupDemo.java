package com.kevin.thinking.in.spring.ioc.overview.dependency.lookup;

import com.kevin.thinking.in.spring.ioc.overview.annotation.Super;
import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author kevin
 * @Description 通过名称依赖查找示例
 * @Date Created on 2020/3/4 10:59
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        //lookupInRealTime(beanFactory);

        //lookupInLazy(beanFactory);

        //lookupByType(beanFactory);

        //查找集合对象
        //lookupByCollectionType(beanFactory);

        //根据注解查找
        lookupByAnnotation(beanFactory);

    }

    /**
     * @Author kevin
     * @Description 根据注解查找
     * @Date Created on 2020/3/4 11:40
     */
    private static void lookupByAnnotation(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);

            System.out.println("查找所有标注 @Super 的集合User bean :" + users);
        }

    }


    /**
     * @Author kevin
     * @Description 查找集合对象
     * @Date Created on 2020/3/4 11:25
     */
    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);

            System.out.println("查找所有的集合User bean :" + users);
        }
    }


    /**
     * @Author kevin
     * @Description 根据类型 实时查找
     * @Date Created on 2020/3/4 11:22
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型 实时查找 bean :" + user);
    }

    /**
     * @Author kevin
     * @Description 根据名称 延迟查找
     * @Date Created on 2020/3/4 11:13
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();

        System.out.println("根据名称 延迟查找 bean :" + user);
    }


    /**
     * @Author kevin
     * @Description 根据名称 实时查找
     * @Date Created on 2020/3/4 11:11
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");

        System.out.println("根据名称 实时查找 bean :" + user);
    }

}
