package com.example.demo.controllers;

import com.example.demo.entities.Patient;
import com.example.demo.services.PatientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/filter")
    public List<Patient> filterPatients(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) Integer age,
                                        @RequestParam(required = false) String gender) {
        return patientService.filterPatients(name, age, gender);
    }
}
