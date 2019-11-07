package com.company.transaction;

import com.company.users.User;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private User from;
    private User to;
    private double ammount;

    public Transaction(User userFrom, User userTo, double ammount) {
        this.from = userFrom;
        this.to = userTo;
        this.ammount = ammount;
    }
    private boolean isValid(){
        return to != null && from != null && from.getBalance() + from.getCredit() >= ammount;
    }
    public List<User> execute(){
        List<User> participants = new ArrayList<>();
        if (isValid()){
            if(from.getBalance()-ammount < 0){
                double balance = from.getBalance();
                from.setBalance(0);
                from.setCredit(from.getCredit() + (balance - ammount));
            }else {
                from.setBalance(from.getBalance()-ammount);
            }
            to.setBalance(to.getBalance()+ammount);
        }else{
            System.out.println("Error, nevalidi transakcija");
        }
        participants.add(from);
        participants.add(to);
        return participants;
    }
}
