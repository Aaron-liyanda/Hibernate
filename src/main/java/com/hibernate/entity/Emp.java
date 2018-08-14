package com.hibernate.entity;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer empNo;
	private String empName;
	private Double empSal;
	private Integer empAge;
	private Integer deptNo;
	
	private Dept dept;

	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer empNo, String empName, Double empSal, Integer empAge) {
		this.empNo = empNo;
		this.empName = empName;
		this.empSal = empSal;
		this.empAge = empAge;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", empSal=" + empSal + ", empAge=" + empAge
				+ ", deptNo=" + deptNo + ", dept=" + dept + "]";
	}
	
	


}