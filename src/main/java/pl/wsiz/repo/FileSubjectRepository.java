package pl.wsiz.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.wsiz.model.Subject;

import java.util.List;

public class FileSubjectRepository extends FileRepository<Subject> implements SubjectRepository{
    public FileSubjectRepository(String fileName, TypeReference<List<Subject>> typeReference, ObjectMapper objectMapper) {
        super(fileName, typeReference, objectMapper);
    }
}
