package com.example.jmp.dto;

import java.time.LocalDate;

public class Subscription {
    private String bankcardNumber;
    private LocalDate startDate;

    public Subscription(String bankcardNumber, LocalDate startDate) {
        this.bankcardNumber = bankcardNumber;
        this.startDate = startDate;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "bankcardNumber='" + bankcardNumber + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}