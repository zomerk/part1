package com.example.jmp.service;

import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service {
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);
    List<User> getAllUsers();

    default double getAverageUsersAge() {
        return getAllUsers().stream()
                .mapToLong(user -> ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()))
                .average()
                .orElse(0);
    }

    static boolean isPayableUser(User user) {
        var age = ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now());
        return age >= 18;
    }

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition);
}
