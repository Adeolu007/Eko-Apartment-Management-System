package com.emperor.Eko.Apartment.rental.system.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Viewer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true)
    private String viewerId;
    @OneToOne
    @JoinColumn(name = "user_entity_id")
    private UserType userType;
}
