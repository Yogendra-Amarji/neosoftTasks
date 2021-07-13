package com.neosoft.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "UserReg")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uid;
	
	@NotNull(message="Insert First Name")
	@Size(min=3, message="First Name have atleast 3 Characters")
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@NotNull(message="Insert Last Name")
	@Size(min=3, message="Last Name have atleast 3 Characters")
	@Column(name="LASTNAME")
	private String lastname;
	
	@NotNull
    @Email
	@Column(name="EMAIL")
    private String email;
	
	@NotNull
	@Size(min=6,max=6)
	@Column(name="PINCODE")
	private String pincode;
	
	@Column(name="PHNO")
    private String phno;
	
	@Column(name="STATUS")
    private String status;
    
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
    private Date dob;
	
	@Temporal(TemporalType.DATE)
	@Column(name="JOININGDATE")
	private Date joiningdate;
	
}