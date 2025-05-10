package pl.wsiz;

import org.junit.jupiter.api.Test;
import pl.wsiz.model.Administrator;
import pl.wsiz.model.Student;
import pl.wsiz.model.Teacher;
import pl.wsiz.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getFirstName() {
        User user1 = new Teacher("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20), "doctor");

        String firstName = user1.getFirstName();

        assertEquals("Adam", firstName);
    }

    @Test
    void getSecondName(){
        User user1 = new Student("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20), 164357);

        String lastName = user1.getLastName();

        assertEquals("Nowak", lastName);
    }

    @Test
    void getEmail(){
        User user1 = new Administrator("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20));

        String email = user1.getEmail();

        assertEquals("adam@onet.pl", email);
    }

    @Test
    void getDateOfBirth() {
        User user1 = new Administrator("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20));

        LocalDate dateOfBirth = user1.getDateOfBirth();

        assertEquals(LocalDate.of(1992,5,20), dateOfBirth);
    }
}