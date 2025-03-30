package pl.wsiz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class FileUserRepository implements UserRepository {
    @Override
    public void insert(User user) {
        List<User> users = findAll();
        users.add(user);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            String json = objectMapper
                    .writerFor(new TypeReference<List<User>>(){})
                    .writeValueAsString(users);

            File file = new File("users.json");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(json.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            System.out.println(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        File file = new File("users.json");
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = fileInputStream.readAllBytes();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules();

            List list = objectMapper.readValue(bytes, new TypeReference<List<User>>() {
            });
fileInputStream.close();
            return list;
        } catch (FileNotFoundException e) {
            return new LinkedList<>();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
