package com.Vladislav.repository.gson;

import com.Vladislav.model.Developer;
import com.Vladislav.model.Status;
import com.Vladislav.repository.DeveloperRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {
    private static final String DEVELOPERS_TO_FILE = "src/main/resources/developer.json";
    private final Gson GSON = new Gson();

    public void writeDevelopersToFile(List<Developer> list) {
        try (FileWriter fw = new FileWriter(DEVELOPERS_TO_FILE)) {
            GSON.toJson(list, fw);
        } catch (IOException e) {
            System.out.println("IN writeSpecialtiesToFile - exception occurred: " + e.getMessage());
        }
    }

    public List<Developer> getAllDevelopers() {
        try{
            Path filePath = Path.of(DEVELOPERS_TO_FILE);
            String content = Files.readString(filePath);
            return GSON.fromJson(content, new TypeToken<ArrayList<Developer>>(){ }.getType());
        } catch (IOException e) {
            System.out.println("IN getAllSpecialties - exception occurred: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Long generateNewId(List<Developer> list) {
        Developer maxSpeacialtyId = list.stream().max(Comparator.comparing(Developer::getId)).orElse(null);
        return Objects.nonNull(maxSpeacialtyId) ? maxSpeacialtyId.getId() + 1 : 1L;
    }
    @Override
    public Developer getById(Long id) {
        return getAllDevelopers().stream().filter(a -> a.getId().equals(id))
                .filter(a -> a.getStatus().equals(Status.ACTIVE)).findFirst().orElse(null);
    }

    @Override
    public List<Developer> getAll() {
        return getAllDevelopers();
    }

    @Override
    public Developer save(Developer developer) {
        List<Developer> currentList = getAllDevelopers();
        developer.setId(generateNewId(currentList));
        currentList.add(developer);
        writeDevelopersToFile(currentList);
        return developer;
    }

    @Override
    public void update(Developer developer, Long id) {
        List<Developer> currentList = getAllDevelopers();
        currentList.stream().filter(a -> a.getStatus().equals(Status.ACTIVE)).forEach(currentDeveloper -> {
           if(currentDeveloper.getId().equals(id)) {
               currentDeveloper.setFirstName(developer.getFirstName());
               currentDeveloper.setLastName(developer.getLastName());
           }
        });
        writeDevelopersToFile(currentList);
    }

    @Override
    public void deleteById(Long id) {
        List<Developer> currentList = getAllDevelopers();
        currentList.stream().filter(a -> a.getId().equals(id))
                .findFirst().ifPresent(a -> a.setStatus(Status.DELETED));
        writeDevelopersToFile(currentList);
    }
}
