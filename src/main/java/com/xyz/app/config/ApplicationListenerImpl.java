package com.xyz.app.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * spring Listener监听器
 * Created by Lenovo on 2018/1/14.
 */
@Component
public class ApplicationListenerImpl implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
            System.out.println("spring Event:"+applicationEvent.getSource());
    }
}
