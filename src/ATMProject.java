

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
/**
 *
 * @author titoosemobor
 */
public class ATMProject {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<Payee> user1 =  new ArrayList<>();
        List<Payee> user2 =new ArrayList<>();
        users.add(new User("Sidra", "Musheer", "123 Main St", "1234","/Users/titoosemobor/TMU-ComputerSci/JAVA/ATMProject/SidrasTransactionHistory.txt",user1));
        users.add(new User("Nicanor", "Obasi", "456 Elm St", "5678","/Users/titoosemobor/TMU-ComputerSci/JAVA/ATMProject/NicsTransactionHistory.txt",user2));
        setTransactionHistory();
        for (User i : users) {
            i.print();
        }

        user1.add(new Payee("TMU", 1000));
        user1.add(new Payee("NETFLIX", 15));
        user1.add(new Payee("AMAZON PRIME", 5));
        user1.add(new Payee("APPLE MUSIC", 6));

        user2.add(new Payee("TMU", 1000));
        user2.add(new Payee("NETFLIX", 15));
        user2.add(new Payee("AMAZON PRIME", 5));
        user2.add(new Payee("APPLE MUSIC", 6));

        for (Payee i : user1) {
            i.print();
        }
        for (Payee i : user2) {
            i.print();
        }
        Loader myLoader = new Loader();
        myLoader.setVisible(true);
        try {
            for(int i = 0; i <= 100; i ++) {
                Thread.sleep(30);
                myLoader.LoadingBar.setValue(i);
            }
        }
        catch (Exception e) {
        }
        myLoader.dispose();

        SwingUtilities.invokeLater(() -> {
            InsertCard login = new InsertCard(users);
            login.setVisible(true);
        });
    }
    public static void setTransactionHistory(){
        try {
            // Import the text file
            File file = new File("/Users/titoosemobor/TMU-ComputerSci/JAVA/ATMProject/SidrasTransactionHistory.txt");

            // Empty the contents of the text file
            FileWriter writer = new FileWriter(file);
            writer.write("");
            writer.close();

            // Append strings to the text file multiple times
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));

            out.write("Transaction Type,Amount,From Account,Date\n");

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Import the text file
            File file = new File("/Users/titoosemobor/TMU-ComputerSci/JAVA/ATMProject/NicsTransactionHistory.txt");

            // Empty the contents of the text file
            FileWriter writer = new FileWriter(file);
            writer.write("");
            writer.close();

            // Append strings to the text file multiple times
            BufferedWriter out = new BufferedWriter(new FileWriter(file, true));

            out.write("Transaction Type,Amount,From Account,Date\n");

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

