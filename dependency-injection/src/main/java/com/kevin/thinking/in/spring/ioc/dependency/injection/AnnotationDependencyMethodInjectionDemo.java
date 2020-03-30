package com.kevin.thinking.in.spring.ioc.dependency.injection;

import com.kevin.thinking.in.spring.ioc.overview.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @Author kevin
 * @Description 基础 Annotation 的 Method方法注入实例
 * @Date Created on 2020/3/29 12:20
 */
public class AnnotationDependencyMethodInjectionDemo {

    private UserHolder userHolder;

    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyMethodInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        // 刷新 应用上下文
        applicationContext.refresh();

        AnnotationDependencyMethodInjectionDemo demo = applicationContext.getBean(AnnotationDependencyMethodInjectionDemo.class);

        System.out.println("method userHolder :" + demo.userHolder);
        System.out.println("method userHolder2 :" + demo.userHolder2);

        System.out.println("userHolder2 = userHolder :" + (demo.userHolder2 == demo.userHolder));

        applicationContext.close();
    }

    /**
     * @Author kevin
     * @Description 方法注入的方式不关心方法的名称，只关心方法的参数
     * @Date Created on 2020/3/29 19:21
     */
    @Autowired
    public void init1(UserHolder userHolder){
        this.userHolder = userHolder;
    }

    @Resource
    public void init2(UserHolder userHolder){
        this.userHolder2 = userHolder;
    }


    @Bean
    public UserHolder userHolder (User user){
        return new UserHolder(user);
    }

}
