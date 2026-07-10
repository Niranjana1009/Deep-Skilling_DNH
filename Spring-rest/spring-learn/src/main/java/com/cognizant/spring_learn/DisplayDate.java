package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisplayDate {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat sdf =
                context.getBean("dateFormat", SimpleDateFormat.class);

        System.out.println(sdf.format(new Date()));

        context.close();
    }
}