package com.example.jmp.cloud.bank.impl;

import com.example.jmp.bank.Bank;
import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.BankCardType;
import com.example.jmp.dto.User;

public class InvestmentBank implements Bank{
    @Override
    public BankCard createBankCard(User user, BankCardType type) {
        BankCard bankCard = null;
        switch (type) {
            case CREDIT:
                bankCard = new BankCard("InvestCardCredit#123", user);
                break;
            case DEBIT:
                bankCard = new BankCard("InvestCardDebit#456", user);
                break;
        }
        return bankCard;}
}
