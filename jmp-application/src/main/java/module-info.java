module com.example.jmp.application {
    uses com.example.jmp.bank.Bank;
    uses com.example.jmp.service.Service;
    requires com.example.jmp.cloud.bank.impl;
    requires com.example.jmp.cloud.service.impl;
    requires com.example.jmp.dto;
    requires com.example.jmp.bank.api;
    requires com.example.jmp.service.api;
}