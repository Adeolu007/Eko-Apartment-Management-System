package com.emperor.Eko.Apartment.rental.system.repository;

import com.emperor.Eko.Apartment.rental.system.entity.Admin;
import com.emperor.Eko.Apartment.rental.system.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {

}
