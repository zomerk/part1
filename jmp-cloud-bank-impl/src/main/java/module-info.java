module com.example.jmp.cloud.bank.impl {
    requires transitive com.example.jmp.bank.api;
    requires com.example.jmp.dto;
    exports com.example.jmp.cloud.bank.impl;
    provides com.example.jmp.bank.Bank with com.example.jmp.cloud.bank.impl.RetailBank, com.example.jmp.cloud.bank.impl.InvestmentBank, com.example.jmp.cloud.bank.impl.CentralBank;
}