package pl.wsiz;

import org.mindrot.jbcrypt.BCrypt;

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
        System.out.println("=============");
        System.out.println("EKRAN LOGOWANIA");

        System.out.print("Podaj adres e-mail: ");
        String mail = scanner.nextLine();

        System.out.print("Podaj hasło: ");
        String password = scanner.nextLine();

        List<User> users = userRepository.findAll();
        while (loginCounter > 1) {
            for (User user : users) {
                if (user.getEmail().equals(mail) && BCrypt.checkpw(password, user.getPassword())) {
                    this.loggedUser = user;
                    System.out.println(user.getPassword());
                    return;
                }else if (user.getEmail().equals(mail) && !BCrypt.checkpw(password, user.getPassword())){
                    System.out.println("Błędne hasło");
                    break;
                }else{
                    System.out.println("Nie ma takiego maila");
                    break;
                }
            }

            if (loggedUser == null) {
                loginCounter--;
                System.out.println("Logowanie nieudane, spróbuj ponownie, pozostało " + loginCounter + " prób");
                login();
            }
        }
    }
}
