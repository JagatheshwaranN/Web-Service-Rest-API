package com.learn_everyday.learn_soap.soap_course_management.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.learn_everyday.courses.CourseDetails;
import com.learn_everyday.courses.GetAllCourseDetailsRequest;
import com.learn_everyday.courses.GetAllCourseDetailsResponse;
import com.learn_everyday.courses.GetCourseDetailsRequest;
import com.learn_everyday.courses.GetCourseDetailsResponse;
import com.learn_everyday.learn_soap.soap_course_management.soap.bean.Course;
import com.learn_everyday.learn_soap.soap_course_management.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService sevice;
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
		
		//Update of actual code
		Course course = sevice.findById(request.getId());
		
		return mapCourseDetails(course);
	}
	
	@PayloadRoot(namespace = "http://learn-everyday.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		
		//Update of actual code
		List<Course> course = sevice.findAll();
		return mapAllCourseDetails(course);
	}
	
	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		return response;
	}
	
	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for(Course course : courses) {
			CourseDetails mapCourseDetail = mapCourse(course);
			response.getCourseDetails().add(mapCourseDetail);
		}
		return response;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}

	

}
