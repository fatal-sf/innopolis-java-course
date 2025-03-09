package attestation01.test;

import attestation01.model.User;
import attestation01.repositories.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class UsersRepositoryFileImplTest {

    private UsersRepository repository;

    @BeforeEach
    void setUp() {
        // Инициализация репозитория перед каждым тестом
        repository = new UsersRepositoryFileImpl();
    }

    @AfterEach
    void tearDown() {
        // Очистка данных после каждого теста
        repository.deleteAll();
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setLogin("testUser");
        user.setPassword("testPass123");
        user.setConfirmPassword("testPass123");
        user.setLastName("Тестов");
        user.setFirstName("Тест");
        user.setMiddleName("Тестович");
        user.setAge(30);
        user.setWorker(false);

        repository.create(user);

        User foundUser = repository.findById(user.getId());
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getLogin());
        assertEquals("Тестов", foundUser.getLastName());
    }

    @Test
    void testFindAllUsers() {
        User user = new User();
        user.setLogin("testUser");
        user.setPassword("testPass123");
        user.setConfirmPassword("testPass123");
        user.setLastName("Тестов");
        user.setFirstName("Тест");
        user.setMiddleName("Тестович");
        user.setAge(30);
        user.setWorker(false);

        repository.create(user);

        List<User> users = repository.findAll();
        assertFalse(users.isEmpty());
        assertTrue(users.contains(user));
    }

    @Test
    void testCreateUserWithInvalidLogin() {
        User user = new User();
        user.setLogin("123456"); // Логин состоит только из цифр
        user.setPassword("testPass123");
        user.setConfirmPassword("testPass123");
        user.setLastName("Тестов");
        user.setFirstName("Тест");
        user.setMiddleName("Тестович");
        user.setAge(30);
        user.setWorker(false);

        assertThrows(IllegalArgumentException.class, () -> repository.create(user));
    }

    @Test
    void testFindNonExistentUser() {
        assertThrows(IllegalArgumentException.class, () -> repository.findById("non-existent-id"));
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        user.setLogin("testUser");
        user.setPassword("testPass123");
        user.setConfirmPassword("testPass123");
        user.setLastName("Тестов");
        user.setFirstName("Тест");
        user.setMiddleName("Тестович");
        user.setAge(30);
        user.setWorker(false);

        repository.create(user);

        user.setFirstName("Обновленное Имя");
        repository.update(user);

        User updatedUser = repository.findById(user.getId());
        assertEquals("Обновленное Имя", updatedUser.getFirstName());
    }

    @Test
    void testDeleteUser() {
        User user = new User();
        user.setLogin("testUser");
        user.setPassword("testPass123");
        user.setConfirmPassword("testPass123");
        user.setLastName("Тестов");
        user.setFirstName("Тест");
        user.setMiddleName("Тестович");
        user.setAge(30);
        user.setWorker(false);

        repository.create(user);
        repository.deleteById(user.getId());

        assertThrows(IllegalArgumentException.class, () -> repository.findById(user.getId()));
    }
}