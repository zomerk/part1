package com.example.jmp.application;

import com.example.jmp.bank.Bank;
import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.BankCardType;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;
import com.example.jmp.service.Service;

import java.time.LocalDate;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        var bankLoader = ServiceLoader.load(Bank.class);
        Bank bank = bankLoader.findFirst().orElseThrow(() -> new RuntimeException("No Bank implementation found"));
        bankLoader.forEach(System.out::println);
        var serviceLoader = ServiceLoader.load(Service.class);
        Service service = serviceLoader.findFirst().orElseThrow(() -> new RuntimeException("No Service implementation found"));

        var user1 = new User("John", "Doe", LocalDate.of(1990, 5, 15));
        var user2 = new User("Jane", "Smith", LocalDate.of(2005, 10, 20));

        var creditCard = bank.createBankCard(user1, BankCardType.CREDIT);
        var debitCard = bank.createBankCard(user2, BankCardType.DEBIT);

        service.subscribe(creditCard);
        service.subscribe(debitCard);

        System.out.println("All Users: " + service.getAllUsers());
        System.out.println("Subscription for " + creditCard.getNumber() + ": " + service.getSubscriptionByBankCardNumber(creditCard.getNumber()));
        System.out.println("Subscription for " + debitCard.getNumber() + ": " + service.getSubscriptionByBankCardNumber(debitCard.getNumber()));
        System.out.println("Subscription for non-existent card: " + service.getSubscriptionByBankCardNumber("NON-EXISTENT"));

        System.out.println("Average Users Age: " + service.getAverageUsersAge());
        System.out.println(user1.getName() + " is payable: " + Service.isPayableUser(user1));
        System.out.println(user2.getName() + " is payable: " + Service.isPayableUser(user2));

        System.out.println("Subscriptions starting before 2026: " + service.getAllSubscriptionsByCondition(sub -> sub.getStartDate().isBefore(LocalDate.of(2026, 1, 1))));

        try {
            service.getSubscriptionByBankCardNumber("NON-EXISTENT").orElseThrow(() -> new SubscriptionNotFoundException("Subscription not found!"));
        } catch (SubscriptionNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}