package com.qa.api.gorest.pojo;

public class UserInfoComplexJson {

    //class vars ===> variable name should be the same as in payload body
    private String first_name;
    private String last_name;
    private String gender;
    private String dob;
    private String email;
    private String phone;
    private String website;
    private String address;
    private String status;
    private LinksComplexJSON link;

    //constructor

    /**
     * This constructor is to fill the key value pairs present in the payload without any parent
     * @param first_name
     * @param last_name
     * @param gender
     * @param dob
     * @param email
     * @param phone
     * @param website
     * @param address
     * @param status
     * @param link
     */
    public UserInfoComplexJson(String first_name, String last_name, String gender, String dob, String email, String phone, String website, String address, String status, LinksComplexJSON link) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.address = address;
        this.status = status;
        this.link = link;
    }

    //getter and setter methods

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LinksComplexJSON getLink() {
        return link;
    }

    public void setLink(LinksComplexJSON link) {
        this.link = link;
    }
}
