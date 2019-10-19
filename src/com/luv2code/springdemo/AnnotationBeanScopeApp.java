package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {

    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach",Coach.class);

        //check if they are the same
        boolean result = (theCoach == alphaCoach);

        //print out the results
        System.out.println("\n Pointing to the same object: " + result);
        System.out.println("\n Memory Location for theCoach: " + theCoach);
        System.out.println("\n Memory Location for alphaCoach: " +  alphaCoach);

        //close the context
        context.close();
    }
}
