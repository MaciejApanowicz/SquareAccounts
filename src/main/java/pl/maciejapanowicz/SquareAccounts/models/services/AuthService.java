package pl.maciejapanowicz.SquareAccounts.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.maciejapanowicz.SquareAccounts.models.UserEntity;
import pl.maciejapanowicz.SquareAccounts.models.forms.RegisterForm;
import pl.maciejapanowicz.SquareAccounts.models.repositories.UserRepository;

@Service
public class AuthService {
    final UserRepository userRepository;

    @Autowired
    public AuthService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean tryLogin (String email, String password){
    return userRepository.existsByEmailAndPassword(email,password);
    }

    public boolean tryRegister (RegisterForm registerForm){
        if (userRepository.existsByEmail(registerForm.getEmail())){
            return false;
        }
        UserEntity userEntity = createEntityFromForm(registerForm);
        userRepository.save(userEntity);
        return true;
    }

    private UserEntity createEntityFromForm (RegisterForm registerForm){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerForm.getEmail());
        userEntity.setName(registerForm.getName());
        userEntity.setSurname(registerForm.getSurname());
        userEntity.setLogin(registerForm.getLogin());
        userEntity.setPassword(registerForm.getPassword());
        return userEntity;
    }
}