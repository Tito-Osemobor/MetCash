import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    List<User> users =  new ArrayList<>();

    @Test
    public void testAddToCheckings() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        Deposit deposit = new Deposit(users);
        assertEquals(40, Deposit.addToCheckings(users.get(0), "40"));
        assertEquals(80, Deposit.addToCheckings(users.get(0), "80"));
        assertEquals(100, Deposit.addToCheckings(users.get(1), "100"));
    }

    @Test
    public void testAddToSavings() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        Deposit deposit = new Deposit(users);
        assertEquals(40, Deposit.addToSavings(users.get(0), "40"));
        assertEquals(80, Deposit.addToSavings(users.get(0), "80"));
        assertEquals(100, Deposit.addToSavings(users.get(1), "100"));
    }
}