package com.sts.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entity.MyStudent;

public interface MyStudentRepo extends JpaRepository<MyStudent, Integer>{

}
