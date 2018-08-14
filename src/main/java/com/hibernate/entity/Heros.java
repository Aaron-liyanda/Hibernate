package com.hibernate.entity;

import java.util.Date;


/**
 * Heros entity. @author MyEclipse Persistence Tools
 */

public class Heros  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String nickname;
     private String sex;
     private String first;
     private String second;
     private String q;
     private String w;
     private String e;
     private String r;
     private String passivity;
     private String img;
     private Date birthday;


    // Constructors

    /** default constructor */
    public Heros() {
    }

	/** minimal constructor */
    public Heros(String name, String nickname, String sex) {
        this.name = name;
        this.nickname = nickname;
        this.sex = sex;
    }
    
    /** full constructor */
    public Heros(String name, String nickname, String sex, String first, String second, String q, String w, String e, String r, String passivity, String img, Date birthday) {
        this.name = name;
        this.nickname = nickname;
        this.sex = sex;
        this.first = first;
        this.second = second;
        this.q = q;
        this.w = w;
        this.e = e;
        this.r = r;
        this.passivity = passivity;
        this.img = img;
        this.birthday = birthday;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFirst() {
        return this.first;
    }
    
    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return this.second;
    }
    
    public void setSecond(String second) {
        this.second = second;
    }

    public String getQ() {
        return this.q;
    }
    
    public void setQ(String q) {
        this.q = q;
    }

    public String getW() {
        return this.w;
    }
    
    public void setW(String w) {
        this.w = w;
    }

    public String getE() {
        return this.e;
    }
    
    public void setE(String e) {
        this.e = e;
    }

    public String getR() {
        return this.r;
    }
    
    public void setR(String r) {
        this.r = r;
    }

    public String getPassivity() {
        return this.passivity;
    }
    
    public void setPassivity(String passivity) {
        this.passivity = passivity;
    }

    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
   








}