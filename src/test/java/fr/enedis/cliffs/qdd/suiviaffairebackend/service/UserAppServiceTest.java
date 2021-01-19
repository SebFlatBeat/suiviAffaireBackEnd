package fr.enedis.cliffs.qdd.suiviaffairebackend.service;

import fr.enedis.cliffs.qdd.suiviaffairebackend.dao.UserAppDao;
import fr.enedis.cliffs.qdd.suiviaffairebackend.entities.UserApp;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.NotNniException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserExistException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.UserNotFoundException;
import fr.enedis.cliffs.qdd.suiviaffairebackend.exceptions.WrongPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class UserAppServiceTest {

    @Mock
    private UserAppDao mockUserAppDao;

    @InjectMocks
    private UserAppService userAppServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testLoadUserByUsername() {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Run the test
        final UserDetails result = userAppServiceUnderTest.loadUserByUsername("username");

        // Verify the results
    }

    @Test
    void testLoadUserByUsername_UserAppDaoReturnsAbsent() {
        // Setup
        when(mockUserAppDao.findByUsername("username")).thenReturn(Optional.empty());

        // Run the test
        final UserDetails result = userAppServiceUnderTest.loadUserByUsername("username");

        // Verify the results
    }

    @Test
    void testFindById() {
        // Setup

        // Configure UserAppDao.findById(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findById(0L)).thenReturn(userApp);

        // Run the test
        final Optional<UserApp> result = userAppServiceUnderTest.findById(0L);

        // Verify the results
    }

    @Test
    void testFindById_UserAppDaoReturnsNull() {
        // Setup
        when(mockUserAppDao.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final Optional<UserApp> result = userAppServiceUnderTest.findById(0L);

        // Verify the results
    }

    @Test
    void testFindByUsername() {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Run the test
        final Optional<UserApp> result = userAppServiceUnderTest.findByUsername("username");

        // Verify the results
    }

    @Test
    void testFindByUsername_UserAppDaoReturnsAbsent() {
        // Setup
        when(mockUserAppDao.findByUsername("username")).thenReturn(Optional.empty());

        // Run the test
        final Optional<UserApp> result = userAppServiceUnderTest.findByUsername("username");

        // Verify the results
    }

    @Test
    void testFindByUsernameAndPassword() throws Exception {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Run the test
        final UserApp result = userAppServiceUnderTest.findByUsernameAndPassword("username", "password");

        // Verify the results
    }

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
        assertThatThrownBy(() -> userAppServiceUnderTest.findByUsernameAndPassword("username", "password")).isInstanceOf(UserNotFoundException.class);
    }

    @Test
    void testFindByUsernameAndPassword_UserAppDaoReturnsAbsent() throws Exception {
        // Setup
        when(mockUserAppDao.findByUsername("username")).thenReturn(Optional.empty());

        // Run the test
        final UserApp result = userAppServiceUnderTest.findByUsernameAndPassword("username", "password");

        // Verify the results
    }

    @Test
    void testSaveNewUser() throws Exception {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Configure UserAppDao.save(...).
        final UserApp userApp1 = new UserApp(0L, "username", "password", "email");
        when(mockUserAppDao.save(any(UserApp.class))).thenReturn(userApp1);

        // Run the test
        userAppServiceUnderTest.saveNewUser("username", "password", "email");

        // Verify the results
    }

    @Test
    void testSaveNewUser_ThrowsUserExistException() {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Configure UserAppDao.save(...).
        final UserApp userApp1 = new UserApp(0L, "username", "password", "email");
        when(mockUserAppDao.save(any(UserApp.class))).thenReturn(userApp1);

        // Run the test
        assertThatThrownBy(() -> userAppServiceUnderTest.saveNewUser("username", "password", "email")).isInstanceOf(UserExistException.class);
    }

    @Test
    void testSaveNewUser_ThrowsNotNniException() {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        // Configure UserAppDao.save(...).
        final UserApp userApp1 = new UserApp(0L, "username", "password", "email");
        when(mockUserAppDao.save(any(UserApp.class))).thenReturn(userApp1);

        // Run the test
        assertThatThrownBy(() -> userAppServiceUnderTest.saveNewUser("username", "password", "email")).isInstanceOf(NotNniException.class);
    }

    @Test
    void testSaveNewUser_UserAppDaoFindByUsernameReturnsAbsent() throws Exception {
        // Setup
        when(mockUserAppDao.findByUsername("username")).thenReturn(Optional.empty());

        // Configure UserAppDao.save(...).
        final UserApp userApp = new UserApp(0L, "username", "password", "email");
        when(mockUserAppDao.save(any(UserApp.class))).thenReturn(userApp);

        // Run the test
        userAppServiceUnderTest.saveNewUser("username", "password", "email");

        // Verify the results
    }

    @Test
    void testSaveNewUser_UserAppDaoSaveReturnsNull() throws Exception {
        // Setup

        // Configure UserAppDao.findByUsername(...).
        final Optional<UserApp> userApp = Optional.of(new UserApp(0L, "username", "password", "email"));
        when(mockUserAppDao.findByUsername("username")).thenReturn(userApp);

        when(mockUserAppDao.save(any(UserApp.class))).thenReturn(null);

        // Run the test
        userAppServiceUnderTest.saveNewUser("username", "password", "email");

        // Verify the results
    }
}
