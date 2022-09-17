package com.Vladislav.model;

import java.util.List;

public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Skill> skillList;
    private Specialty specialty;
    private Status status;

    public Developer(String firstName, String lastName, List<Skill> skillList, Specialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skillList = skillList;
        this.specialty = specialty;
        this.status = Status.ACTIVE;
    }

    public Developer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skillList=" + skillList +
                ", specialty=" + specialty +
                ", status=" + status +
                '}';
    }
}
