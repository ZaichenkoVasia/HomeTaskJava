package ua.mycompany.contractEH;

import com.sun.media.sound.InvalidDataException;

public final class User {
    private final String name;
    private final String surname;
    private final int age;
    private final boolean active;
    private final Address address;

    public User(String name, String surname, int age, boolean active, Address address) throws InvalidDataException {
        if (age < 0)
            throw new InvalidDataException();
        if (name == null || surname == null)
            throw new InvalidDataException();
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
        if (this == user) return true;
        if (user == null || getClass() != user.getClass()) return false;
        return age == user.age &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                active == user.active;
    }

    public int hashCode() {
        return active ? age * 4433 - name.length() : 999 - surname.length() * 24 + age;
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
