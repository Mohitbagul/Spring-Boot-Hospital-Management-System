package com.mohit.demo.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.Long;

import com.mohit.demo.hospitalManagement.Entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
    
}
