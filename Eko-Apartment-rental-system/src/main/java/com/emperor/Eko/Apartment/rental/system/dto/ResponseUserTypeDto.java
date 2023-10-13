package com.emperor.Eko.Apartment.rental.system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseUserTypeDto {

    private String message;
    private String userTypeId;
    private String userName;
}
