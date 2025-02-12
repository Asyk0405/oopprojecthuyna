package com.example.demo.controllers;

import com.example.demo.entities.MedicalProfessional;
import com.example.demo.services.MedicalProfessionalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medical-professionals")
public class MedicalProfessionalController {
    private final MedicalProfessionalService service;
    public MedicalProfessionalController(MedicalProfessionalService service) {
        this.service = service;
    }
    @GetMapping
    public List<MedicalProfessional> getAllMedicalProfessionals() {
        return service.getAllMedicalProfessionals();
    }
    @PostMapping
    public MedicalProfessional saveMedicalProfessional(@RequestBody MedicalProfessional professional) {
        return service.saveMedicalProfessional(professional);
    }
}