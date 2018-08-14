package com.hibernate.entity;

/**
 * TDAreainfo entity. @author MyEclipse Persistence Tools
 */

public class TDAreainfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Short arealevel;
	private Integer parentId;

	// Constructors

	/** default constructor */
	public TDAreainfo() {
	}

	/** minimal constructor */
	public TDAreainfo(String name, Short arealevel) {
		this.name = name;
		this.arealevel = arealevel;
	}

	/** full constructor */
	public TDAreainfo(String name, Short arealevel, Integer parentId) {
		this.name = name;
		this.arealevel = arealevel;
		this.parentId = parentId;
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

	public Short getArealevel() {
		return this.arealevel;
	}

	public void setArealevel(Short arealevel) {
		this.arealevel = arealevel;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}