package com.trabajo.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trabajo.web.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	@Query("select A from Alumno A where UPPER(A.nombre) like UPPER(:name) ")
	public List<Alumno> findName(@Param("name") String name);
	
	@Query("select A from Alumno A where UPPER(A.apellido) like UPPER(:name) ")
	public List<Alumno> findLastName(@Param("name") String name);
}
