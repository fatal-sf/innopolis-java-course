package attestation01.repositories;

import attestation01.model.User;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsersRepositoryFileImpl implements UsersRepository {
    private static final String FILE_NAME = "users.txt";
    private List<User> users = new ArrayList<>();

    @Override
    public void create(User user) {
        // Проверка на уникальность логина и пароля
        if (user.getLogin().matches("\\d+")) {
            throw new IllegalArgumentException("Логин не может состоять только из цифр.");
        }
        if (user.getPassword().matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Пароль не может состоять только из букв.");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new IllegalArgumentException("Пароль и подтверждение пароля не совпадают.");
        }

        // Генерация уникального ID
        user.setId(UUID.randomUUID().toString());
        user.setRegistrationDate(LocalDateTime.now());

        // Добавление пользователя в коллекцию и запись в файл
        users.add(user);
        writeAllUsers(users);
    }

    @Override
    public User findById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Пользователя с заданным идентификатором не существует."));
    }

    @Override
    public List<User> findAll() {
        if (users.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    users.add(new User(line)); // Используем конструктор User
                }
            } catch (IOException e) {
                throw new RuntimeException("Ошибка при чтении файла", e);
            }
        }
        return new ArrayList<>(users); // Возвращаем копию списка
    }

    @Override
    public void update(User user) {
        User existingUser = findById(user.getId());
        users.remove(existingUser);
        users.add(user);
        writeAllUsers(users);
    }

    @Override
    public void deleteById(String id) {
        User user = findById(id);
        users.remove(user);
        writeAllUsers(users);
    }

    @Override
    public void deleteAll() {
        users.clear();
        writeAllUsers(users);
    }

    private void writeAllUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                writer.write(user.toString()); // Используем метод toString() из User
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в файл", e);
        }
    }
}