package com.project.KoiBookingSystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.KoiBookingSystem.enums.AuthorizationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class AuthorizationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Pattern(regexp = "^\\d{6}$", message = "Invalid authorization code!")
    private String code;

    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "username", nullable = false)
    private Account account;

    @Enumerated(EnumType.STRING)
    private AuthorizationType type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime expirationDate;

    @Column(nullable = false)
    private boolean expired;

    public boolean authorizationCodeExpired() {
        return this.expired || LocalDateTime.now().isAfter(expirationDate);
    }
}
