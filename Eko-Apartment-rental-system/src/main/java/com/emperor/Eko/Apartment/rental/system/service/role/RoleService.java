package com.emperor.Eko.Apartment.rental.system.service.role;

import com.emperor.Eko.Apartment.rental.system.dto.ResponseUserTypeDto;
import com.emperor.Eko.Apartment.rental.system.entity.Admin;
import com.emperor.Eko.Apartment.rental.system.entity.Owner;
import com.emperor.Eko.Apartment.rental.system.entity.RoleEnum;
import com.emperor.Eko.Apartment.rental.system.entity.UserType;
import com.emperor.Eko.Apartment.rental.system.repository.AdminRepository;
import com.emperor.Eko.Apartment.rental.system.repository.OwnerRepository;
import com.emperor.Eko.Apartment.rental.system.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleService implements RoleServiceInterface {
    private UserRepository userRepository;
    private AdminRepository adminRepository;
    private OwnerRepository ownerRepository;


    @Override
    public ResponseUserTypeDto assignAdminRole(Long userId) {
        UserType userType = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        //why do we have 2 usertype
        userType.getRoleEnums().add(RoleEnum.ADMIN);
        Admin admin = Admin.builder()
                .userType(userType)
                .build();

        adminRepository.save(admin);
        userType.setAdmin(admin);
        userRepository.save(userType);

        return ResponseUserTypeDto.builder()
                .message("Participant role successfully assigned to user")
                .userTypeId(admin.getAdminId())
                .userName(userType.getUsername())
                .build();
    }

    @Override
    public ResponseUserTypeDto assignOwnerRole(Long userId) {
        UserType userType = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userType.getRoleEnums().add(RoleEnum.OWNER);

        Owner owner = Owner.builder()
                .userType(userType)
                .build();
        ownerRepository.save(owner);
        userType.setOwner(owner);
        userRepository.save(userType);

        return ResponseUserTypeDto.builder()
                .message("Examiner role successfully assigned to user")
                .userTypeId(owner.getOwnerId())
                .userName(userType.getUsername())
                .build();
    }
}
