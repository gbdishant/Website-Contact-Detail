package com.site.context;

import com.site.common.Common;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ApplicationContext implements ApplicationContextAware {

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
         Common.executor = new ThreadPoolExecutor(25,25,5, TimeUnit.DAYS, new ArrayBlockingQueue<>(100000));
    }
}
