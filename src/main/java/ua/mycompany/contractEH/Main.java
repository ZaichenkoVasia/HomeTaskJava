package ua.mycompany.contractEH;

import com.sun.media.sound.InvalidDataException;

import javax.xml.bind.ValidationException;

public class Main {
    public static void main(String[] args) throws ValidationException {

        Address address = new Address("Kiev", 20020);
        User den = new User("Den", "Den", 20, true, address);
        User tim = new User("Tim", "Tim", 20, true, address);
        System.out.println("This user equals? " + den.equals(tim));
        boolean hashCodeSimilar = den.hashCode() == tim.hashCode();
        System.out.println("Their hash codes equals? " + hashCodeSimilar);
        System.out.println(den);
        address.setCity("no Kiev");
        System.out.println(den);
    }
}
