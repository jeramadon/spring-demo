package com.ebf.springdemo.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpElBeanA {

    @Value("#{2+3}")
    private Integer add;

    @Value("#{'2'+'3'}")
    private String addString;

    @Value("#{2 == 2}")
    private boolean equal;

    @Value("#{spElBeanB.intProp}")
    private String beanProp;
}
