package com.mohit.demo.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.demo.hospitalManagement.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
