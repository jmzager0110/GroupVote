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
    @Column (unique = true, length = 10)
    private String userName;

    @NotNull
    @Column (unique = true, length = 10)
    private String displayName;
    //TODO: How can I change this to be optional?

    @NotNull
    @Column (length = 64)
    private String password;

    @NotNull
    @Column (name = "first_name")
    private String firstName;

    @NotNull
    @Column (name = "last_name")
    private String lastName;

    //TODO: If decide to use pwHash, then should I replace password field with this?
    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String email, String displayName, String userName, String password, String firstName, String lastName) {
        this.email = email;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String pwHash) {
        this.pwHash = pwHash;
    }

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getUserName().equals(user.getUserName()) && getDisplayName().equals(user.getDisplayName()) && getPassword().equals(user.getPassword()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getPwHash().equals(user.getPwHash());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmail(), getUserName(), getDisplayName(), getPassword(), getFirstName(), getLastName(), getPwHash());
    }

    //TODO: Finish/Update toString Method
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", userName=' " + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pwHash='" + pwHash + '\'' +
                '}';
    }
}
