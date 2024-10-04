package com.example.clase6gtics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.tool.schema.extract.spi.SequenceInformation;

import java.io.Serializable;

@Embeddable
public class Peliculasdirectores implements Serializable {


        @Column(name = "peliculaId", nullable = false)
        private Integer peliculaid;

        @Column(name = "directorId", nullable = false)
        private Integer directorid;



}
