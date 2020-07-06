package com.kevin.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;

/**
 * @Author kevin
 * @Description {@link ApplicationListenerDemo} demo
 * @Date Created on 2020/7/6 20:08
 *
 * 介绍spring 的内置事件
 * @see ContextRefreshedEvent
 * @see ContextStartedEvent
 * @see ContextStoppedEvent
 * @see ContextClosedEvent
 */
public class ApplicationListenerDemo {

    @EventListener
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //基于 Spring 接口，注册事件监听
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.printf("监听到事件 %s source:[%s] \n", event.getClass().getName(), event.getSource().toString());
            }
        });

        applicationContext.refresh();//ContextRefreshedEvent

        applicationContext.start();//ContextStartedEvent

        applicationContext.stop();//ContextStoppedEvent

        applicationContext.close();//ContextClosedEvent

    }

}
