package com.rest.apis.post;

//POJO class for new user
public class CreateUser {

    //class vars
    private String name;
    private String job;

    //constructor
    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    //getter and setter methods


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
