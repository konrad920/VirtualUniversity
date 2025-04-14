package pl.wsiz;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorTest {

    @Test
    void getFirstName(){
        Administrator administrator = new Administrator("Edyta", "Ciecierzyca", "edyta_ciecz@gmail.com", "czieczEdyta@12", LocalDate.of(1995, 9, 16));

        String firstName = administrator.getFirstName();

        assertEquals("Edyta", firstName);
    }

    @Test
    void getLastName(){
        Administrator administrator = new Administrator("Edyta", "Ciecierzyca", "edyta_ciecz@gmail.com", "czieczEdyta@12", LocalDate.of(1995, 9, 16));

        String lastName = administrator.getLastName();

        assertEquals("Ciecierzyca", lastName);
    }

    @Test
    void getEmail(){
        Administrator administrator = new Administrator("Edyta", "Ciecierzyca", "edyta_ciecz@gmail.com", "czieczEdyta@12", LocalDate.of(1995, 9, 16));

        String mail = administrator.getEmail();

        assertEquals("edyta_ciecz@gmail.com", mail);
    }

    @Test
    void getDateOfBirth(){
        Administrator administrator = new Administrator("Edyta", "Ciecierzyca", "edyta_ciecz@gmail.com", "czieczEdyta@12", LocalDate.of(1995, 9, 16));

        LocalDate birthDate = administrator.getDateOfBirth();

        assertEquals(LocalDate.of(1995, 9,16), birthDate);
    }

    @Test
    void getPassword(){
        Administrator administrator = new Administrator("Edyta", "Ciecierzyca", "edyta_ciecz@gmail.com", "czieczEdyta@12", LocalDate.of(1995, 9, 16));

        String password = administrator.getPassword();

        assertTrue(BCrypt.checkpw("czieczEdyta@12", password));
    }
    
}