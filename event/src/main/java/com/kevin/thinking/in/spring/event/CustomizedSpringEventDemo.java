package com.kevin.thinking.in.spring.event;

import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author kevin
 * @Description 自定义事件 demo
 * @Date Created on 2020/7/6 19:46
 */
public class CustomizedSpringEventDemo {

    public static void main(String[] args) {

        GenericApplicationContext context = new GenericApplicationContext();

        //注册事件监听
        context.addApplicationListener(new MySpringEventListener());

        //刷新应用上下文
        context.refresh();

        //发布自定义事件
        context.publishEvent(new MySpringEvent("Hello , kevin"));
        context.publishEvent(new MySpringEvent("欢迎来到 spring ."));


        //关闭应用上下文
        context.close();

    }
}
