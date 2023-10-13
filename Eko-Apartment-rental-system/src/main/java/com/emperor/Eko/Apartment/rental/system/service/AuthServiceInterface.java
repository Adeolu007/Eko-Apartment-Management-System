package com.emperor.Eko.Apartment.rental.system.service;

import com.emperor.Eko.Apartment.rental.system.dto.ResponseDto;
import com.emperor.Eko.Apartment.rental.system.dto.UserLoginDto;
import com.emperor.Eko.Apartment.rental.system.dto.UserRegisterDto;
import org.springframework.http.ResponseEntity;

public interface AuthServiceInterface {

    ResponseEntity<ResponseDto> registerUser(UserRegisterDto userRegister);
    ResponseEntity<ResponseDto> loginUser(UserLoginDto userLoginDto);
}
