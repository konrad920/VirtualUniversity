package pl.wsiz;

import java.util.List;

public interface UserRepository {

    void insert(User user);
    List<User> findAll();

}
