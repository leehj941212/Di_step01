package com.mono.di.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class S4_JunitBeforeAllTest {

    private static ApplicationContext ctx;

    @BeforeAll
    public static void BeforeEachMessage1(){
        ctx = new ClassPathXmlApplicationContext("classpath:config1.xml");
        System.out.println("BeforeAll.ctx : " + ctx);
    }
    
    @Test
    @DisplayName("springContainerTest1의 BeforeAll this확인")
    public void springContainerTest1(){

        System.out.println("springContainerTest1.this : " + this);
        System.out.println("springContainerTest1.ctx : " + ctx);
        Hello hello = ctx.getBean("hello" , Hello.class);
        hello.print("hello...");
    }

    @Test
    @DisplayName("springContainerTest2의 BeforeAll this확인")
    public void springContainerTest2(){

        System.out.println("springContainerTest2.this : " + this);
        System.out.println("springContainerTest2.ctx : " + ctx);
        Hello hello = ctx.getBean("hello" , Hello.class);
        hello.print("hello...");
    }
}