package com.example.demo.services;

import com.example.demo.entities.Hospital;
import com.example.demo.repositories.HospitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HospitalService {
    private final HospitalRepository repository;
    public HospitalService(HospitalRepository repository) {
        this.repository = repository;
    }

    public List<Hospital> getAllHospitals() {
        return repository.findAll();
    }

    @Transactional
    public Hospital saveHospital(Hospital hospital) {
        return repository.save(hospital);
    }

    @Transactional
    public void deleteHospital(Long id) {
        repository.deleteById(id);
    }
}