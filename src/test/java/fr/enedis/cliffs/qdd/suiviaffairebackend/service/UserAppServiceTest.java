package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.configuration.BCryptEncoderConfig;
import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.UserAppDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserNotFoundException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.WrongPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;


class UserAppServiceTest {

    @Mock
    private UserAppDao mockUserAppDao;

    @InjectMocks
    private UserAppService userAppServiceUnderTest;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        // Configure UserAppDao.findById(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findById(0L)).thenReturn(userApp);

        // Run the test
        final Optional<UserApp> result = userAppServiceUnderTest.findById(0L);

        // Verify the results
        assertEquals(userApp,result);
    }

    @Test
    void testFindByUsername() {
        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Run the test
        final Optional<UserApp> result = userAppServiceUnderTest.findByUsername("username");

        // Verify the results
        assertEquals(userApp,result);
    }
    /*
      @Test
    void testFindByUsernameAndPassword() throws Exception {
        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Run the test
        final UserApp result = userAppServiceUnderTest.findByUsernameAndPassword("username","password");

        // Verify the results
          assertEquals(userApp,result);
    }
     */

    @Test
    void testFindByUsernameAndPassword_ThrowsWrongPasswordException() {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Run the test
        assertThatThrownBy(() -> userAppServiceUnderTest.findByUsernameAndPassword("username", "password")).isInstanceOf(WrongPasswordException.class);
    }

     @Test
    void testFindByUsernameAndPassword_ThrowsUserNotFoundException() {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Run the test
        assertThatThrownBy(() -> userAppServiceUnderTest.findByUsernameAndPassword("usernameFalse", "password")).isInstanceOf(UserNotFoundException.class);
    }

}
