package ua.mycompany.builder;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder()
                .withName("Name")
                .withSurname("Surname")
                .withEmail("email")
                .withPassword("password")
                .withCode(20)
                .build();
        System.out.println(user.toString());
    }
}
