package com.Vladislav.view;

import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);

    private final SkillView skillView = new SkillView();
    private final SpecialtyView specialtyView = new SpecialtyView();
    private final DeveloperView developerView = new DeveloperView();
    public void mainMenu() {
        while (true) {
            options();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                        skillView.skillOptions();
                        int skillOption = scanner.nextInt();
                    switch (skillOption) {
                        case 1 -> skillView.createSkill();
                        case 2 -> skillView.getAllSkills();
                        case 3 -> skillView.deleteSkillById();
                        case 4 -> skillView.getSkillById();
                        case 5 -> skillView.updateSkill();
                        default -> {
                            System.out.println("Unknown number.");
                            options();
                        }
                    }
                    break;
                case 2:
                        specialtyView.specialtyOptions();
                        int specialtyOption = scanner.nextInt();
                    switch (specialtyOption) {
                        case 1 -> specialtyView.createSpecialty();
                        case 2 -> specialtyView.getAllSpecialties();
                        case 3 -> specialtyView.deleteSpecialtyById();
                        case 4 -> specialtyView.getSpecialtyById();
                        case 5 -> specialtyView.updateSpecialty();
                        default -> {
                            System.out.println("Unknown number.");
                            options();
                        }
                    }
                    break;
                case 3:
                        developerView.developerOption();
                        int developerOption = scanner.nextInt();
                    switch (developerOption) {
                        case 1 -> developerView.createDeveloper();
                        case 2 -> developerView.getAllDevelopers();
                        case 3 -> developerView.deleteDeveloperById();
                        case 4 -> developerView.getDeveloperById();
                        case 5 -> developerView.updateDeveloper();
                    }
                    break;
                case 4:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid number");
            }
        }
    }
    public void options() {
        System.out.println("1.Operations with skills");
        System.out.println("2.Operations with specialties");
        System.out.println("3.Operations with developers");
        System.out.println("4.Exit");
    }
}
