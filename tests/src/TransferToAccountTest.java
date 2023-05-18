import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
class TransferToAccountTest {
    List<User> users =  new ArrayList<>();

    @Test
    public void testUserCheckisCorrect() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        TransferToAccount transfer = new TransferToAccount(users);

        users.get(0).setCheckingsAccountNumber("33829");
        users.get(1).setCheckingsAccountNumber("50766");

        assertEquals(users.get(0), transfer.isUserCheckCorrect(users,"33829"));
        assertEquals(null, transfer.isUserCheckCorrect(users,"78905"));

    }
    @Test
    public void testUserSavisCorrect() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        TransferToAccount transfer = new TransferToAccount(users);

        users.get(0).setSavingsAccountNumber("33830");
        users.get(1).setSavingsAccountNumber("50765");

        assertEquals(null, transfer.isUserSavCorrect(users,"33829"));
        assertEquals(users.get(1), transfer.isUserSavCorrect(users,"50765"));

    }
    @Test
    public void testCheckToAccCheck(){
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        TransferToAccount transfer = new TransferToAccount(users);
        users.get(0).setCheckingsBalance(450);
        users.get(1).setCheckingsBalance(100);

        assertArrayEquals(new String[] {"400","150",""}, transfer.checkToAccCheck(users.get(0),users.get(1),50));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.checkToAccCheck(users.get(1),users.get(0),250));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.checkToAccCheck(users.get(0),users.get(1),500));
        assertArrayEquals(new String[] {"50","500",""}, transfer.checkToAccCheck(users.get(1),users.get(0),50));

    }
    @Test
    public void testCheckToAccSav(){
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        TransferToAccount transfer = new TransferToAccount(users);
        users.get(0).setCheckingsBalance(90);
        users.get(0).setSavingsBalance(50);
        users.get(1).setCheckingsBalance(100);
        users.get(1).setSavingsBalance(230);

        assertArrayEquals(new String[] {"40","280",""}, transfer.checkToAccSav(users.get(0),users.get(1),50));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.checkToAccSav(users.get(1),users.get(0),150));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.checkToAccSav(users.get(0),users.get(1),500));
        assertArrayEquals(new String[] {"50","100",""}, transfer.checkToAccSav(users.get(1),users.get(0),50));

    }
    @Test
    public void testSavToAccCheck(){
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        TransferToAccount transfer = new TransferToAccount(users);
        users.get(0).setCheckingsBalance(90);
        users.get(0).setSavingsBalance(50);
        users.get(1).setCheckingsBalance(100);
        users.get(1).setSavingsBalance(230);

        assertArrayEquals(new String[] {"0","150",""}, transfer.savToAccCheck(users.get(0),users.get(1),50));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.savToAccCheck(users.get(1),users.get(0),300));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.savToAccCheck(users.get(0),users.get(1),60));
        assertArrayEquals(new String[] {"180","140",""}, transfer.savToAccCheck(users.get(1),users.get(0),50));

    }
    @Test
    public void testSavToAccSav(){
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        TransferToAccount transfer = new TransferToAccount(users);
        users.get(0).setCheckingsBalance(90);
        users.get(0).setSavingsBalance(50);
        users.get(1).setCheckingsBalance(100);
        users.get(1).setSavingsBalance(230);

        assertArrayEquals(new String[] {"0","280",""}, transfer.savToAccSav(users.get(0),users.get(1),50));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.savToAccSav(users.get(1),users.get(0),300));
        assertArrayEquals(new String[] {"","","Insufficient Funds"}, transfer.savToAccSav(users.get(0),users.get(1),60));
        assertArrayEquals(new String[] {"180","100",""}, transfer.savToAccSav(users.get(1),users.get(0),50));

    }

}