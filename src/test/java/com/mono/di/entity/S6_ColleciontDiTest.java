package com.mono.di.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


public class S6_ColleciontDiTest {

    private ApplicationContext context;
    Personinfo personInfo;

    @BeforeEach
    public void before() {
        //IoC 컨테이너를 생성
        //1.ApplicationContext 객체 생성
        context = new ClassPathXmlApplicationContext("classpath:config5.xml");
        personInfo = context.getBean(Personinfo.class);

        System.out.println("======================");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


        System.out.println("컨테이너생성");
        System.out.println("Before 객체 : " + this);
        System.out.println("컨테이너 객체 : " + context);
    }

    @Test
    @DisplayName("List Di 테스트")
    public void listDiTest() {

        personInfo.print("HELLO");

        System.out.println("------------------------");

        List<String> list = personInfo.getNames();
        list.forEach(System.out::println);

        System.out.println("------------------------");

        /* 확장 for */
        for (String value : list) {
            // nmList.accept(value);
            System.out.println(value);
        }

        System.out.println("------------------------");

        /* Iterator */
        Iterator<String> lst = list.iterator();
        while (lst.hasNext()) {
            System.out.println(lst.next());
        }
    }

    @Test
    @DisplayName("Map Di 테스트")
    public void mapDiTest() {

        /* enhenced for */
        Map<String, Integer> ages = personInfo.getAges();
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println("KEY : " + entry.getKey() + ", VALUE : " + entry.getValue());
        }

        System.out.println("------------------------");

        // Iterator가 안되서 set(keyset)을 통해서 iterator를 얻음
        Iterator<String> keys = ages.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println("key : " + key + ", value : " + ages.get(key));
        }

        System.out.println("------------------------");

        /* lamda */
        ages.forEach((key, value) -> System.out.println("key:" + key + " | value:" + value));
        ages.entrySet().forEach(entry -> System.out.println("key:" + entry.getKey() + " | value:" + entry.getValue()));
        ages.keySet().forEach(key -> System.out.println("key : " + key));
        ages.values().forEach(value -> System.out.println("value : " + value));
    }

    @Test
    @DisplayName("Set Di 테스트")
    public void setDiTest() {

        Set<String> hs = personInfo.getEmails();
        Iterator<String> hi = hs.iterator();

        /* lamda method 참조*/
        hs.forEach(System.out::println);

        System.out.println("------------------------");

        /* 중복제거 */
        /* Iterator */
        while (hi.hasNext()) {
            System.out.println(hi.next());
        }

        System.out.println("------------------------");

        /* enhenced for */
        for (String s : hs) {
            System.out.println(s);
        }
    }

    @Test
    @DisplayName("comparable sort Test")
    public void comparableTest() {

        List<Person> persons = personInfo.getPersons();

        System.out.println("-------- before person name sort  ----------------");
        persons.forEach(row -> System.out.println(row.getName() + " : " + row.getAge()));

        /* List 정렬 */
        Collections.sort(persons);

        System.out.println("-------- after person name sort ----------------");
        persons.forEach(row -> System.out.println(row.getName() + " : " + row.getAge()));

    }
}