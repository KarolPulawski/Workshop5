package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.validator.RegisterValidation;
import pl.coderslab.validator.SignInValidation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(groups = RegisterValidation.class)
    private String username;

    @NotBlank(groups = {RegisterValidation.class, SignInValidation.class})
    private String hashPassword;

    @NotNull(groups = RegisterValidation.class)
    private Boolean enabled;

    @NotBlank(groups = {RegisterValidation.class, SignInValidation.class})
    @Email
    @Column(unique = true)
    private String email;

    public User() {
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
