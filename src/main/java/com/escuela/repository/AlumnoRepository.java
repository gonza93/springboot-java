package com.escuela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escuela.entity.AlumnoEntity;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Integer> {}
