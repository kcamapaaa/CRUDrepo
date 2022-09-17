package com.Vladislav.view;

import com.Vladislav.controller.DeveloperController;
import com.Vladislav.model.Developer;
import com.Vladislav.model.Skill;
import com.Vladislav.model.Specialty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {
    private final DeveloperController developerController = new DeveloperController();
    private final Scanner scanner = new Scanner(System.in);

    public void createDeveloper() {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter skills' id you want to add: (9999 to finish)");
        List<Skill> skillList = new ArrayList<>();
        while (true) {
            long id = scanner.nextLong();
            if(id == 9999) {
                break;
            } else {
                skillList.add(developerController.getSkillById(id));
            }
        }
        System.out.println("Enter specialties' id you want to add: ");
        long id = scanner.nextLong();
        Specialty specialty = developerController.getSpecialtyById(id);
        Developer createdDeveloper = developerController.createDeveloper(firstName, lastName, skillList, specialty);
        System.out.println("Created developer: " + createdDeveloper);
    }

    public void updateDeveloper() {
        System.out.println("Enter developer id you want to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter new first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter new last name: ");
        String lastName = scanner.nextLine();
        developerController.updateDeveloper(firstName, lastName, id);
    }

    public void getDeveloperById() {
        System.out.println("Enter id to get a developer: ");
        long id = scanner.nextLong();
        Developer idDeveloper = developerController.getDeveloperById(id);
        System.out.println(idDeveloper == null ? "No developer with this id." : idDeveloper);
    }

    public void getAllDevelopers() {
        System.out.println("All developers: ");
        System.out.println(developerController.getAllDevelopers());
    }

    public void deleteDeveloperById() {
        System.out.println("Enter id to delete developer: ");
        long id = scanner.nextLong();
        developerController.deleteById(id);
        System.out.println("Successfully deleted!");
    }

    public void developerOption() {
        System.out.println("1.Create a developer");
        System.out.println("2.Get all developers");
        System.out.println("3.Delete developer by ID");
        System.out.println("4.Get developer by ID");
        System.out.println("5.Update developer");
    }
}
