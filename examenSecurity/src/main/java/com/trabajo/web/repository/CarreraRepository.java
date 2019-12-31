package com.trabajo.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trabajo.web.entity.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

}
