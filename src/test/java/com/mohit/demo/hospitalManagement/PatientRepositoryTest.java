package com.mohit.demo.hospitalManagement;

import com.mohit.demo.hospitalManagement.Entity.Patient;
import com.mohit.demo.hospitalManagement.Entity.type.BloodGroup;
import com.mohit.demo.hospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest // loads in-memory DB and Spring Data JPA components
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    @DisplayName("Test saving a patient entity")
    void testSavePatient() {
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setBirthDate(LocalDate.of(1990, 5, 15));
        patient.setGender("Male");

        Patient savedPatient = patientRepository.save(patient);

        System.out.println("Saved patient: " + savedPatient);

        assertThat(savedPatient).isNotNull();
        assertThat(savedPatient.getId()).isGreaterThan(0);
        assertThat(savedPatient.getName()).isEqualTo("John Doe");
    }

    @Test
    @DisplayName("Test finding patient by ID")
    void testFindById() {
        Page<Patient> patientList = patientRepository.findAllPatients(
                PageRequest.of(0, 2, Sort.by("name")));

        patientList.getContent().forEach(System.out::println);

        // List<Patient> patientList =
        // patientRepository.findByBirthDateOrEmail(LocalDate.of(2003,7,29),"mohitmbagul@gmail.com");

        // List<Patient> patientList =
        // patientRepository.findByNameContainingOrderByIdDesc("Bagul");

        // List<Patient> patientList =
        // patientRepository.DoesAPosExist(BloodGroup.A_POS);

        // List<Patient> patientList =
        // patientRepository.findByBornAfterDate(LocalDate.of(1999,01,02));

        // List<Object[]> patientList = patientRepository.countEachBloodGroupType();

        // for(Object[] p : patientList){
        // System.out.println(p[0] +" "+ p[1]);
        // }

        // int rowsUpdated = patientRepository.UpdateNameById(
        // "Neha Singh" , 1L);

        // System.out.println(rowsUpdated);

        // for(Patient p : patientList){
        // System.out.println(p);
        // }
        //
        // System.out.println(patientList);

    }

    @Test
    @DisplayName("Test updating patient entity")
    void testUpdatePatient() {
        Patient patient = new Patient();
        patient.setName("Mike Smith");
        patient.setBirthDate(LocalDate.of(1985, 3, 10));
        patient.setGender("Male");

        Patient savedPatient = patientRepository.save(patient);

        savedPatient.setName("Michael Smith");
        Patient updatedPatient = patientRepository.save(savedPatient);

        System.out.println("Updated patient: " + updatedPatient);

        assertThat(updatedPatient.getName()).isEqualTo("Michael Smith");
    }

    @Test
    @DisplayName("Test deleting patient entity")
    void testDeletePatient() {
        Patient patient = new Patient();
        patient.setName("Anna Lee");
        patient.setBirthDate(LocalDate.of(2000, 12, 5));
        patient.setGender("Female");

        Patient savedPatient = patientRepository.save(patient);

        patientRepository.deleteById(savedPatient.getId());

        Optional<Patient> deletedPatient = patientRepository.findById(savedPatient.getId());

        System.out.println("Deleted patient fetched: " + deletedPatient);

        assertThat(deletedPatient).isEmpty();
    }
}
