package com.trabajo.web.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trabajo.web.entity.Carrera;
import com.trabajo.web.model.request.CarreraRequest;
import com.trabajo.web.model.response.CarreraResponse;

@Component
public class CarreraConverter {
	
	public CarreraResponse entityToModel(Carrera entity){
		CarreraResponse carrera = new CarreraResponse();
		carrera.setId(entity.getId());
		carrera.setDescripcion(entity.getDescripcion());
		return carrera;
	}
	
	public List<CarreraResponse> entitiesToModels(List<Carrera>entities){
		List<CarreraResponse> carreras = new ArrayList<>();
		for (Carrera carrera : entities) {
			carreras.add(entityToModel(carrera));
		}
		return carreras;
	}
	
	public Carrera modelToEntity(Integer model) {
		Carrera carrera = new Carrera();
		carrera.setId(model);
//		carrera.setDescripcion(model.getDescripcion());
		return carrera;
	}
}
