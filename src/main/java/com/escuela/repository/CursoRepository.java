package com.escuela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escuela.entity.CursoEntity;

@Repository
public interface CursoRepository extends JpaRepository<CursoEntity, Integer> { }
