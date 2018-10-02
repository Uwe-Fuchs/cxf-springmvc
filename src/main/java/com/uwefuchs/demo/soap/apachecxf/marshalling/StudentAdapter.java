package com.uwefuchs.demo.soap.apachecxf.marshalling;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.uwefuchs.demo.soap.apachecxf.model.Student;
import com.uwefuchs.demo.soap.apachecxf.model.StudentImpl;

public class StudentAdapter extends XmlAdapter<StudentImpl, Student> {
	
	@Override
    public StudentImpl marshal(Student student) throws Exception {
		
        if (student instanceof StudentImpl) {
            return (StudentImpl) student;
        }
        
        return new StudentImpl(student.getName());
    }
 
	@Override
    public Student unmarshal(StudentImpl studentImpl) throws Exception {
        return studentImpl;
    }
}
