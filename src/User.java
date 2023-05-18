
import java.util.List;
import java.util.Random;

public class User {
    private String checkingsAccountNumber;
    private String savingsAccountNumber;
    private String firstName;
    private String lastName;
    private String address;
    private Integer checkingsBalance;
    private Integer savingsBalance;
    private Card card;
    private String transactionPaper;
    private List<Payee> payees;


    public User(String firstName, String lastName, String address, String pin,String transactionPaper,List<Payee> payees) {
        this.checkingsAccountNumber = generateCheckingsAccountNumber();
        this.savingsAccountNumber = generateSavingsAccountNumber();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.checkingsBalance = 0;
        this.savingsBalance = 0;
        this.card = new Card(pin);
        this.transactionPaper=transactionPaper;
        this.payees=payees;
    }
    public User(String firstName, String lastName, String address, String pin) {
        this.checkingsAccountNumber = generateCheckingsAccountNumber();
        this.savingsAccountNumber = generateSavingsAccountNumber();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.checkingsBalance = 0;
        this.savingsBalance = 0;
        this.card = new Card(pin);

    }

    public String getCheckingsAccountNumber() { return checkingsAccountNumber; }

    public void setCheckingsAccountNumber(String checkingsAccountNumber) {
        this.checkingsAccountNumber = checkingsAccountNumber;
    }
    public String getTransactionPaper(){return transactionPaper;}
    public String getSavingsAccountNumber() { return savingsAccountNumber; }

    public void setSavingsAccountNumber(String savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }


    public String generateCheckingsAccountNumber() {
        Random rand = new Random();
        int min = 10000;
        int max = 99999;
        return String.valueOf(rand.nextInt((max - min) + 1) + min);
    }
    public String generateSavingsAccountNumber(){
        return String.valueOf(Integer.parseInt(checkingsAccountNumber) + 1);
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getAddress() { return address; }

    public Integer getCheckingsBalance() { return checkingsBalance; }
    public Integer getSavingsBalance() { return savingsBalance;}

    public void print()
    {
        System.out.printf("\nName: %s %s CheckingsAcc: %s SavingsAcc: %s CardNumber: %s CardExpiryDate: %s Pin: %s", firstName,lastName, checkingsAccountNumber, savingsAccountNumber, card.getCardNumber(),card.getExpirationDate(),card.getPin());
    }
    public Card getCard() { return card; }
    public List<Payee> getPayees(){
        return payees;
    }


    public void setSavingsBalance(Integer savingsBalance) { this.savingsBalance = savingsBalance; }
    public void setCheckingsBalance(Integer checkingsBalance) { this.checkingsBalance = checkingsBalance;}
}
