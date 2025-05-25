package pl.wsiz.view;

import pl.wsiz.model.Student;
import pl.wsiz.repo.UserRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class AdministratorMenuView {

    //public static final int MENU_EXIT = 5;
    private UserRepository userRepository;

    public AdministratorMenuView(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize() {
        int chosen;
        do {
            System.out.println("===================");
            System.out.println("Menu Administratora");
            System.out.println("===================");

            AdministratorMenuItem[] items = AdministratorMenuItem.values();
            for (AdministratorMenuItem item : items) {
                System.out.println(item.getNumber() + " - " + item.getDescriptionPL());
            }

//            System.out.println("1 - lista użytkowników TODO");
//            System.out.println(MENU_EXIT + " - zamknij program");

            System.out.println("Co wybierasz?");
            Scanner scanner = new Scanner(System.in);
            chosen = scanner.nextInt();
            scanner.nextLine();

            if (chosen == AdministratorMenuItem.USER_LIST.getNumber()) {

                new UserListView(userRepository).initialize();

            } else if (chosen == AdministratorMenuItem.ADD_STUDENT.getNumber()) {

                StudentAddView studentAddView = new StudentAddView(userRepository);
                studentAddView.initialize();
            } else if (chosen == AdministratorMenuItem.ADD_TEACHER.getNumber()) {

                TeacherAddView teacherAddView = new TeacherAddView(userRepository);
                teacherAddView.initialize();
            }else if (chosen == AdministratorMenuItem.ADD_ADMINISTRATOR.getNumber()) {

                AdministratorAddView administratorAddView = new AdministratorAddView(userRepository);
                administratorAddView.initialize();
            }
        } while (chosen != AdministratorMenuItem.EXIT.getNumber());
    }
}
