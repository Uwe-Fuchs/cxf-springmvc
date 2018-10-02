package com.uwefuchs.demo.soap.apachecxf.endpoint;

import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.uwefuchs.demo.soap.apachecxf.marshalling.StudentMapAdapter;
import com.uwefuchs.demo.soap.apachecxf.model.Student;

@WebService
public interface Baeldung {
	public String hello(String name);

	public String helloStudent(Student student);

	@XmlJavaTypeAdapter(StudentMapAdapter.class)
	public Map<Integer, Student> getStudents();
}
