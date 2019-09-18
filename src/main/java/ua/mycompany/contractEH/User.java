package ua.mycompany.contractEH;

import com.sun.media.sound.InvalidDataException;

import javax.xml.bind.ValidationException;

public final class User {
    private final String name;
    private final String surname;
    private final int age;
    private final boolean active;
    private final Address address;

    public User(String name, String surname, int age, boolean active, Address address)throws ValidationException {
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.active = active;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public boolean equals(User user) {
        if (this == user) {
            return true;
        }
        if (user == null || getClass() != user.getClass()) {
            return false;
        }
        return age == user.age &&
                (name == user.name || (name != null && name.equals(user.getName()))) &&
                (surname == user.surname || (surname != null && surname.equals(user.getSurname()))) &&
                active == user.active;
    }

    public int hashCode() {
        int result = 0;
        result *= 31 * (this.name == null ? 1 : name.length() + 1);
        result *= 31 * (this.surname == null ? 1 : surname.length() + 1);
        result *= 31 * age;
        result *= 31 * (active ? 2 : 1);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", address=" + address +
                '}';
    }
}
