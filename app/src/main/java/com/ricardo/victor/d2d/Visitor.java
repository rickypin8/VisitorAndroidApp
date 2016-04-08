package com.ricardo.victor.d2d;



public class Visitor {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    //constructors
    public Visitor(){
        this.name="";
        this.description="";
    }
    public Visitor(String name,String description){
        this.name=name;
        this.description=description;
    }
}
