package com.hibernate.entity;

import java.util.Date;

/**
 * HqlTest entity. @author MyEclipse Persistence Tools
 */

public class HqlTest implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer age;
	private Date birthday;

	// Constructors

	/** default constructor */
	public HqlTest() {
	}

	/** full constructor */
	public HqlTest(String name, Integer age, Date birthday) {
		this.name = name;
		this.age = age;
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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}