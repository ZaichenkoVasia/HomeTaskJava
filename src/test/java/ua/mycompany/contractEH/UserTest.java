package ua.mycompany.contractEH;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {

    private User den;
    private User tim;


    public UserTest() {
    }

    @Before
    public void setUp() throws Exception {
        Address address = new Address("Kiev", 20020);
        den = new User("Den", "Den", 20, true, address);
        tim = new User("Tim", "Tim", 20, true, address);
    }

    @Test
    public void returnEqualsOfUser() {
        boolean actual = den.equals(tim);
        assertFalse(actual);
    }

    @Test
    public void returnHashCodesOfUser() {
        boolean actual = den.hashCode() == tim.hashCode();
        assertTrue(actual);
    }
}