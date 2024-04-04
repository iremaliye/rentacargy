package com.turkcell.rentacar.business.dtos.requests.registers;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegisterUserRequest {

    private String email;
    private String password;
    private LocalDate birthDate;

}
