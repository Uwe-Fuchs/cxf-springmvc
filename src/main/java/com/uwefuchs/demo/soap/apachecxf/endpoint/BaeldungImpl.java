package com.uwefuchs.demo.soap.apachecxf.endpoint;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.jws.WebService;

import com.uwefuchs.demo.soap.apachecxf.model.Student;

@WebService(endpointInterface = "com.uwefuchs.demo.soap.apachecxf.endpoint.Baeldung")
public class BaeldungImpl implements Baeldung {

	private Map<Integer, Student> students = new LinkedHashMap<Integer, Student>();

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}

	@Override
	public String helloStudent(Student student) {
		students.put(students.size() + 1, student);
		return "Hello " + student.getName();
	}

	@Override
	public Map<Integer, Student> getStudents() {
		return students;
	}
}