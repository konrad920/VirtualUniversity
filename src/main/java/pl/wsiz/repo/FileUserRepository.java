package pl.wsiz.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.wsiz.model.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class FileUserRepository extends FileRepository<User> implements UserRepository {

    public FileUserRepository(String fileName, TypeReference typeReference, ObjectMapper objectMapper) {
        super(fileName, typeReference, objectMapper);
    }
}
