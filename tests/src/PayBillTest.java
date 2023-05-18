import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PayBillTest {
    List<User> users =  new ArrayList<>();
    List<Payee> payees =  new ArrayList<>();
    String transactionHistory="/Users/titoosemobor/TMU-ComputerSci/JAVA/ATMProject/SidrasTransactionHistory.txt";
    @Test
    public void testCheckIfInsufficent(){
        users.add(new User("Sidra", "Musheer", "123 Main St","1234",transactionHistory,payees));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678",transactionHistory,payees));
        PayBill pay = new PayBill(users);
        payees.add(new Payee("TMU", 1000));
        payees.add(new Payee("NETFLIX", 15));
        payees.add(new Payee("AMAZON PRIME", 5));
        payees.add(new Payee("APPLE MUSIC", 6));
        users.get(0).setCheckingsBalance(50);
        users.get(0).setSavingsBalance(100);
        users.get(1).setCheckingsBalance(100);
        users.get(1).setSavingsBalance(50);
        assertEquals(false, pay.checkIfInsufficent(users.get(0), 80,"Checkings"));
        assertEquals(true, pay.checkIfInsufficent(users.get(0), 50,"Savings"));
        assertEquals(true, pay.checkIfInsufficent(users.get(1), 80,"Checkings"));
        assertEquals(false, pay.checkIfInsufficent(users.get(1), 100,"Savings"));
    }
    @Test
    public void testPayByCheckings(){
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234",transactionHistory,payees));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678",transactionHistory,payees));
        payees.add(new Payee("TMU", 1000));
        payees.add(new Payee("NETFLIX", 15));
        payees.add(new Payee("AMAZON PRIME", 5));
        payees.add(new Payee("APPLE MUSIC", 6));
        PayBill pay = new PayBill(users);
        users.get(0).setCheckingsBalance(1000);
        users.get(1).setCheckingsBalance(400);

        assertArrayEquals(new String[] {"0","0","0",""}, pay.payByCheckings(users.get(0),"payee1",1000));
        assertArrayEquals(new String[] {"994","0","3",""},  pay.payByCheckings(users.get(0),"payee4",6));
        assertArrayEquals(new String[] {"","","","Wrong Amount"},  pay.payByCheckings(users.get(1),"payee3",500));
        assertArrayEquals(new String[] {"","","","Wrong Amount"},  pay.payByCheckings(users.get(1),"payee2",20));
    }
    @Test
    public void testPayBySavings(){
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234",transactionHistory,payees));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678",transactionHistory,payees));
        payees.add(new Payee("TMU", 1000));
        payees.add(new Payee("NETFLIX", 15));
        payees.add(new Payee("AMAZON PRIME", 5));
        payees.add(new Payee("APPLE MUSIC", 6));
        PayBill pay = new PayBill(users);
        users.get(0).setSavingsBalance(1000);
        users.get(1).setSavingsBalance(1000);

        assertArrayEquals(new String[] {"","","","Wrong Amount"}, pay.payBySavings(users.get(0),"payee1",500));
        assertArrayEquals(new String[] {"","","","Wrong Amount"},  pay.payBySavings(users.get(1),"payee4",15));
        assertArrayEquals(new String[] {"995","0","2",""},  pay.payBySavings(users.get(0),"payee3",5));
        assertArrayEquals(new String[] {"985","0","1",""},  pay.payBySavings(users.get(1),"payee2",15));
    }

}