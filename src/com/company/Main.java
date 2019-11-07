package com.company;

import com.company.transaction.Transaction;
import com.company.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int input;
        List<User> users = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            printMenu();
            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Kuriame vartotoją...");
                    System.out.println("Įveskite savo vardą");
                    String name = sc.next();

                    System.out.println("Įveskite savo balansą");
                    double balance = sc.nextDouble();

                    System.out.println("Įveskite savo creditą");
                    double credit = sc.nextDouble();

                    User user = new User(name, balance, credit);
                    users.add(user);
                    break;
                case 2:
                    int i = 0;
                    System.out.println("Peržiūrim vartotojus.");
                    printUsers(users);
                    break;
                case 3:
                    System.out.println("Ištrinti vartotoją.");
                    printUsers(users);
                    System.out.println("Įveskite vartotojo indeksą");
                    int x = sc.nextInt();
                    users.remove(x);
                    break;
                case 4:
                    System.out.println("Išrinkite vartotojus kuriems daryti pavedimą");
                    printUsers(users);
                    System.out.println("Įveskite sąskaitos nr iš kurios darysit pavedimą");
                    String accfrom = sc.next();
                    System.out.println("Įveskite sąskaitos nr į kurią darysit pavedimą");
                    String accto = sc.next();
                    System.out.println("Įveskite pavedimo sumą");
                    double ammount = sc.nextDouble();
                    User from = null;
                    User to = null;
                    for (User u : users) {
                        if (u.getAcc().equals(accfrom)) {
                            from = u;
                        }
                        if (u.getAcc().equals(accto)) {
                            to = u;
                        }
                    }
                    users.remove(from);
                    users.remove(to);
                    Transaction transaction = new Transaction(from, to, ammount);
                    List<User> transactedUsers = transaction.execute();

                    users.addAll(transactedUsers);

                    break;
                case 5:
                    printUsers(users);
                    System.out.println("Įveskite sąskaitos nr kuriam norite papildyti sąskaitą");
                    String injectinto = sc.next();
                    System.out.println("Įveskite sumą");
                    double sum = sc.nextDouble();
                    User toinject = null;
                    for (User u : users) {
                        if (u.getAcc().equals(injectinto)) {
                            toinject = u;
                        }
                    }
                    if(toinject != null) {
                        toinject.topUp(sum);
                    }else{
                        System.out.println("Bloga sąskaita");
                    }
                    break;
                case 0:
                    System.out.println("Programos pabaiga.");
                    break;
                default:
                    System.out.println("Bloga įvestis");
            }
        } while (input != 0);


    }

    public static void printMenu() {
        System.out.println("1. Sukurti vartotoją");
        System.out.println("2. Peržiūrėti vartotojus");
        System.out.println("3. Ištrinti vartotoją.");
        System.out.println("4. Atlikti pavedimą.");
        System.out.println("5. Papildyti sąskaitą.");
        System.out.println("0. Baigti.");
        System.out.println("|-------------------------|");
    }

    public static void printUsers(List<User> users) {
        int i = 0;
        for (User u : users) {
            System.out.println(i + ": " + u.toString());
            i++;
        }
    }
}
