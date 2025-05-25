package pl.wsiz.view;

import pl.wsiz.model.Student;
import pl.wsiz.model.Teacher;
import pl.wsiz.repo.UserRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class TeacherAddView {
    Scanner scanner = new Scanner(System.in);
    private UserRepository userRepository;

    public TeacherAddView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize(){
        System.out.print("Podaj imie nauczyciela: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko nauczyciela: ");
        String surname = scanner.nextLine();
        System.out.print("Podaj e-mail nauczyciela: ");
        String email = scanner.nextLine();
        System.out.print("Podaj hasło nauczyciela: ");
        String password = scanner.nextLine();
        System.out.print("Podaj date urodzenia nauczyciela w formacie yyyy-MM-dd: ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.print("Podaj tytuł naukowy nauczyciela: ");
        String academicDegree = scanner.nextLine();

        Teacher teacher = new Teacher(name, surname, email, password, dateOfBirth, academicDegree);
        userRepository.insert(teacher);
        System.out.println("Dodano do bazy");
    }
}
