package com.emperor.Eko.Apartment.rental.system.service.role;

import com.emperor.Eko.Apartment.rental.system.dto.ResponseUserTypeDto;

public interface RoleServiceInterface {

    ResponseUserTypeDto assignAdminRole(Long userId);

    ResponseUserTypeDto assignOwnerRole(Long userId);
}
