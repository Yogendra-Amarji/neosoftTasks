package com.yogi.security.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yogi.security.Entities.Project;
import com.yogi.security.Entities.Student;
import com.yogi.security.service.StudentServiceImpl;

@RestController
@RequestMapping("/student-portal/api")
public class StudentController {

	@Autowired
	StudentServiceImpl servicei;

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	@PostMapping("/Add")
	public @ResponseBody ResponseEntity<?> createStudent(@RequestParam("studentId") String studentId,
			@RequestParam("studentFirstName") String studentFirstName,
			@RequestParam("studentLastName") String studentLastName,
			@RequestParam("studentMobileNo") String studentMobileNo,
			@RequestParam("studentEmailAddress") String studentEmailAddress,
			@RequestParam("projectId") String projectId, @RequestParam("projectName") String projectName,
			@RequestParam("projectDuration") String projectDuration) {

		Project pro=new Project();
		pro.setProjectId(projectId);
		pro.setProjectName(projectName);
		pro.setProjectDuration(projectDuration);
		
		Student student=new Student();
		student.setStudentId(studentId);
		student.setStudentFirstName(studentFirstName);
		student.setStudentLastName(studentLastName);
		student.setStudentMobileNo(studentMobileNo);
		student.setStudentEmailAddress(studentEmailAddress);
		pro.setSTU(student);
		student.getProjects().add(pro);
		servicei.SaveStudent(student);
      return new ResponseEntity<>(HttpStatus.OK);
	}

	// get specific data
	@GetMapping("/get/{studentId}")
	public ResponseEntity<Object> getStudent(@PathVariable String studentId) {
		Student stu = servicei.SingleResult(studentId);
		log.info("data");
		if (stu != null) {
			return new ResponseEntity<Object>(stu, HttpStatus.OK);
		}//if
		else {
			return new ResponseEntity<Object>("student:" + studentId + "does not exits!", HttpStatus.NOT_FOUND);
		}//else

	}

	// Get all data
	@GetMapping("AllGet")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> student = servicei.ListOFStudent();
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}

}