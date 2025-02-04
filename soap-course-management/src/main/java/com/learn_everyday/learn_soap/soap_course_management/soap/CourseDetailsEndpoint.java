package com.learn_everyday.learn_soap.soap_course_management.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.learn_everyday.courses.CourseDetails;
import com.learn_everyday.courses.GetCourseDetailsRequest;
import com.learn_everyday.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {
	
	// Have to create a Method
	// Input - Request Object [GetCourseDetailsRequest]
	// Output - Response Object [GetCourseDetailsResponse]
	
	// nameSpace = http://learn-everyday.com/courses
	// name = GetCourseDetailsRequest
	
	// @RequestPayload - To instruct Spring to read xml file request structure and convert it to Java Object.
	// @ResponsePayload - Vice Versa of above.
	
	@PayloadRoot(namespace = "http://learn-everyday.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("Microservices Course");
		courseDetails.setDescription("That would be a wonderful course");
		response.setCourseDetails(courseDetails);
		return response;
	}
	

}
