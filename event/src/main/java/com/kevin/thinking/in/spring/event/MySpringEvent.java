package com.kevin.thinking.in.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author kevin
 * @Description 自定义事件
 * @Date Created on 2020/7/6 19:32
 */
public class MySpringEvent extends ApplicationEvent {

    private String message;

    public MySpringEvent(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getSource() {
        return (String) super.getSource();
    }

    public String getMessage() {
        return message;
    }
}
