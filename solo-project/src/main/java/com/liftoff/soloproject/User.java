package com.liftoff.soloproject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class User extends AbstractEntity {

    @NotNull
    @Column(unique = true, length = 45)
    private String email;

    @NotNull
    @Column (length = 64)
    private String password;

    @NotNull
    @Column (name = "first_name")
    private String firstName;

    @NotNull
    @Column (name = "last_name")
    private String lastName;

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmail(), getPassword(), getFirstName(), getLastName());
    }

    //TODO: Finish/Update toString Method, it shouldn't have password, right?
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
