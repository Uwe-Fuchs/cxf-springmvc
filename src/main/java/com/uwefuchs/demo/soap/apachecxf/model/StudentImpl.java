package com.uwefuchs.demo.soap.apachecxf.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Student")
public class StudentImpl implements Student {

	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public StudentImpl() {
		super();
	}

	public StudentImpl(String name) {
		this();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
