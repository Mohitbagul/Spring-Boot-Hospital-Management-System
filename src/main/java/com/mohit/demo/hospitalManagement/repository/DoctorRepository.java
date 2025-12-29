package com.mohit.demo.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.demo.hospitalManagement.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long>{

}
