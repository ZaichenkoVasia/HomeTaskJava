package ua.mycompany.xtasks.post;

import java.util.Arrays;

public class Demo {

    private static Post post = new Post();

    public static void main(String[] args) {

        Person[] persons = new Person[10];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person("Person_"+i);
        }

        int letterCount = 15;
        for (int i = 0; i < letterCount; i++) {
            post.sendLetter(new Letter("Letter_"+i, persons[i % persons.length], persons[persons.length - 1 - i % persons.length]));
        }

        printPersonData(persons[0]);
        printPersonData(persons[8]);
        printPersonData(new Person("Person_new"));

        System.out.println(Arrays.toString(post.getUndeliveredLetters()));
        for (Letter letter : post.getUndeliveredLetters()) {
            System.out.println(letter.getText());
        }

        System.out.println(Arrays.toString(post.getDeliveredLetters()));
        for (Letter letter : post.getDeliveredLetters()) {
            System.out.println(letter.getText());
        }
    }

    private static void printPersonData(Person person)
    {
        System.out.println(person.getName());

        System.out.println(" - "+Arrays.toString(post.takeLettersBySender(person)));
        System.out.println(" - Received: "+post.takeLettersBySender(person).length);
        for (Letter letter : post.takeLettersBySender(person)) {
            System.out.println(" - : "+letter.getText());
        }
        System.out.println(" - Sent: "+post.getNumberOflettersSentByPerson(person));
    }
}
