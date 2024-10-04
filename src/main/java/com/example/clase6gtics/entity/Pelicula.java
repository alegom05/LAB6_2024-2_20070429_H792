package com.example.clase6gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="peliculaId")
    private Integer peliculaid;

    private String titulo;

    private String fechaestreno;

    private String duracionminutos;
}
