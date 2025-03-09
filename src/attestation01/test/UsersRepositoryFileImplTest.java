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
        // Очистка данных перед каждым тестом
        repository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        // Очистка данных после каждого теста
        repository.deleteAll();
    }

    @Test
    void testCreateUser() {
        // Создаем пользователя с помощью конструктора одной строкой
        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|testUser|testPass123|testPass123|Тестов|Тест|Тестович|30|false");

        repository.create(user);

        User foundUser = repository.findById(user.getId());
        assertNotNull(foundUser);
        assertEquals("testUser", foundUser.getLogin());
        assertEquals("Тестов", foundUser.getLastName());
    }

    @Test
    void testFindAllUsers() {
        // Создаем пользователя с помощью конструктора одной строкой
        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|testUser|testPass123|testPass123|Тестов|Тест|Тестович|30|false");

        repository.create(user);

        List<User> users = repository.findAll();
        assertFalse(users.isEmpty());
        assertTrue(users.contains(user));
    }

    @Test
    void testCreateUserWithInvalidLogin() {
        // Создаем пользователя с некорректным логином (только цифры)
        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|123456|testPass123|testPass123|Тестов|Тест|Тестович|30|false");

        assertThrows(IllegalArgumentException.class, () -> repository.create(user));
    }

    @Test
    void testFindNonExistentUser() {
        assertThrows(IllegalArgumentException.class, () -> repository.findById("non-existent-id"));
    }

    @Test
    void testUpdateUser() {
        // Создаем пользователя с помощью конструктора одной строкой
        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|testUser|testPass123|testPass123|Тестов|Тест|Тестович|30|false");

        repository.create(user);

        // Обновляем имя пользователя
        user.setFirstName("Обновленное Имя");
        repository.update(user);

        User updatedUser = repository.findById(user.getId());
        assertEquals("Обновленное Имя", updatedUser.getFirstName());
    }

    @Test
    void testDeleteUser() {
        // Создаем пользователя с помощью конструктора одной строкой
        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|testUser|testPass123|testPass123|Тестов|Тест|Тестович|30|false");

        repository.create(user);
        repository.deleteById(user.getId());

        assertThrows(IllegalArgumentException.class, () -> repository.findById(user.getId()));
    }

    @Test
    void testDeleteAll() {
        // Создаем пользователя с помощью конструктора одной строкой
        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|testUser|testPass123|testPass123|Тестов|Тест|Тестович|30|false");

        repository.create(user);
        repository.deleteAll();

        List<User> users = repository.findAll();
        assertTrue(users.isEmpty());
    }

    @Test
    void testLoadUsersFromFile() {
        // Создаем пользователя с помощью конструктора одной строкой
        User user = new User("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|testUser|testPass123|testPass123|Тестов|Тест|Тестович|30|false");

        // Создаем пользователя и записываем его в файл
        repository.create(user);

        // Загружаем пользователей из файла
        List<User> users = repository.findAll();
        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
        assertEquals("testUser", users.get(0).getLogin());
    }
}