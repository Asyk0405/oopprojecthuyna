package com.example.demo.services;

import com.example.demo.entities.MedicalProfessional;
import com.example.demo.repositories.MedicalProfessionalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicalProfessionalService {
    private final MedicalProfessionalRepository repository;
    public MedicalProfessionalService(MedicalProfessionalRepository repository) {
        this.repository = repository;
    }

    public List<MedicalProfessional> getAllMedicalProfessionals() {
        return repository.findAll();
    }

    @Transactional
    public MedicalProfessional saveMedicalProfessional(MedicalProfessional professional) {
        return repository.save(professional);
    }

    @Transactional
    public void deleteMedicalProfessional(Long id) {
        repository.deleteById(id);
    }
}