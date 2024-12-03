package com.practice.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MyResponse {
    private String message;
    private LocalDateTime time;

    public MyResponse(String message) {
        this.message = message;
        this.time = LocalDateTime.now();
    }
}

// Создать отдельный проект
// - создать модуль order-server
//   - создать класс model.Order(String user, String address, Payment payment)
//   - создать контроллер OrderController
//     - POST /orders - создание заказа (на вход передается в теле user и address)
//     - GET /orders - получения списка заказов

// - создать модуль payment-server
//   - создать класс model.Payment(boolean paid, LocalDateTime time)
//   - создать контроллер PaymentController
//     - GET /payment - который возвращает объект Payment
//     {
//          "paid": true,
//          "time": "2024-12-03T15:30"
//     }
