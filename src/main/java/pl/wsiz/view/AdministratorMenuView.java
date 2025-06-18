package pl.wsiz.view;

import pl.wsiz.model.Student;
import pl.wsiz.model.User;
import pl.wsiz.repo.FileSubjectRepository;
import pl.wsiz.repo.SubjectRepository;
import pl.wsiz.repo.TeacherRepository;
import pl.wsiz.repo.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdministratorMenuView {

    //public static final int MENU_EXIT = 5;
    private UserRepository userRepository;
    private SubjectRepository subjectRepository;

    public AdministratorMenuView(UserRepository userRepository, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
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
            }else if (chosen == AdministratorMenuItem.TEACHER_STATISTICS.getNumber()){

                TeacherRepository teacherRepository = new TeacherRepository();
                List<User> users = userRepository.findAll();
                teacherRepository.showStatisticks(teacherRepository.teacherStatisticks(users));
            } else if (chosen == AdministratorMenuItem.SUBJECT_LIST.getNumber()) {
                SubjectListView subjectListView = new SubjectListView(subjectRepository);
                subjectListView.showSubjectList();
            }
        } while (chosen != AdministratorMenuItem.EXIT.getNumber());
    }
}
