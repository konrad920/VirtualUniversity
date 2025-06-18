package pl.wsiz.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.wsiz.model.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class FileRepository <T>{
    private final String fileName;
    private final TypeReference<List<T>> typeReference;
    private final ObjectMapper objectMapper;

    public FileRepository(String fileName, TypeReference<List<T>> typeReference, ObjectMapper objectMapper) {
        this.fileName = fileName;
        this.typeReference = typeReference;
        this.objectMapper = objectMapper;
        objectMapper.findAndRegisterModules();
    }

    public void insert(T item) {
        List<T> items = findAll();
        items.add(item);

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            String json = objectMapper.writerFor(typeReference).writeValueAsString(items);
            fos.write(json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<T> findAll() {
        File file = new File(fileName);
        if (!file.exists()) {
            return new LinkedList<>();
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = fis.readAllBytes();
            return objectMapper.readValue(bytes, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
