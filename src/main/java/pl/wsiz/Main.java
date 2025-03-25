package pl.wsiz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileUserRepository fileUserRepository = new FileUserRepository();
        LoginView loginView = new LoginView(fileUserRepository);

        User user1 = new User("Adam", "Nowak", "adam@onet.pl", "adam@340", LocalDate.of(1992, 5, 20));
        User user2 = new User("Jan", "Kowalski", "janek@gmail.com", "janKowal@13", LocalDate.of(1993,12,4));
        User user3 = new User("Edyta", "Ciecierzyca", "edyta_ciecz@gmail.com", "czieczEdyta@12", LocalDate.of(1995, 9,16));

        fileUserRepository.insert(user1);
        fileUserRepository.insert(user2);
        fileUserRepository.insert(user3);

        loginView.login();

        List<User> usersFromFile = fileUserRepository.findAll();


        System.out.println("Liczba użytkowników: " + usersFromFile.size());
        System.out.println("Zalogowano uzytkownika o e-mailu: " + loginView.getLoggedUser().getEmail());
    }

    private static void printUser(User user){
        System.out.println("Imie i nazwisko: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Adres e-mail: " + user.getEmail());

        String europeanDatePattern = "dd.MM.yyyy";
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
        System.out.println("Data urodzenia: " + user.getDateOfBirth().format(europeanDateFormatter));
    }
}