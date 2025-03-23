package pl.wsiz;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getFirstName() {
        User user1 = new User("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20));

        String firstName = user1.getFirstName();

        assertEquals("Adam", firstName);
    }

    @Test
    void getSecondName(){
        User user1 = new User("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20));

        String lastName = user1.getLastName();

        assertEquals("Nowak", lastName);
    }

    @Test
    void getEmail(){
        User user1 = new User("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20));

        String email = user1.getEmail();

        assertEquals("adam@onet.pl", email);
    }

    @Test
    void getDateOfBirth() {
        User user1 = new User("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20));

        LocalDate dateOfBirth = user1.getDateOfBirth();

        assertEquals(LocalDate.of(1992,5,20), dateOfBirth);
    }
}