package pl.wsiz.view;

import pl.wsiz.model.Student;
import pl.wsiz.repo.UserRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class StudentAddView extends UserDetailsView<Student>{
    Scanner scanner = new Scanner(System.in);

    public StudentAddView(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public Student createUser(String name, String surname, String email, String password, LocalDate dateOfBirth) {
        System.out.print("Podaj indeks studenta: ");
        long index = scanner.nextLong();

        return new Student(name, surname, email, password, dateOfBirth, index);

    }
}
