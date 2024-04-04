package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.UserService;
import com.turkcell.rentacar.business.dtos.requests.registers.RegisterUserRequest;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.UserRepository;
import com.turkcell.rentacar.entities.concretes.User;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private  final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterUserRequest request) {
        User user = modelMapperService.forRequest().map(request,User.class);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        //Kullanıcnın girdiği şifrenin encode edilmiş bir şekilde gelmesini sağlar.

        user.setPassword(encodedPassword); //Mapper requestteki passwordü alıp birebir aynı şekilde user içine aktardığı için
        // passwordü  yeniden set etmeliyiz mapperdaki gibi kullanmamalıyız.
        userRepository.save(user);


        //Aynı emaille ikinci kullanıcnın eklenmemesi
        //Kullanıcının emaili doğru formatta girmesi
        //Şifrenin en az şu kadar hane ve karakterlerden de oluşması? yapılabilir
    }
}
