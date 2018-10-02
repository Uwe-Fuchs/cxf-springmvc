package com.uwefuchs.demo.soap.apachecxf.marshalling;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.uwefuchs.demo.soap.apachecxf.model.Student;
import com.uwefuchs.demo.soap.apachecxf.model.StudentMap;

public class StudentMapAdapter extends XmlAdapter<StudentMap, Map<Integer, Student>> {

	@Override
	public StudentMap marshal(Map<Integer, Student> boundMap) throws Exception {
		StudentMap valueMap = new StudentMap();

		for (Map.Entry<Integer, Student> boundEntry : boundMap.entrySet()) {
			StudentMap.StudentEntry valueEntry = new StudentMap.StudentEntry();
			valueEntry.setStudent(boundEntry.getValue());
			valueEntry.setId(boundEntry.getKey());
			valueMap.getEntries().add(valueEntry);
		}

		return valueMap;
	}

	@Override
	public Map<Integer, Student> unmarshal(StudentMap valueMap) throws Exception {
		Map<Integer, Student> boundMap = new LinkedHashMap<Integer, Student>();

		for (StudentMap.StudentEntry studentEntry : valueMap.getEntries()) {
			boundMap.put(studentEntry.getId(), studentEntry.getStudent());
		}

		return boundMap;
	}
}
