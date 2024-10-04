package com.example.clase6gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "directores")
@Table
@Getter
@Setter
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer directorid;


    private String nombre;
    private String telefono;
    private String nacionalidad;
}
