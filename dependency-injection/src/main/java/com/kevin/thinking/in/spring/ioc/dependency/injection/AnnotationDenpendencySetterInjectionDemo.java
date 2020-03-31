package com.kevin.thinking.in.spring.ioc.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author kevin
 * @Description 基础 Annotation 手动 的 Setter方法注入实例
 * @Date Created on 2020/3/29 12:20
 */
public class AnnotationDenpendencySetterInjectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //applicationContext.register(AnnotationDenpendencySetterInjectionDemo.class);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");

        //
        applicationContext.registerBeanDefinition("userHolder", createUserHoldereBeanDefinition());

        // 刷新 应用上下文
        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);

        System.out.println("userHolder :" + userHolder);

        applicationContext.close();
    }


    /**
     * @Author kevin
     * @Description 基于API 形式 通过BeanDefinition 构建
     * @Date Created on 2020/3/29 18:13
     */
    private static BeanDefinition createUserHoldereBeanDefinition(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addPropertyReference("user","superUser");
        return beanDefinitionBuilder.getBeanDefinition();
    }

    /**
     * @Author kevin
     * @Description 基于注解构建
     * @Date Created on 2020/3/31 16:25
     * @return
     */
//    @Bean
//    public UserHolder userHolder(User user){
//        return new UserHolder(user);
//    }

}
