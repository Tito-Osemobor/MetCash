
import java.util.Random;

public class Card {
    private String cardNumber;
    private String expirationDate;
    private String pin;

    public Card (String pin) {
        this.cardNumber = String.valueOf(generateCardNumber());
        this.expirationDate = generateExpirationDate();
        this.pin = pin;
    }

    private Integer generateCardNumber() {
        Random rand = new Random();
        int min = 1000000;
        int max = 9999999;
        return rand.nextInt((max - min) + 1) + min;
    }

    public String getCardNumber() { return cardNumber; }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() { return pin; }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getExpirationDate() { return expirationDate; }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String generateExpirationDate() {
        Random rand = new Random();
        int year = 26;
        int month = rand.nextInt(12) + 1;
        return month + "/" + year;
    }

    
}
