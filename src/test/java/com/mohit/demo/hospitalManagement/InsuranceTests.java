package com.mohit.demo.hospitalManagement;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mohit.demo.hospitalManagement.Entity.Appointment;
import com.mohit.demo.hospitalManagement.Entity.Insurance;
import com.mohit.demo.hospitalManagement.Entity.Patient;
import com.mohit.demo.hospitalManagement.service.AppointmentService;
import com.mohit.demo.hospitalManagement.service.InsuranceService;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;


    @Autowired
    private AppointmentService appointmentService;
    
    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder().policyNumber("HDFC_1234").
        provider("HDFC").
        validUntil(LocalDate.of(2030, 12, 12)).
        build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 2L);
        System.out.println(patient);

        Patient newPatient = insuranceService.disassociteInsuranceFromPatient(patient.getId());

        System.out.println(newPatient);
    }


    @Test 
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder().
        appointmentTime(LocalDateTime.of(2025,12,29,14,00,00)).
        reason("cancer").build();
        
        
        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);

        System.out.println(newAppointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 1L);
        System.out.println(updatedAppointment);
    
    }
}
