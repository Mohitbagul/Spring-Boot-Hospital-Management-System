package com.mohit.demo.hospitalManagement.service;

import org.springframework.stereotype.Service;

import com.mohit.demo.hospitalManagement.Entity.Appointment;
import com.mohit.demo.hospitalManagement.Entity.Doctor;
import com.mohit.demo.hospitalManagement.Entity.Patient;
import com.mohit.demo.hospitalManagement.repository.AppointmentRepository;
import com.mohit.demo.hospitalManagement.repository.DoctorRepository;
import com.mohit.demo.hospitalManagement.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(patientId).orElseThrow();

        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appoinment should not have Id");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointment().add(appointment);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(doctorId).orElseThrow();

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);//this will automically call the update, becaurse it is dirty now

        doctor.getAppointments().add(appointment); // just for birectional consistency

        return appointment;
    }
}
