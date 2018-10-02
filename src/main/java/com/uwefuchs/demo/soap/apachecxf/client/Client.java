package com.uwefuchs.demo.soap.apachecxf.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.uwefuchs.demo.soap.apachecxf.endpoint.Baeldung;
import com.uwefuchs.demo.soap.apachecxf.model.StudentImpl;

public class Client {
	private static QName SERVICE_NAME = new QName("http://endpoint.apachecxf.soap.demo.uwefuchs.com/", "Baeldung");
	private static QName PORT_NAME = new QName("http://endpoint.apachecxf.soap.demo.uwefuchs.com/", "BaeldungPort");
	
	public static void main(String[] args) throws Exception {
		// create service
		Service service = Service.create(SERVICE_NAME);
        // Add a port to the Service
	    service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, "http://localhost:8080/my-first-cxf-springmvc/services/baeldung");
	    
	    // create SOAP-Proxy:
	    Baeldung baeldungProxy = service.getPort(PORT_NAME, Baeldung.class);
	    
	    
	    // service-calls:
	    System.out.println(baeldungProxy.hello("Baeldung"));
	    System.out.println(baeldungProxy.helloStudent(new StudentImpl("John Doe")));	    
	    System.out.println(baeldungProxy.helloStudent(new StudentImpl("Adam")));
	    System.out.println(baeldungProxy.helloStudent(new StudentImpl("Eve")));	         
	    System.out.println(baeldungProxy.getStudents());       
	}
}
