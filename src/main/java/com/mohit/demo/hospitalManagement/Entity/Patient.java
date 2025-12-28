package com.mohit.demo.hospitalManagement.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.mohit.demo.hospitalManagement.Entity.type.BloodGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable =  false, length = 40)
    private String name;

    @Column(name="birth_date")
    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;
    
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private BloodGroup bloodGroup;

}
