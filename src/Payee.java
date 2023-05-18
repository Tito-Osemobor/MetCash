/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

/**
 *
 * @author jessicamorcos
 */
public class Payee {
    
    private int moneyOwed; 
    private String payeeCompany;
    private String payeeAccount;

    
    public Payee(String payeeCompany, int moneyOwed){
        this.moneyOwed = moneyOwed;
        this.payeeCompany = payeeCompany;
        this.payeeAccount = generatePayeeAccountNumber();
    }

    public String getPayeeCompany() {
        return payeeCompany;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public int getMoneyOwed() {
        return moneyOwed;
    }
    public void print()
    {
        System.out.printf("\nPayeeCompany: %-20s PayeeAccount: %3s MoneyOwed: %-30s ", payeeCompany,payeeAccount,moneyOwed);

    }
    public void setMoneyOwed(int moneyOwed) {
        this.moneyOwed = moneyOwed;
    }

    private String generatePayeeAccountNumber() {
        Random rand = new Random();
        int min = 100000;
        int max = 999999;
        return String.valueOf(rand.nextInt((max - min) + 1) + min);
    }
}
