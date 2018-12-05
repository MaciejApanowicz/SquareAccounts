package pl.maciejapanowicz.SquareAccounts.models.services;

import org.springframework.stereotype.Service;
import pl.maciejapanowicz.SquareAccounts.models.forms.RegisterForm;

@Service
public class AuthService {

    //todo dodać klasy odpowiedzialne za baze danych

    public boolean tryLogin (String login, String password){
    return false; //todo zrobić logikę do logowania
    }

    public boolean tryRegister (RegisterForm registerForm){
        return false; //todo zrobić logikę do rejestracji
    }
}
