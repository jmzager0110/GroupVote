package com.liftoff.soloproject;

import static org.assertj.core.api.Assertions.assertThat;

import com.liftoff.soloproject.data.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    //TestEntityManager is a wrapper of JPA's EntityManager, see https://www.baeldung.com/hibernate-entitymanager

    @Autowired
    private UserRepository userRepository;

    // test methods go below
    //from Section 4 of tutorial, https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
    //persists a User object into the database
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        user.setFirstName("Ravi");
        user.setLastName("Kumar");

        User savedUser = userRepository.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }

    //TODO: Set up more tests for the User & feature 1, login or sign up.
    // Test 2: use assertNotNull(User) to test that the user is created in a different way than Test 1.
    // Other methods to use are assertEquals(), assertFalse(), & assertTrue().
    // Additionally, use the @Before & @After since you are utilizing a database!
    // From Chapter 6, Section 2, "A good or frequent use case for @After would be if you needed to test
    // some code that requires access to a database. Here, you could open the database connection with a
    // @Before method and close the connection in an @After method." https://education.launchcode.org/java-independent-track/chapters/unit-testing/junit.html#java-annotations
}
