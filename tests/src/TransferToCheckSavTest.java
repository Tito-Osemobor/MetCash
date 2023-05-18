import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
class TransferToCheckSavTest {
    List<User> users =  new ArrayList<>();
    @Test
    public void testCheckingsToSavings() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        TransferToCheckSav transfer = new TransferToCheckSav(users);
        users.get(0).setCheckingsBalance(50);
        users.get(0).setSavingsBalance(100);
        users.get(1).setCheckingsBalance(300);
        users.get(1).setSavingsBalance(100);
        assertArrayEquals(new String[] {"0","150",""}, transfer.checkingToSavings(users.get(0),50));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.checkingToSavings(users.get(0),70));
        assertArrayEquals(new String[] {"230","170",""}, transfer.checkingToSavings(users.get(1),70));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.checkingToSavings(users.get(1),500));
    }

    @Test
    public void testSavingsToCheckings() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        TransferToCheckSav transfer = new TransferToCheckSav(users);
        users.get(0).setCheckingsBalance(200);
        users.get(0).setSavingsBalance(30);
        users.get(1).setCheckingsBalance(380);
        users.get(1).setSavingsBalance(140);
        assertArrayEquals(new String[] {"215","15",""}, transfer.savingsToCheckings(users.get(0),15));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.savingsToCheckings(users.get(0),50));
        assertArrayEquals(new String[] {"450","70",""}, transfer.savingsToCheckings(users.get(1),70));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.savingsToCheckings(users.get(1),200));
    }
}