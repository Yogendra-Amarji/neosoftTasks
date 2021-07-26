package com.yogi.security.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	@Id
	private String projectId;
	private String projectName;
	private String projectDuration;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private Student STU;
}
