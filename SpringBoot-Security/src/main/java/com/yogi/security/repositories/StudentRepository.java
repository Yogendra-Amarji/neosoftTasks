package com.yogi.security.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yogi.security.Entities.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student,String> {

}
