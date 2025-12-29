package com.mohit.demo.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.demo.hospitalManagement.Entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance,Long> {

}
