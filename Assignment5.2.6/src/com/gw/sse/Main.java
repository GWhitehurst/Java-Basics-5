package com.gw.sse;

import  java.math.BigDecimal;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.ResultSet;
import  java.sql.Statement;

class SampleSingleton{
    private static Connection conn = null;
    private static SampleSingleton instance = null;

    private SampleSingleton(){

    }

    public static SampleSingleton getInstance(){
        synchronized(SampleSingleton.class){
            if(instance == null)
                instance = new SampleSingleton();
            return instance;
        }
    }
}

public class Main {

    public static void main(String[] args) {
    //write code here
    }
}
