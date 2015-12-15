package com.example.g0294.tutorial;

class Singleton{
    private static Singleton single = new Singleton();
    private String name;
    private Singleton(){}
    public static Singleton getInstance(){
        return single;
    }
    public void setName(String keyword){
        name = keyword;
    }
    public String getName(){
        return name;
    }
}