package com.ebf.springdemo.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SpElTest {

    @Autowired
    private SpElBeanA spElBeanA;

    @Test
    public void injected_OK() {
        assertNotNull(spElBeanA);
    }
}
