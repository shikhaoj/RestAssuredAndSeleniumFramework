package com.rest.apis.post;

//POJO Template for User
public class User {
    //class vars
    private boolean private_variable;
    private String default_branch;
    private boolean disabled;
    private String name;

    //Create the constructor automatically by just right click -->then go to source then -->go to generate constructor with fields
    //constructor
    public User(boolean private_variable, String default_branch, boolean disabled, String name) {
        this.private_variable = private_variable;
        this.default_branch = default_branch;
        this.disabled = disabled;
        this.name = name;
    }

    //getter and setter methods:
    //Right-click --> source --> generate getter and setter methods

    //With the help of setters we will be setting the variable
    //And then with the help of getters we will get the variable value
    public boolean isPrivate_variable() {
        return private_variable;
    }

    public void setPrivate_variable(boolean private_variable) {
        this.private_variable = private_variable;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
