package com.example.clase6gtics.repository;

import com.example.clase6gtics.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

    Optional<Pelicula> findById(Integer id);


}

