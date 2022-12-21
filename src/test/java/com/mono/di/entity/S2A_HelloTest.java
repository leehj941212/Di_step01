package com.mono.di.entity;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class S2A_HelloTest {
    @DisplayName("Container를 사용한 객체주입(Di)")
    @Test
    public void springContainerTest(){
        ExConfig5 exConfig5 = new ExConfig5();
        System.out.println(exConfig5.toString());
    }

}