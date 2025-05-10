package pl.wsiz;

import org.junit.jupiter.api.Test;
import pl.wsiz.model.Teacher;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void getTeacherDegree() {
        Teacher teacher = new Teacher("Jan", "Kowalski", "janek@gmail.com", "janKowal@13", LocalDate.of(1993, 12, 4), "Doctor");

        String teacherDegree = teacher.getAcademicDegree();

        assertEquals("Doctor", teacherDegree);
    }
}