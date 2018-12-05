package pl.maciejapanowicz.SquareAccounts.models.forms;

import lombok.Data;

@Data
public class RegisterForm {
    private String email;
    private String emailRepeated;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String passwordRepeated;
}
