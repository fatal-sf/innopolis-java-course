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
        return new ArrayList<>(users);
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

    public List<User> readAllUsers() {
        return readAllUsersFromFile();
    }

    public void addUserToCollection(User user) {
        users.add(user);
    }

    private List<User> readAllUsersFromFile() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(stringToUser(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла", e);
        }
        return users;
    }

    private void writeAllUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                writer.write(userToString(user));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в файл", e);
        }
    }

    private String userToString(User user) {
        return String.join("|",
                user.getId(),
                user.getRegistrationDate().toString(),
                user.getLogin(),
                user.getPassword(),
                user.getConfirmPassword(),
                user.getLastName(),
                user.getFirstName(),
                user.getMiddleName(),
                user.getAge() != null ? user.getAge().toString() : "",
                Boolean.toString(user.isWorker())
        );
    }

    private User stringToUser(String line) {
        String[] parts = line.split("\\|");
        User user = new User();
        user.setId(parts[0]);
        user.setRegistrationDate(LocalDateTime.parse(parts[1]));
        user.setLogin(parts[2]);
        user.setPassword(parts[3]);
        user.setConfirmPassword(parts[4]);
        user.setLastName(parts[5]);
        user.setFirstName(parts[6]);
        user.setMiddleName(parts[7]);
        user.setAge(parts[8].isEmpty() ? null : Integer.parseInt(parts[8]));
        user.setWorker(Boolean.parseBoolean(parts[9]));
        return user;
    }
}