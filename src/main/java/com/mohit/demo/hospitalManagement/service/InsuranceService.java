package com.mohit.demo.hospitalManagement.service;

import org.springframework.stereotype.Service;

import com.mohit.demo.hospitalManagement.Entity.Insurance;
import com.mohit.demo.hospitalManagement.Entity.Patient;
import com.mohit.demo.hospitalManagement.repository.InsuranceRepository;
import com.mohit.demo.hospitalManagement.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with Id"+patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //bidirectional conssistency maintenance

        return patient;
    }

    @Transactional
    public Patient disassociteInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null);
        return patient;
    }
}
