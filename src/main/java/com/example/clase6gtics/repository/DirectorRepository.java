package com.example.clase6gtics.repository;

import com.example.clase6gtics.entity.Director;
import com.example.clase6gtics.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {

}

