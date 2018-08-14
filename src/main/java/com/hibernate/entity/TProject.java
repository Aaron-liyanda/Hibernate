package com.hibernate.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * TProject entity. @author MyEclipse Persistence Tools
 */

public class TProject implements java.io.Serializable {

	// Fields

	private Integer proId;
	private String proName;
	private Integer proReward;
	private Timestamp proTime;
	
	private Set<TEmp> emps = new HashSet<TEmp>();

	// Constructors

	/** default constructor */
	public TProject() {
	}

	/** full constructor */
	public TProject(String proName, Integer proReward, Timestamp proTime) {
		this.proName = proName;
		this.proReward = proReward;
		this.proTime = proTime;
	}

	// Property accessors

	
	
	public Integer getProId() {
		return this.proId;
	}

	public Set<TEmp> getEmps() {
		return emps;
	}

	public void setEmps(Set<TEmp> emps) {
		this.emps = emps;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Integer getProReward() {
		return this.proReward;
	}

	public void setProReward(Integer proReward) {
		this.proReward = proReward;
	}

	public Timestamp getProTime() {
		return this.proTime;
	}

	public void setProTime(Timestamp proTime) {
		this.proTime = proTime;
	}

	@Override
	public String toString() {
		return "TProject [proId=" + proId + ", proName=" + proName + ", proReward=" + proReward + "]";
	}
	
	

}