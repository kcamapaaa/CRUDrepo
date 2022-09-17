package com.Vladislav.view;

import com.Vladislav.controller.SkillController;
import com.Vladislav.model.Skill;

import java.util.Scanner;

public class SkillView {
    private final SkillController skillController = new SkillController();

    private final Scanner scanner = new Scanner(System.in);


    public void createSkill() {
        System.out.println("Enter new skill name:");
        String name = scanner.nextLine();
        Skill createdSkill = skillController.createSkill(name);
        System.out.println("Created skill: " + createdSkill);
    }

    public void updateSkill() {
        System.out.println("Enter id you want to update: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter a new skill name: ");
        String name = scanner.nextLine();
        skillController.updateSkill(name, id);
    }

    public void getSkillById() {
        System.out.println("Enter id to get skill: ");
        Long id = scanner.nextLong();
        System.out.println(skillController.getSkillById(id));
    }

    public void getAllSkills() {
        System.out.println("All skills:");
        System.out.println(skillController.getAllSkills());
    }

    public void deleteSkillById() {
        System.out.println("Enter id to delete skill: ");
        long id = scanner.nextLong();
        skillController.deleteById(id);
        System.out.println("Successfully deleted!");
    }

    public void skillOptions() {
        System.out.println("1.Create a skill");
        System.out.println("2.Get all skills");
        System.out.println("3.Delete skill by ID");
        System.out.println("4.Get skill by ID");
        System.out.println("5.Update skill");
    }
}
