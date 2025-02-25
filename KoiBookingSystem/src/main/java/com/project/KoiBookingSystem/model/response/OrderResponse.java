package com.project.KoiBookingSystem.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.KoiBookingSystem.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class OrderResponse {

    private String orderId;

    private String customerId;

    private String tourId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime orderDate;

    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String note;

    private List<OrderDetailResponse> orderDetails;
}
