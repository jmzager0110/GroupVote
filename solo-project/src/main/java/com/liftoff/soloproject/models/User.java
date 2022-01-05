package com.liftoff.soloproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    //TODO: How can I change this to be optional? Review Optional secton from book

    @NotNull
    @Column (length = 64)
    private String password;

    @NotNull
    @Column (name = "first_name")
    private String firstName;

    @NotNull
    @Column (name = "last_name")
    private String lastName;

    //added these (enabled & roles) from Chris Bay's Spring Security tutorial
    @NotNull
    private Boolean enabled = true;

    public User(String email, String fullName, String encode) {
        super();
    }

    public List<String> getRoles() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        return roles;
    }

    public User(Boolean enabled) {
        this.enabled = enabled;
    }

    //86'ed Bcrypt in order to implement Spring Security

    public User(String email, String displayName, String userName, String password, String firstName, String lastName) {
        this.email = email;
        this.displayName = displayName;
        this.userName = userName;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    //Used the equals & hascode methods from Chris Bay's Spring Security tutorial
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    private static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("\\S+@\\S+");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
