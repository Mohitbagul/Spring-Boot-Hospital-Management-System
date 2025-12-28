package com.mohit.demo.hospitalManagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mohit.demo.hospitalManagement.Entity.Patient;
import com.mohit.demo.hospitalManagement.Entity.type.BloodGroup;

import jakarta.transaction.Transactional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByNameContainingOrderByIdDesc(String query);

    @Query("Select p from Patient p where p.createdAt =?1")
    List<Patient> findByCreatedAt(@Param("createdAt") LocalDate createdAt);

    @Query("Select p from Patient p where p.bloodGroup =?1")
    List<Patient> DoesAPosExist(@Param("BloodGroup") BloodGroup bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional
    @Modifying
    @Query("Update Patient p set p.name = :name where p.id = :id")
    int UpdateNameById(@Param("name") String name, @Param("id") Long id);

    // Projection in JPQL we have to put new keyword and then the object reference
    // inplace of the * and give the contstructor for that DTO

    // Pagination
    @Query("select p from Patient p")
    Page<Patient> findAllPatients(Pageable pageable);

}
