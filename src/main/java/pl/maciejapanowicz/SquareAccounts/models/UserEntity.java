package pl.maciejapanowicz.SquareAccounts.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String surname;
    @JsonIgnore
    private String login;
    @JsonIgnore
    private String password;
}
