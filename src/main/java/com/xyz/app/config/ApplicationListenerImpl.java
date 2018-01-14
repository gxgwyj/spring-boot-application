package com.xyz.app.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Lenovo on 2018/1/14.
 */
public class ApplicationListenerImpl implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("spring Event:"+ applicationEvent.getTimestamp());
    }
}
