import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class WithdrawTest {

    List<User> users =  new ArrayList<>();

    @Test
    public void testWithdrawCheckings() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        Withdraw withdraw = new Withdraw(users);
        users.get(0).setCheckingsBalance(50);
        users.get(1).setCheckingsBalance(100);
        assertEquals("10", withdraw.withdrawCheckings(users.get(0), "40"));
        assertEquals("20", withdraw.withdrawCheckings(users.get(1), "80"));
        assertEquals("Insufficient Funds", withdraw.withdrawCheckings(users.get(0), "100"));
    }

    @Test
    public void testWithdrawSavings() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));

        Withdraw withdraw = new Withdraw(users);
        users.get(0).setSavingsBalance(50);
        users.get(1).setSavingsBalance(100);
        assertEquals("Insufficient Funds", withdraw.withdrawSavings(users.get(0), "100"));
        assertEquals("Insufficient Funds", withdraw.withdrawSavings(users.get(0), "80"));
        assertEquals("0", withdraw.withdrawSavings(users.get(1), "100"));
    }
}