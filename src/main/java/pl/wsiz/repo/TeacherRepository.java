package pl.wsiz.repo;

import pl.wsiz.model.Teacher;
import pl.wsiz.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherRepository {
    private UserRepository fileUserRepository;

    public TeacherRepository(UserRepository fileUserRepository) {
        this.fileUserRepository = fileUserRepository;
    }

    public HashMap<String, Integer> teacherStatisticks(){
        List<User> users = fileUserRepository.findAll();
        List<Teacher> teachers = new ArrayList<>();

        for(User user : users){
            if(user instanceof Teacher){
                teachers.add((Teacher) user);
            }
        }

        HashMap<String, Integer> statisticks = new HashMap<>();
        for(Teacher teacher : teachers){
            String academicDegree = teacher.getAcademicDegree();
            statisticks.put(academicDegree, statisticks.getOrDefault(academicDegree, 0) + 1);
        }

        return statisticks;
    }

    public void showStatisticks(HashMap<String, Integer> statisticks){
        for(Map.Entry<String, Integer> entry : statisticks.entrySet()){
            System.out.println("Stopień " + entry.getKey() + " występuje: " + entry.getValue() + " razy");
        }
    }
}
