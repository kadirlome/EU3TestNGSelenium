package com.cybertek.tests.day_12_properties_driver_test;

public class Singleton {
    //singleton class will have private constructor
    //it means other classes cannot create object of this class
    private Singleton(){}
    private static String str;

    public static String getInstance(){
        //if str no value, initialize it
        if(str ==null){
            System.out.println("Str is null");
            str="somevalue";
        }else {
            System.out.println("if it has value just run it");
        }
        return str;
    }
}
