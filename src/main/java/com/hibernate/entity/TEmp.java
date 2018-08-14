package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TEmp entity. @author MyEclipse Persistence Tools
 */

public class TEmp implements java.io.Serializable {

	// Fields

	private Integer empId;
	private String empName;
	private Integer empAge;
	
	private Set<TProject> pros = new HashSet<TProject>();

	// Constructors

	/** default constructor */
	public TEmp() {
	}

	/** full constructor */
	public TEmp(String empName, Integer empAge) {
		this.empName = empName;
		this.empAge = empAge;
	}

	// Property accessors

	public Integer getEmpId() {
		return this.empId;
	}

	

	public Set<TProject> getPros() {
		return pros;
	}

	public void setPros(Set<TProject> pros) {
		this.pros = pros;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpAge() {
		return this.empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "TEmp [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + "]";
	}


	
	
}