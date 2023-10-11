package com.emperor.Eko.Apartment.rental.system.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private String ownerId;
    @OneToOne
    @JoinColumn(name = "user_entity_id")
    private UserType userType;
}
