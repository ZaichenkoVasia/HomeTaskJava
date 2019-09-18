package ua.mycompany.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void returnCorrectValueOfFullBuilder() {
        User user = new User.Builder()
                .withName("Name")
                .withSurname("Surname")
                .withEmail("email")
                .withPassword("password")
                .withCode(20)
                .build();
        assertEquals("Name", user.getName());
        assertEquals("Surname", user.getSurname());
        assertEquals("email", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(20, user.getCode());
    }

    @Test
    public void returnCorrectValueOfNotFullBuilder() {
        User user = new User.Builder()
                .withName("Name")
                .withEmail("email")
                .withPassword("password")
                .build();
        assertEquals("Name", user.getName());
        assertNull(user.getSurname());
        assertEquals("email", user.getEmail());
        assertEquals("password", user.getPassword());
        assertEquals(0, user.getCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIllegalArgumentExceptionCodeNegative() {
        new User.Builder()
                .withName("Name")
                .withEmail("email")
                .withPassword("password")
                .withCode(-5)
                .build();
    }
}