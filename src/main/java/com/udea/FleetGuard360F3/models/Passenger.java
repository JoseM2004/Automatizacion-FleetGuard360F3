package com.udea.FleetGuard360F3.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    private String firstName;
    private String lastName;
    private String username;
    private String documentType;
    private String documentNumber;
    private String phone;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean acceptTerms;
}