package com.example.demo.controllers;

import com.example.demo.entities.Hospital;
import com.example.demo.services.HospitalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    private final HospitalService service;
    public HospitalController(HospitalService service) {
        this.service = service;
    }
    @GetMapping
    public List<Hospital> getAllHospitals() {
        return service.getAllHospitals();
    }
    @PostMapping
    public Hospital saveHospital(@RequestBody Hospital hospital) {
        return service.saveHospital(hospital);
    }
}