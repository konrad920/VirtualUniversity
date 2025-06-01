package pl.wsiz.view;

import pl.wsiz.model.Teacher;
import pl.wsiz.repo.UserRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class TeacherAddView extends UserDetailsView<Teacher>{
    Scanner scanner = new Scanner(System.in);

    public TeacherAddView(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public Teacher createUser(String name, String surname, String email, String password, LocalDate dateOfBirth) {
        System.out.print("Podaj tytuł naukowy nauczyciela: ");
        String academicDegree = scanner.nextLine();
        return new Teacher(name,surname,email,password,dateOfBirth,academicDegree);
    }
}
