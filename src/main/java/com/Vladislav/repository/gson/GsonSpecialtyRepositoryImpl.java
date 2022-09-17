package com.Vladislav.repository.gson;

import com.Vladislav.model.Specialty;
import com.Vladislav.repository.SpecialtyRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {

     private static final String SPECIALTIES_FILE_PATH = "src/main/resources/specialties.json";
     private static final Gson GSON = new Gson();

    public void writeSpecialtiesToFile(List<Specialty> list) {
        try (FileWriter fw = new FileWriter(SPECIALTIES_FILE_PATH)) {
            GSON.toJson(list, fw);
        } catch (IOException e) {
            System.out.println("IN writeSpecialtiesToFile - exception occurred: " + e.getMessage());
        }
    }

    public List<Specialty> getAllSpecialties() {
        try{
            Path filePath = Path.of(SPECIALTIES_FILE_PATH);
            String content = Files.readString(filePath);
            return GSON.fromJson(content, new TypeToken<ArrayList<Specialty>>() { }.getType());
        } catch (IOException e) {
            System.out.println("IN getAllSpecialties - exception occurred: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Long generateNewId(List<Specialty> list) {
        Specialty maxSpeacialtyId = list.stream().max(Comparator.comparing(Specialty::getId)).orElse(null);
        return Objects.nonNull(maxSpeacialtyId) ? maxSpeacialtyId.getId() + 1 : 1L;
    }
    @Override
    public Specialty getById(Long id) {
        return getAllSpecialties().stream().filter(a -> a.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Specialty> getAll() {
        return getAllSpecialties();
    }

    @Override
    public Specialty save(Specialty specialty) {
        List<Specialty> currentSpecialties = getAllSpecialties();
        specialty.setId(generateNewId(currentSpecialties));
        currentSpecialties.add(specialty);
        writeSpecialtiesToFile(currentSpecialties);
        return specialty;
    }

    @Override
    public void update(Specialty specialty, Long id) {
        List<Specialty> currentSkills = getAllSpecialties();
        currentSkills.forEach(currentSpecialty -> {
            if(currentSpecialty.getId().equals(id)) {
                currentSpecialty.setName(specialty.getName());
            }
        });
        writeSpecialtiesToFile(currentSkills);
    }

    @Override
    public void deleteById(Long id) {
        List<Specialty> currentSpecialties = getAllSpecialties();
        currentSpecialties.removeIf(a -> a.getId().equals(id));
        writeSpecialtiesToFile(currentSpecialties);
    }
}
