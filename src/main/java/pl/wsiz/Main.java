package pl.wsiz;

import pl.wsiz.model.Administrator;
import pl.wsiz.model.Student;
import pl.wsiz.model.Teacher;
import pl.wsiz.model.User;
import pl.wsiz.repo.FileUserRepository;
import pl.wsiz.view.AdministratorMenuView;
import pl.wsiz.view.LoginView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        FileUserRepository fileUserRepository = new FileUserRepository();
        LoginView loginView = new LoginView(fileUserRepository);

        User user1 = new Student("Ewa", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20), 164367);
        User user2 = new Teacher("Kamil", "Kowalski", "janek@gmail.com", "janKowal@13", LocalDate.of(1993, 12, 4), "Doctor");
        User user3 = new Administrator("Beata", "Ciecierzyca", "edyta_ciecz@gmail.com", "czieczEdyta@12", LocalDate.of(1995, 9, 16));

        fileUserRepository.insert(user1);
        fileUserRepository.insert(user2);
        fileUserRepository.insert(user3);

        loginView.login();

//        List<User> usersFromFile = fileUserRepository.findAll();


//        System.out.println("Liczba użytkowników: " + usersFromFile.size());
//        System.out.println("Zalogowano uzytkownika o e-mailu: " + loginView.getLoggedUser().getEmail());

        User loggedUser = loginView.getLoggedUser();
        if(loginView.getLoggedUser() instanceof Administrator){
            AdministratorMenuView administratorMenuView = new AdministratorMenuView(fileUserRepository);
            administratorMenuView.initialize();
        }

    }

    private static void printUser(User user) {
        System.out.println("Imie i nazwisko: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Adres e-mail: " + user.getEmail());

        String europeanDatePattern = "dd.MM.yyyy";
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
        System.out.println("Data urodzenia: " + user.getDateOfBirth().format(europeanDateFormatter));

        if (user instanceof Administrator) {
            System.out.println("Rola: Administrator");
        } else if (user instanceof Student) {
            System.out.println("Rola: Student");
        } else if (user instanceof Teacher) {
            System.out.println("Rola: Nauczyciel");
        } else {
            throw new RuntimeException("Nieznany typ użytkownika");
        }

    }
}