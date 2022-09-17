package com.Vladislav.controller;

import com.Vladislav.model.Specialty;
import com.Vladislav.repository.SpecialtyRepository;
import com.Vladislav.repository.gson.GsonSpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyController {

    private final SpecialtyRepository specialtyRepository = new GsonSpecialtyRepositoryImpl();
    public Specialty createSpecialty(String name) {
        Specialty specialty = new Specialty(name);
        return specialtyRepository.save(specialty);
    }

    public void updateSpecialty(String name, Long id) {
        Specialty specialty = new Specialty(name);
        specialtyRepository.update(specialty, id);
    }

    public Specialty getSpecialtyById(Long id) {
        return specialtyRepository.getById(id);
    }

    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.getAll();
    }

    public void deletebyId(Long id) {
        specialtyRepository.deleteById(id);
    }
}
