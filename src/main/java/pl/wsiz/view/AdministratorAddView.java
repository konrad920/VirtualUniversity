package pl.wsiz.view;

import pl.wsiz.model.Administrator;
import pl.wsiz.model.Student;
import pl.wsiz.repo.UserRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class AdministratorAddView {
    Scanner scanner = new Scanner(System.in);
    private UserRepository userRepository;

    public AdministratorAddView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize(){
        System.out.print("Podaj imie studenta: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko studenta: ");
        String surname = scanner.nextLine();
        System.out.print("Podaj e-mail studenta: ");
        String email = scanner.nextLine();
        System.out.print("Podaj hasło studenta: ");
        String password = scanner.nextLine();
        System.out.print("Podaj date urodzenia studenta w formacie yyyy-MM-dd: ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());

        Administrator administrator = new Administrator(name, surname, email, password, dateOfBirth);
        userRepository.insert(administrator);
        System.out.println("Dodano do bazy");
    }
}
