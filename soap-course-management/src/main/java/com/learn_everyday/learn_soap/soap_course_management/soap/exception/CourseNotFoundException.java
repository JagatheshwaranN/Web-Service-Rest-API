package com.learn_everyday.learn_soap.soap_course_management.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

//@SoapFault(faultCode = FaultCode.CLIENT)
@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://learn-everyday.com/courses}001_COURSE_NOT_FOUND")
public class CourseNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1564053100248230516L;

	public CourseNotFoundException(String message) {
		super(message);
	}

}
