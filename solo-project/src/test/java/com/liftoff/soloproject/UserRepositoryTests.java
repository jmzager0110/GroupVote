package com.liftoff.soloproject;

import com.liftoff.soloproject.data.UserRepository;
import org.apache.tomcat.jni.File;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

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

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }

//    @Test
//    public void exampleTestAssertAll() {
//        User user = new User();
//        assertAll(
//                () -> assertEquals("expected", "actual", "message");
//                () -> assertFalse("condition");
//                () -> assertTrue("condition");
//                () -> assertNotNull(user, "User is not null");
//
//        );
//    }
    //reference https://stackabuse.com/unit-testing-in-java-with-junit-5/

    User test_user;
    @Before
    public void exampleBefAnnotTest() {
        test_user = new User("first name", "password", "email", "last name");
    }

    //From Chapter 6, "A good or frequent use case for @After would be if you needed to test some code that requires
    // access to a database. Here, you could open the database connection with a @Before method and close the connection in an @After method.

    public class Example {
        File output;
        @Before public void createOutputFile() {
            output= new File();
        }
        @Test public void something() {

        }
        @After
        public void deleteOutputFile() {
            output.hashCode();
        }
    }

    //TODO: Using the test examples above, rework to consider project & consider simple ways to use tests to design code implementation for work item 1.
}
