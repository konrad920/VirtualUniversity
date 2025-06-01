package pl.wsiz.view;

import pl.wsiz.model.Administrator;
import pl.wsiz.model.User;
import pl.wsiz.repo.UserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class UserDetailsView<T extends User> {
    Scanner scanner = new Scanner(System.in);
    UserRepository userRepository;

    public UserDetailsView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize() {
        System.out.print("Podaj imie użytkownika: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko użytkownika: ");
        String surname = scanner.nextLine();

        String email;
        while (true) {
            System.out.print("Podaj e-mail użytkownika: ");
            email = scanner.nextLine();
            if(email.contains("@")){
                break;
            }else {
                System.out.println("Nie poprawny email spróbuj jeszcze raz");
            }
        }

        System.out.print("Podaj hasło użytkownika: ");
        String password = scanner.nextLine();

        LocalDate dateOfBirth = null;
        while (dateOfBirth == null){
            System.out.print("Podaj date urodzenia użytkownika w formacie yyyy-MM-dd: ");
            try{
                dateOfBirth = LocalDate.parse(scanner.nextLine());
            }catch (DateTimeParseException e){
                System.out.println("Nieprawidłowy format daty, spróbuj jeszcze raz");
            }
        }

        T user = createUser(name, surname, email, password, dateOfBirth);
        userRepository.insert(user);
        System.out.println("Użytkownik dodany");
    }

    public abstract T createUser(String name, String surname, String email, String password, LocalDate dateOfBirth);
}
