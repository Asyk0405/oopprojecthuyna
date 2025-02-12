package com.example.demo.repositories;

import com.example.demo.entities.MedicalProfessional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalProfessionalRepository extends JpaRepository<MedicalProfessional, Long> {
}