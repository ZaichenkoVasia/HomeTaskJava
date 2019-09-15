package ua.mycompany.contractEH;

import com.sun.media.sound.InvalidDataException;

public class Address {
    private String city;
    private int code;

    public Address(String city, int code) throws InvalidDataException {
        if (code < 0)
            throw new InvalidDataException();
        if (city == null)
            throw new NullPointerException();
        this.city = city;
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) throws InvalidDataException {
        if (city == null)
            throw new NullPointerException();
        return new Address(city, code);
    }

    public int getCode() {
        return code;
    }

    public Address setCode(int code) throws InvalidDataException {
        if (code < 0)
            throw new InvalidDataException();
        return new Address(city, code);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", code=" + code +
                '}';
    }
}