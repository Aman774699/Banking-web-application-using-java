/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customers;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class account_holder {

    public String getNet_banking() {
        return Net_banking;
    }

    public void setNet_banking(String Net_banking) {
        this.Net_banking = Net_banking;
    }

    long account_no, balance;
    String Firstname, lastname, address, phonenumber, Acount_type, E_mail, DOB,Net_banking;

    public String getDOB() {
        return DOB;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String E_mail) {
        this.E_mail = E_mail;
    }

    public long getAccount_no() {
        return account_no;
    }

    public void setAccount_no(long account_no) {
        this.account_no = account_no;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "account_holder{" + "account_no=" + account_no + ", balance=" + balance + ", Firstname=" + Firstname + ", lastname=" + lastname + ", address=" + address + ", phonenumber=" + phonenumber + ", Acount_type=" + Acount_type + ", E_mail=" + E_mail + ", DOB=" + DOB + '}';
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAcount_type() {
        return Acount_type;
    }

    public void setAcount_type(String Acount_type) {
        this.Acount_type = Acount_type;
    }

}
