module com.example.jmp.cloud.service.impl {
    requires transitive com.example.jmp.service.api;
    requires com.example.jmp.dto;
    exports com.example.jmp.cloud.service.impl;
    provides com.example.jmp.service.Service with com.example.jmp.cloud.service.impl.CloudServiceImpl;
}