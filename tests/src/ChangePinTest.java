import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ChangePinTest {
    List<User> users =  new ArrayList<>();

    @Test
    public void validateInputPin() {
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234"));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678"));
        ChangePin changepin = new ChangePin(users);
        String first = "5884";
        String second = "5884";
        String third = "898";
        String fourth = "898";
        assertEquals(true, changepin.validatePinInput(first, second));
        assertEquals(false, changepin.validatePinInput(first, third));
        assertEquals(false, changepin.validatePinInput(third, fourth));
    }
}