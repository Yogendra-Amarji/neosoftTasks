package com.yogi.security.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@NotBlank(message = "StudentId is Missing")
	@Size(max = 10)
	private String studentId;

	@NotBlank(message = "StudentFirstName is Missing")
	@Size(max = 16)
	private String studentFirstName;

	@NotBlank(message = "StudentLastName is Missing")
	@Size(max = 16)
	private String studentLastName;

	@NotBlank(message = "StudentMobileNo is Missing")
	@Size(max = 13)
	private String studentMobileNo;

	@NotBlank(message = "StudentEmailAddress is Missing")
	private String studentEmailAddress;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "STU" , fetch = FetchType.LAZY)
	private Set<Project> projects = new HashSet<Project>();

}
