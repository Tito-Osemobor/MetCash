import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


class ATMProjectTest {
    @Test
    public void makeUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        for (User i : users) {
            assertNotNull(i.getFirstName());
            assertNotNull(i.getLastName());
            assertNotNull(i.getAddress());
            assertNotNull(i.getCard().getPin());
        }

    }

    @Test
    public void makePayees() {
        List<Payee> payees =  new ArrayList<>();
        payees.add(new Payee("TMU", 1000));
        payees.add(new Payee("NETFLIX", 15));
        payees.add(new Payee("AMAZON PRIME", 5));
        payees.add(new Payee("APPLE MUSIC", 6));
        for (Payee i : payees) {
            assertNotNull(i.getPayeeAccount());
            assertNotNull(i.getPayeeCompany());
        }
    }
}