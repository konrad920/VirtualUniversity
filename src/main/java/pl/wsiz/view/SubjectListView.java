package pl.wsiz.view;

import pl.wsiz.model.Subject;
import pl.wsiz.model.User;
import pl.wsiz.repo.SubjectRepository;

import java.util.Comparator;
import java.util.List;

public class SubjectListView {
    private SubjectRepository subjectRepository;

    public SubjectListView(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void showSubjectList() {
        System.out.println("===================");
        System.out.println("Lista przedmiotów");
        System.out.println("===================");
        System.out.println(withSpaces("Nazwa", 20) +
                withSpaces("Punkty ECTS", 20));

        List<Subject> subjects = subjectRepository.findAll();
        subjects.sort(new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                int nameCompared = o1.getName().compareToIgnoreCase(o2.getName());
                if (nameCompared == 0) {
                    return 0;
                } else {
                    return nameCompared;
                }
            }
        });


        for (Subject subject : subjects) {
            String subjectName = subject.getName();
            int subjectECTSPoints = subject.getEctsPoints();
            System.out.println(withSpaces(subjectName, 30)+
                                withSpaces(String.valueOf(subjectECTSPoints), 30));
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
