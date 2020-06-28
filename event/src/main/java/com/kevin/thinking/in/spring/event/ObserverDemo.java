package com.kevin.thinking.in.spring.event;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * @Author kevin
 * @Description {@link Observer} 实例
 * 观察者模式
 * @Date Created on 2020/6/28 19:37
 */
public class ObserverDemo {

    public static void main(String[] args) {
        EventObservable eventObservable = new EventObservable();
        //观察者 （监听）
        eventObservable.addObserver(new EventObserver());
        //发布事件
        eventObservable.notifyObservers("Hello , kevin");
    }

    /**
     * @Author kevin
     * @Description 被观察对象， 必须继承{@link Observable} 类
     * @Date Created on 2020/6/28 19:51
     */
    static class EventObservable extends Observable {

        @Override
        public void notifyObservers(Object obj) {
            setChanged();//标志已被更改
            super.notifyObservers(new EventObject(obj));
            clearChanged();
        }
    }

    /**
     * @Author kevin
     * @Description 观察者， 必须实现{@link Observer} 接口
     * @Date Created on 2020/6/28 19:51
     */
    static class EventObserver implements Observer, EventListener{

        public void update(Observable o, Object event) {
            EventObject eventObject = (EventObject) event;
            System.out.println("接收到事件->"+eventObject);
        }
    }
}
