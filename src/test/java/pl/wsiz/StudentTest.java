package pl.wsiz;

import org.junit.jupiter.api.Test;
import pl.wsiz.model.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getStudentAlbum() {
        Student student = new Student("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20), 164367);

        long studentAlbum = student.getAlbumNumber();

        assertEquals(164367,studentAlbum);
    }
}