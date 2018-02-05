package com.xyz.app.springx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 类: SpringBeanPostProcesser <br>
 * 描述: spring bean 容器监听器<br>
 * 作者: gaoxugang <br>
 * 时间: 2018年01月29日 18:56
 */
@Component
public class SpringBeanPostProcesser implements BeanPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(SpringBeanPostProcesser.class);

    /**
     * 初始化bean前的回调方法
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        logger.info("before bean create name:{}",s);
        return o;
    }

    /**
     * 初始化bean后的回调方法
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        logger.info("after bean create name:{}",s);
        return o;
    }
}
