package com.liftoff.soloproject.data;

import com.liftoff.soloproject.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByUserName(String userName);

    Optional<User> findById(Integer userId);

    //https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
    //In this tutorial, they use JpaRepository instead of CRUD, but that might just be depreciated.

}
