package com.example.jmp.cloud.service.impl;


import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;
import com.example.jmp.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CloudServiceImpl implements Service {
    private final Map<String, Subscription> subscriptions = new HashMap<>();
    private final List<User> users = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {
        var subscription = new Subscription(bankCard.getNumber(), LocalDate.now());
        subscriptions.put(bankCard.getNumber(), subscription);
        if (!users.contains(bankCard.getUser())) {
            users.add(bankCard.getUser());
        }
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return Optional.ofNullable(subscriptions.get(cardNumber));
    }

    @Override
    public List<User> getAllUsers() {
        return users.stream().collect(Collectors.toUnmodifiableList()); // Task 20
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
        return subscriptions.values().stream().filter(condition).collect(Collectors.toUnmodifiableList()); // Task 20
    }
}