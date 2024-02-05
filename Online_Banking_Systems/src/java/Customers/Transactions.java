/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customers;

import java.security.Timestamp;

/**
 *
 * @author ASUS
 */
public class Transactions {
    int Transactions_id,account_from,account_to;
    String transaction_date;
   String transaction_type;
   int amont;
   long currentbalance;

    public long getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(long currentbalance) {
        this.currentbalance = currentbalance;
    }

    public int getAmont() {
        return amont;
    }

    public void setAmont(int amont) {
        this.amont = amont;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public int getTransactions_id() {
        return Transactions_id;
    }

    public void setTransactions_id(int Transactions_id) {
        this.Transactions_id = Transactions_id;
    }

    public int getAccount_from() {
        return account_from;
    }

    public void setAccount_from(int account_from) {
        this.account_from = account_from;
    }

    public int getAccount_to() {
        return account_to;
    }

    public void setAccount_to(int account_to) {
        this.account_to = account_to;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }
}
