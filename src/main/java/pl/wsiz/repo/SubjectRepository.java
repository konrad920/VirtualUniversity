package pl.wsiz.repo;

import pl.wsiz.model.Subject;

import java.util.List;

public interface SubjectRepository {
    void insert(Subject subject);
    List<Subject> findAll();
}
