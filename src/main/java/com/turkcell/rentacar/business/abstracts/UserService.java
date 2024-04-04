package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.registers.RegisterUserRequest;

public interface UserService {
    void register(RegisterUserRequest request);
}
