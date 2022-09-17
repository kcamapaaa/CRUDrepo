package com.Vladislav.repository.gson;

import com.Vladislav.model.Skill;
import com.Vladislav.repository.SkillRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GsonSkillRepositoryImpl implements SkillRepository {

    private static final String SKILLS_FILE_PATH = "src/main/resources/skills.json";
    private static final Gson GSON = new Gson();
    private void writeSkillsToFile(List<Skill> list) {
        try (FileWriter fw = new FileWriter(SKILLS_FILE_PATH)) {
            GSON.toJson(list, fw);
        } catch (IOException e) {
            System.out.println("IN writeSkillsToFile - exception occurred: " + e.getMessage());
        }
    }

    private List<Skill> getAllSkills() {
        try{
            Path filePath = Path.of(SKILLS_FILE_PATH);
            String content = Files.readString(filePath);
            return GSON.fromJson(content, new TypeToken<ArrayList<Skill>>() { }.getType());
        } catch (IOException e) {
            System.out.println("IN getAllSkills - exception occurred: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private Long generateNewId(List<Skill> skills) {
        Skill maxIdSkill = skills.stream().max(Comparator.comparing(Skill::getId)).orElse(null);
        return Objects.nonNull(maxIdSkill) ? maxIdSkill.getId() + 1 : 1L;
    }

    @Override
    public Skill getById(Long id) {
        return getAllSkills().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Skill> getAll() {
        return getAllSkills();
    }

    @Override
    public Skill save(Skill skill) {
        List<Skill> currentSkills = getAllSkills();
        skill.setId(generateNewId(currentSkills));
        currentSkills.add(skill);
        writeSkillsToFile(currentSkills);
        return skill;
    }

    @Override
    public void update(Skill skill, Long id) {
        List<Skill> currentSkills = getAllSkills();
        currentSkills.forEach(currentSkill -> {
            if(currentSkill.getId().equals(id)) {
                currentSkill.setName(skill.getName());
            }
        });
        writeSkillsToFile(currentSkills);
    }

    @Override
    public void deleteById(Long id) {
        List<Skill> currentSkills = getAllSkills();
        currentSkills.removeIf(s -> s.getId().equals(id));
        writeSkillsToFile(currentSkills);
    }
}
