package com.kevin.thinking.in.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * @Author kevin
 * @Description 自定义事件监听
 * @Date Created on 2020/7/6 19:40
 */

public class MySpringEventListener implements ApplicationListener<MySpringEvent> {

    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.println("监听到事件： "+ event.getSource());
    }
}
