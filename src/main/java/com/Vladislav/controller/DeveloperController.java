package com.Vladislav.controller;

import com.Vladislav.model.Developer;
import com.Vladislav.model.Skill;
import com.Vladislav.model.Specialty;
import com.Vladislav.repository.DeveloperRepository;
import com.Vladislav.repository.gson.GsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {
    private final DeveloperRepository developerRepository = new GsonDeveloperRepositoryImpl();
    private final SkillController skillController = new SkillController();
    private final SpecialtyController specialtyController = new SpecialtyController();

    public Developer createDeveloper(String firstName, String lastName, List<Skill> listSkills, Specialty specialty) {
        Developer developer = new Developer(firstName, lastName, listSkills, specialty);
        return developerRepository.save(developer);
    }

    public void updateDeveloper(String firstName, String lastName, Long id) {
        Developer developer = new Developer(firstName, lastName);
        developerRepository.update(developer, id);
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.getById(id);
    }

    public List<Developer> getAllDevelopers() {
        return developerRepository.getAll();
    }

    public void deleteById(Long id) {
        developerRepository.deleteById(id);
    }

    public Skill getSkillById(Long id) {
        return skillController.getSkillById(id);
    }

    public Specialty getSpecialtyById(Long id) {
        return specialtyController.getSpecialtyById(id);
    }
}
