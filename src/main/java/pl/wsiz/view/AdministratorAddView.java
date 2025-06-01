package pl.wsiz.view;

import pl.wsiz.model.Administrator;
import pl.wsiz.repo.UserRepository;

import java.time.LocalDate;

public class AdministratorAddView extends UserDetailsView<Administrator>{

    public AdministratorAddView(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public Administrator createUser(String name, String surname, String email, String password, LocalDate dateOfBirth) {
        return new Administrator(name,surname,email,password,dateOfBirth);
    }
}
