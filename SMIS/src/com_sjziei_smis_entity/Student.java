package com_sjziei_smis_entity;

import java.sql.Date;//调用sql包的Date，而不是util

public class Student {
    private int Id; //学生编号
    private String Name; //学生姓名
    private String Sex; //性别
    private Date Birthday; //生日
    private String Code; //学号
    private String IDcard; //身份证号
    private String Nation; //民族
    private String Address; //家庭住址
    private String Tel; //联系电话
    private String School; //毕业院校
    //无参构造方法
    public Student(){

    }
    //带参构造方法—多用来初始化数据信息
    public Student(int id, String name, String sex, Date birthday, String code,
                   String IDcard, String nation, String address, String tel, String school) {
        Id = id;
        Name = name;
        Sex = sex;
        Birthday = birthday;
        Code = code;
        this.IDcard = IDcard;
        Nation = nation;
        Address = address;
        Tel = tel;
        School = school;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String toString(){
        return this.Id + " " + this.Sex + " " + this.Birthday + " " + this.Code + " "
        + this.IDcard + " " + this.Nation + " " + this.Address + " " + this.Tel + " "
        + this.School;
    }
}
