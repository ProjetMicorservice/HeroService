package com.example.hero_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "heros")
public class Hero{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long heroId;

    private String heroName;

    private int level;

    private int experience;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
