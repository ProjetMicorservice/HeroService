package com.example.hero_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    private int eggCount;

    private int incubatorCount;

    @OneToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;
}
