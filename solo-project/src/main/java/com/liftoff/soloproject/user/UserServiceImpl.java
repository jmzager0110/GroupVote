package com.liftoff.soloproject.user;

import com.liftoff.soloproject.data.UserRepository;
import com.liftoff.soloproject.forms.UserForm;
import com.liftoff.soloproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public User save(UserForm userForm) throws EmailExistsException {

        User existingUser = userRepository.findByEmail(userForm.getEmail());
        if (existingUser != null)
            throw new EmailExistsException("The email address "
                    + userForm.getEmail() + " already exists in the system");

        User newUser = new User(
                userForm.getEmail(),
                userForm.getFullName(),
                passwordEncoder.encode(userForm.getPassword()));
        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
