package com.kevin.thinking.in.spring.ioc.dependency.injection;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @Author kevin
 * @Description 基础 Annotation 手动 的 Field方法注入实例
 * @Date Created on 2020/3/29 12:20
 */
public class AnnotationDependencyFiledInjectionDemo {

    @Autowired
    private
    //static @AutoWired 会忽略掉静态字段
    UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyFiledInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        // 刷新 应用上下文
        applicationContext.refresh();

        AnnotationDependencyFiledInjectionDemo demo = applicationContext.getBean(AnnotationDependencyFiledInjectionDemo.class);

        System.out.println("userHolder :" + demo.userHolder);
        System.out.println("userHolder2 :" + demo.userHolder2);

        System.out.println("userHolder2 = userHolder :" + (demo.userHolder2 == demo.userHolder));

        applicationContext.close();
    }


    @Bean
    public UserHolder userHolder (User user){
        return new UserHolder(user);
    }

}
