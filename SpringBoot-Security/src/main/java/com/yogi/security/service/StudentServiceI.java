package com.yogi.security.service;

import java.util.List;

import com.yogi.security.Entities.Student;

public interface StudentServiceI {
	public String SaveStudent(Student stu);
	public List<Student> ListOFStudent();
	public Student SingleResult(String studentId);

}
