package com.company.users;

import java.util.Random;

public class User {
    private String name;
    double balance;
    double credit;
    String acc;

    public User(String name, double balance, double credit) {
        this.name = name;
        this.balance = balance;
        this.credit = credit;
        Random random = new Random();
        this.acc = "LT" + 4200 + random.nextInt(999999 - 100000) + 200;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAcc() {
        return acc;
    }

    public void topUp(double balance) {
        this.balance += balance;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", acc='" + acc + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
