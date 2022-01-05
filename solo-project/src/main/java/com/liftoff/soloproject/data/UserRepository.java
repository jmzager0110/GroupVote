package com.liftoff.soloproject.data;

import com.liftoff.soloproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    public User findByEmail(String email);


}
