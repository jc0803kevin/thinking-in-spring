package com.kevin.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.*;

/**
 * @Author kevin
 * @Description 基于注解驱动 {@link org.springframework.context.event.EventListener}
 * @Date Created on 2020/7/6 20:53
 */

public class AnnotationEventListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationEventListenerDemo.class);

        //不同的事件范围
        applicationContext.addApplicationListener(new ApplicationListener<ContextStartedEvent>() {
            @Override
            public void onApplicationEvent(ContextStartedEvent event) {
                System.out.printf("监听到事件 %s source:[%s] \n", event.getClass().getName(), event.getSource().toString());
            }
        });


        applicationContext.refresh();
        applicationContext.start();
        applicationContext.stop();
        applicationContext.close();
    }

    /**
     * @Author kevin
     * @Description 方法二：基于 Spring 注解：@org.springframework.context.event.EventListener
     * @Date Created on 2020/7/6 21:20
     */
    @EventListener
    public void onApplicationEvent(ContextStartedEvent event) {
        println(event);
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        println(event);
    }

    @EventListener
    public void onApplicationEvent(ContextStoppedEvent event) {
        println(event);
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        println(event);
    }

    private static void println(Object printable) {
        System.out.printf("[线程：%s] : %s\n", Thread.currentThread().getName(), printable.toString());
    }

}
