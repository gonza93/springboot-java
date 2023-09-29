package com.escuela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuela.entity.ProfesorEntity;

public interface ProfesorRepository extends JpaRepository<ProfesorEntity, Integer> {}
