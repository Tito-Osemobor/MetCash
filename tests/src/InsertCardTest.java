import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertCardTest {
    private List<User> users;

    @Test
    public void testUserReturn(){
        this.users = new ArrayList<>();
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        InsertCard insertCard = new InsertCard(users);
        users.get(0).getCard().setCardNumber("9290715");
        users.get(0).getCard().setExpirationDate("5/26");
        users.get(1).getCard().setCardNumber("2345678");
        users.get(1).getCard().setExpirationDate("5/26");
        assertEquals(users.get(0), insertCard.getMatchingUser(users,"9290715","5/26","1234"));
        assertEquals(null, insertCard.getMatchingUser(users,"3423451","8/26","8877"));
    }
    @Test
    public void TestCheckIfEmpty(){
        this.users = new ArrayList<>();
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        InsertCard insertCard = new InsertCard(users);
        users.get(0).getCard().setCardNumber("9290715");
        users.get(0).getCard().setExpirationDate("5/26");
        users.get(1).getCard().setCardNumber("2345678");
        users.get(1).getCard().setExpirationDate("5/26");
        assertEquals(false, insertCard.checkIfEmpty("2345678","5/26","5678"));
        assertEquals(true, insertCard.checkIfEmpty("3423451","","8877"));
    }
}