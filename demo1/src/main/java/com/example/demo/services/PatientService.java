package com.example.demo.services;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Transactional
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Transactional
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> filterPatients(String name, Integer age, String gender) {
        return patientRepository.findAll().stream()
                .filter(p -> (name == null || p.getName().toLowerCase().contains(name.toLowerCase())))
                .filter(p -> (age == null || p.getAge() == age))
                .filter(p -> (gender == null || p.getGender().equalsIgnoreCase(gender)))
                .collect(Collectors.toList());
    }
}
