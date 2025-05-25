package pl.wsiz.view;

import pl.wsiz.model.Administrator;
import pl.wsiz.model.Student;
import pl.wsiz.model.Teacher;
import pl.wsiz.model.User;
import pl.wsiz.repo.UserRepository;

import java.util.Comparator;
import java.util.List;

public class UserListView {

    private UserRepository userRepository;

    public UserListView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize() {
        System.out.println("===================");
        System.out.println("Lista użytkowników");
        System.out.println("===================");
        System.out.println(withSpaces("Imie", 20) +
                withSpaces("Nazwisko", 20) +
                withSpaces("E-mail", 32) +
                withSpaces("Rola", 10));
        List<User> users = userRepository.findAll();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int lastNameCompared = o1.getLastName().compareToIgnoreCase(o2.getLastName());
                if (lastNameCompared == 0) {
                    return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
                } else {
                    return lastNameCompared;
                }
            }
        });
        for (User user : users) {
            String role;
            if (user instanceof Administrator) {
                role = "Administrator";
            } else if (user instanceof Student) {
                role = "Student";
            } else if (user instanceof Teacher) {
                role = "Nauczyciel";
            } else {
                throw new RuntimeException("Nieznany typ użytkownika");
            }
            System.out.println(withSpaces(user.getFirstName(), 20) +
                    withSpaces(user.getLastName(), 20) +
                    withSpaces(user.getEmail(), 32) +
                    withSpaces(role, 10));
        }
    }

    String withSpaces(String text, int maxLenght) {
        int amount = text.length();
        StringBuilder outcome = new StringBuilder(text);
        for (int i = 0; i < maxLenght - amount; i++) {
            outcome.append(" ");
        }
        return outcome.toString();
    }
}
