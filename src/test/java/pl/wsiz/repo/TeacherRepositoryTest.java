package pl.wsiz.repo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.wsiz.model.Administrator;
import pl.wsiz.model.Student;
import pl.wsiz.model.Teacher;
import pl.wsiz.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TeacherRepositoryTest {

    @ParameterizedTest
    @CsvSource({"Doctor,3"})
    void getTeachersStatisticks (String degree, int value){
        TeacherRepository teacherRepository = new TeacherRepository();

        List<User> users = new ArrayList<>();
        users.add(new Student("Ewa", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20), 164367));
        users.add(new Student("Jan", "Sambor", "sambor_jan@onet.pl", "sam45jan@", LocalDate.of(1992, 6, 12), 135572));
        users.add(new Teacher("Kamil", "Kowalski", "janek@gmail.com", "janKowal@13", LocalDate.of(1993, 12, 4), "Doctor"));
        users.add(new Teacher("Józef", "Anakin", "jozekanakin@wp.pl", "anek1234@", LocalDate.of(1978, 5, 19), "Profesor"));
        users.add(new Teacher("Ewelina", "Kicwak", "kicwaczek@gmail.com", "ewel$$12kic", LocalDate.of(1995, 8, 24), "Doctor"));
        users.add(new Administrator("Beata", "Ciecierzyca", "edyta_ciecz@gmail.com", "czieczEdyta@12", LocalDate.of(1995, 9, 16)));
        users.add(new Administrator("Kacper", "Cma", "cma_kacper@gmail.com", "##cma@@kacper", LocalDate.of(1988, 4, 2)));
        users.add(new Teacher("Konrad", "Kacapan", "kkacap@gmail.com", "@kacap@13", LocalDate.of(1995, 9, 15), "Magister"));
        users.add(new Teacher("Miłosz", "Pazdan", "pazdanekmily@onet.pl", "pazdanekmily!2", LocalDate.of(1996, 7, 3), "Magister"));
        users.add(new Teacher("Ela", "Mamska", "mamskaela@gmail.com", "el@13mam", LocalDate.of(1992, 3, 8), "Doctor"));

        HashMap<String, Integer> teacherStatisticks = teacherRepository.teacherStatisticks(users);
        int liczba = teacherStatisticks.get(degree);
        assertEquals(value, liczba);
    }
}