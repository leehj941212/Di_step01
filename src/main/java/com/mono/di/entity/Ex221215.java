package com.mono.di.entity;

import com.mono.di.ui.ColorPrinter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex221215 {
  public void ex1(){

    ColorPrinter printer = new ColorPrinter();


    Personinfo personinfo = new Personinfo();


    personinfo.setPrinter(printer);


    List<String> nameList = new ArrayList();
    nameList.add("Spring");
    nameList.add("Ioc");
    nameList.add("DI");
    personinfo.setNames(nameList);


    List<Person> personList = new ArrayList();

    Person person1 = new Person();
    person1.setAge(30);
    person1.setName("power");
    personList.add(person1);

    Person person2 = new Person();
    person1.setAge(50);
    person1.setName("abcd");
    personList.add(person1);

    Person person3 = new Person();
    person1.setAge(24);
    person1.setName("next");
    personList.add(person1);

    personinfo.setPersons(personList);


    Map<String , Integer> ageMap = new HashMap();
    ageMap.put("Kim" , 10);
    ageMap.put("Lee" , 20);
    ageMap.put("Ahn" , 30);
    personinfo.setAges(ageMap);

    Set<String> emailSet = new HashSet();
    emailSet.add("kor@naver.com");
    emailSet.add("eng@naver.com");
    emailSet.add("eng@naver.com");
    personinfo.setEmails(emailSet);

  }
}
