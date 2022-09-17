package com.Vladislav.view;

import com.Vladislav.controller.SpecialtyController;
import com.Vladislav.model.Specialty;

import java.util.Scanner;

public class SpecialtyView {
    private final SpecialtyController specialtyController = new SpecialtyController();
    private final Scanner scanner = new Scanner(System.in);

    public void createSpecialty() {
        System.out.println("Enter new specialty name: ");
        String name = scanner.nextLine();
        Specialty specialty = specialtyController.createSpecialty(name);
        System.out.println("Specialty " + specialty + " was created");
    }

    public void updateSpecialty() {
        System.out.println("Enter specialty id you want to update");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        specialtyController.updateSpecialty(name, id);
    }

    public void getSpecialtyById() {
        System.out.println("Enter id to get specialty: ");
        Long id = scanner.nextLong();
        System.out.println(specialtyController.getSpecialtyById(id));
    }

    public void getAllSpecialties() {
        System.out.println("All specialties:");
        System.out.println(specialtyController.getAllSpecialties());
    }

    public void deleteSpecialtyById() {
        System.out.println("Enter id to delete specialty: ");
        long id = scanner.nextLong();
        specialtyController.deletebyId(id);
        System.out.println("Successfully deleted");
    }

    public void specialtyOptions() {
        System.out.println("1.Create a specialty");
        System.out.println("2.Get all specialty");
        System.out.println("3.Delete specialty by ID");
        System.out.println("4.Get specialty by ID");
        System.out.println("5.Update specialty");
    }
}
