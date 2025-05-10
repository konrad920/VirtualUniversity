package pl.wsiz.model;

import java.time.LocalDate;

public class Teacher extends User{
    private String academicDegree;

    public Teacher(String firstName, String lastName, String email, String password, LocalDate dateOfBirth, String academicDegree){
        super(firstName,lastName,email,password,dateOfBirth);
        this.academicDegree = academicDegree;
    }

    public Teacher() {
    }

    public String getAcademicDegree() {
        return academicDegree;
    }
}
