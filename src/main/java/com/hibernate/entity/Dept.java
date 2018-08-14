package com.hibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable{
	
	private Integer deptNo;
	private String name;
	private String location;
	
	private Set<Emp> list = new HashSet();
	
	
	public Set<Emp> getList() {
		return list;
	}
	public void setList(Set<Emp> list) {
		this.list = list;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", name=" + name + ", location=" + location + "]";
	}
	

}
