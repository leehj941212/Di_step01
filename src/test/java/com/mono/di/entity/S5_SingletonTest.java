package com.mono.di.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

class S5_SingletonTest {
    private ApplicationContext ctx;

    @BeforeEach
    public void before(){
        System.out.println(1);
        ctx = new ClassPathXmlApplicationContext("classpath:config4.xml");
        System.out.println(2);
        String[] beanName = ctx.getBeanDefinitionNames();
        System.out.println(3);
        Arrays.stream(beanName).iterator().forEachRemaining(System.out::println);
        System.out.println(4);
    }

    @DisplayName("SingleTon 객체 테스트")
    @Test
    public void singleTonTest(){
        Hello hello1 = ctx.getBean("hello" , Hello.class);
        Hello hello2 = ctx.getBean("hello" , Hello.class);
        System.out.println(5);
        Hello hello3 = ctx.getBean("protoHello" , Hello.class);
        System.out.println(6);
        /*Assertions.assertSame(hello1,hello2);*/ //동일 객체인지
        System.out.println("hello1 : " + hello1 + "hello2 : " + hello2);
        System.out.println(hello1.getPrinter());
        System.out.println(hello3.getPrinter());
    }

    @DisplayName("Prototype 객체 테스트")
    @Test
    public void prototypeTest(){

        Hello hello3 = ctx.getBean("protoHello" , Hello.class);
        Hello hello4 = ctx.getBean("protoHello" , Hello.class);

        Assertions.assertNotSame(hello3,hello4);
        System.out.println("hello3 : " + hello3 + "hello4 : " + hello4);

        Hello hello5 = new Hello();
        hello5.setName("qqq");

    }

}