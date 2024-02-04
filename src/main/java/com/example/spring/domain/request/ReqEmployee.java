package com.example.spring.domain.request;


public class ReqEmployee {
    private Long id;
    private String firstName;
    private String lastName;
    private int gender;
    private String position;
    private String workSchedule;
    private String yearOfBirth;
    private String graduatedUniversity;
    private Long companyId;
    private Long taskId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setGraduatedUniversity(String graduatedUniversity) {
        this.graduatedUniversity = graduatedUniversity;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public int getGender() {
        return gender;
    }

    public String getPosition() {
        return position;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGraduatedUniversity() {
        return graduatedUniversity;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getTaskId() {
        return taskId;
    }
}

