package com.liftoff.soloproject.data;

import com.liftoff.soloproject.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//    User findByUserName(String userName);
//
//    Optional<User> findById(Integer userId);
//

     User findByEmail(String email);

    //https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial


}
