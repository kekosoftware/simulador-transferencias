package com. kekosoftware.transferencias;

import org.springframework.boot.SpringApplication;
import org. springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransferenciasApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TransferenciasApplication.class, args);
    }
}