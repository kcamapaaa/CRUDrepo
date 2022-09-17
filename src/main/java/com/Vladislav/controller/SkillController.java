package com.Vladislav.controller;

import com.Vladislav.model.Skill;
import com.Vladislav.repository.SkillRepository;
import com.Vladislav.repository.gson.GsonSkillRepositoryImpl;

import java.util.List;

public class SkillController {
    private final SkillRepository skillRepository = new GsonSkillRepositoryImpl();

    public Skill createSkill(String name) {
        Skill skill = new Skill(name);
        return skillRepository.save(skill);
    }

    public void updateSkill(String name, Long id) {
        Skill skill = new Skill(name);
        skillRepository.update(skill, id);
    }

    public Skill getSkillById(Long id) {
        return skillRepository.getById(id);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.getAll();
    }

    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }


}
