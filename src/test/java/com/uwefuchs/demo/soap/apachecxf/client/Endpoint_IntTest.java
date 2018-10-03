package com.uwefuchs.demo.soap.apachecxf.client;

import static org.junit.Assert.assertEquals;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.Before;
import org.junit.Test;

import com.uwefuchs.demo.soap.apachecxf.endpoint.Baeldung;
import com.uwefuchs.demo.soap.apachecxf.model.Student;
import com.uwefuchs.demo.soap.apachecxf.model.StudentImpl;

public class Endpoint_IntTest {
	private static QName SERVICE_NAME = new QName("http://endpoint.apachecxf.soap.demo.uwefuchs.com/", "Baeldung");
	private static QName PORT_NAME = new QName("http://endpoint.apachecxf.soap.demo.uwefuchs.com/", "BaeldungPort");
	
	private Baeldung baeldungProxy;
	
	@Before
	public void setUp() {
		// create service
		Service service = Service.create(SERVICE_NAME);
        // Add a port to the Service
	    service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, "http://localhost:8080/cxf-webmvc/services/baeldung");
	    
	    // create SOAP-Proxy:
	    baeldungProxy = service.getPort(PORT_NAME, Baeldung.class);
	}

	@Test
	public void whenUsingRegisterMethod_thenCorrect() {
	    Student student1 = new StudentImpl("Adam");
	    Student student2 = new StudentImpl("Eve");
	    String student1Response = baeldungProxy.helloStudent(student1);
	    String student2Response = baeldungProxy.helloStudent(student2);
	 
	    assertEquals("Hello Adam", student1Response);
	    assertEquals("Hello Eve", student2Response);
	}
	
	@Test
	public void whenUsingHelloMethod_thenCorrect() {
	    String response = baeldungProxy.hello("John Doe");
	    assertEquals("Hello John Doe", response);
	}
}
