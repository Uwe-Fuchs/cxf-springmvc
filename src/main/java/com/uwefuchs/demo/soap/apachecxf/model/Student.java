package com.uwefuchs.demo.soap.apachecxf.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.uwefuchs.demo.soap.apachecxf.marshalling.StudentAdapter;

@XmlJavaTypeAdapter(StudentAdapter.class)
public interface Student {
	public String getName();
}
