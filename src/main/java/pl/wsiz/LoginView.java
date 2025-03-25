package pl.wsiz;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginView {
    private UserRepository userRepository;

    private User loggedUser;
    private int loginCounter = 5;


    public LoginView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        List<User> users = userRepository.findAll();

        System.out.println("=============");
        System.out.println("EKRAN LOGOWANIA");

        System.out.print("Podaj adres e-mail: ");
        String mail = scanner.nextLine();

        System.out.print("Podaj hasło: ");
        String password = scanner.nextLine();
        while (loginCounter > 1) {
            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(mail)
                        && BCrypt.checkpw(password, user.getPassword())) {
                    this.loggedUser = user;
                    System.out.println("Logowanie przebiegło poprawnie");
                    loginCounter = 0;
                }
            }

            if (loggedUser == null) {
                loginCounter--;
                System.out.println("Logowanie nieudane, spróbuj ponownie, pozostało: " + loginCounter + " prób");
                login();
            }
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
