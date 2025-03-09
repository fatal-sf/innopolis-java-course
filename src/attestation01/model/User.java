package attestation01.model;

import java.time.LocalDateTime;

public class User {
    private String id;
    private LocalDateTime registrationDate;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private boolean isWorker;

    public User(String line) {
        String[] parts = line.split("\\|");
        this.id = parts[0];
        this.registrationDate = LocalDateTime.parse(parts[1]);
        this.login = parts[2];
        this.password = parts[3];
        this.confirmPassword = parts[4];
        this.lastName = parts[5];
        this.firstName = parts[6];
        this.middleName = parts[7];
        this.age = parts[8].isEmpty() ? null : Integer.parseInt(parts[8]);
        this.isWorker = Boolean.parseBoolean(parts[9]);
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", registrationDate=" + registrationDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }
}
