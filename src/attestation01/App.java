package attestation01;
import attestation01.model.User;
import attestation01.repositories.UsersRepository;
import attestation01.repositories.UsersRepositoryFileImpl;

import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        UsersRepository repository = new UsersRepositoryFileImpl();

        // Загрузка пользователей из файла при старте
        loadUsersFromFile(repository);

        // Тестирование методов
        printStars();
        System.out.println("1. Проверка создания пользователя");
        printStars();
        User newUser = new User();
        newUser.setLogin("newUser");
        newUser.setPassword("newPass123");
        newUser.setConfirmPassword("newPass123");
        newUser.setLastName("Новый");
        newUser.setFirstName("Пользователь");
        newUser.setMiddleName("Тестовый");
        newUser.setAge(25);
        newUser.setWorker(false);
        repository.create(newUser);
        System.out.println("Создан и сохранен пользователь: " + newUser.toString());
        System.out.println();
        printStars();
        System.out.println("2. Проверка поиска пользователя по его идентификатору");
        printStars();
        System.out.println("Поиск пользователя с id " + newUser.getId() + ": ");
        User foundUser = repository.findById(newUser.getId());
        System.out.println("Найден пользователь: " + foundUser.getFirstName());
        System.out.println();

        printStars();
        System.out.println("3. Проверка поиска всех пользователей.");
        printStars();
        List<User> allUsers = repository.findAll();
        System.out.println("Найдены пользователи: ");
        for(User user:allUsers){
            System.out.println(user.toString());
        }
        System.out.println();

        printStars();
        System.out.println("4. Проверка изменения имени пользователя по его идентификатору.");
        printStars();
        System.out.println("Изменение имени пользователя c id " + foundUser.getId()+ ":");
        System.out.println("До: " + foundUser.getFirstName());
        newUser.setFirstName("Обновленное Имя");
        repository.update(newUser);
        System.out.println("После: " + foundUser.getFirstName());
        System.out.println();

        printStars();
        System.out.println("5. Проверка удаления пользователя по его идентификатору.");
        printStars();
        System.out.println("Список пользователей до удаления: ");
        List<User> allUsersBeforeDeleteById = repository.findAll();
        for(User user:allUsersBeforeDeleteById){
            System.out.println(user.toString());
        }
        System.out.println("Удаляю пользователя с идентификатором " + newUser.getId());
        repository.deleteById(newUser.getId());
        List<User> allUsersAfterDeleteById = repository.findAll();
        System.out.println("Список пользователей после удаления: ");
        for(User user:allUsersAfterDeleteById){
            System.out.println(user.toString());
        }
        System.out.println();

        printStars();
        System.out.println("6. Проверка удаления всех пользователей.");
        printStars();
        List<User> allUsersBeforeDelete = repository.findAll();
        for(User user:allUsersBeforeDelete){
            System.out.println(user.toString());
        }
        repository.deleteAll();
        System.out.println("Все пользователи удалены");
        System.out.println("Проверяю результат удаления: ");
        List<User> allUsersAfterDelete = repository.findAll();
        if(allUsersAfterDelete.isEmpty()){
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Найдены пользователи: ");
            for(User user:allUsersAfterDelete){
                System.out.println(user.toString());
            }
        }
    }

    private static void loadUsersFromFile(UsersRepository repository) {
        // Если репозиторий поддерживает чтение из файла, загружаем пользователей
        if (repository instanceof UsersRepositoryFileImpl) {
            UsersRepositoryFileImpl fileRepository = (UsersRepositoryFileImpl) repository;
            List<User> users = fileRepository.readAllUsers();
            // Добавляем пользователей в репозиторий без повторной записи в файл
            for (User user : users) {
                fileRepository.addUserToCollection(user); // Добавляем пользователя в коллекцию
            }
        }
    }
    private static void printStars(){
        System.out.println("************************************************************************************************************************************************************************");
    }
}