package com.trabajo.web.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trabajo.web.entity.Alumno;
import com.trabajo.web.model.request.AlumnoRequest;
import com.trabajo.web.model.response.AlumnoResponse;
import com.trabajo.web.service.CarreraService;

@Component
public class AlumnoConverter {
	@Autowired
	private CarreraConverter carreraConverter;
	
	@Autowired
	private CarreraService carreraService;
	
	public AlumnoResponse entityToModel(Alumno entity){
		
		if(entity == null) {
			return null;
		}
		
		AlumnoResponse alumno= new AlumnoResponse();
		alumno.setId(entity.getId());
		alumno.setNombre(entity.getNombre());
		alumno.setApellido(entity.getApellido());
		alumno.setCedula(entity.getCedula());
		alumno.setCarreraId(carreraConverter.entityToModel((entity.getCarreraId())));
		return alumno;
		}
	
	public List<AlumnoResponse> entitiesToModels(List<Alumno> entities){
		List<AlumnoResponse> alumnos=new ArrayList<>();
		for (Alumno alumno : entities) {
			alumnos.add(entityToModel(alumno));
		}
		return alumnos;
	}
	
	public Alumno modelToEntity(AlumnoRequest model) {
		
		if(model == null) {
			return null;
		}
		
		Alumno alumno = new Alumno();
		alumno.setId(model.getId());
		alumno.setNombre(model.getNombre());
		alumno.setApellido(model.getApellido());
		alumno.setCedula(model.getCedula());
		alumno.setCarreraId(carreraService.findById(model.getCarreraId()));
		return alumno;
	}
}
