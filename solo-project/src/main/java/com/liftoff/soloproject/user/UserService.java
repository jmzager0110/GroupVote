package com.liftoff.soloproject.user;

import com.liftoff.soloproject.forms.UserForm;
import com.liftoff.soloproject.models.User;

public interface UserService {

    public User save(UserForm userForm) throws EmailExistsException;
    public User findByEmail(String email);
}
