package com.trabajo.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trabajo.web.converter.CarreraConverter;
import com.trabajo.web.entity.Carrera;
import com.trabajo.web.model.response.AlumnoResponse;
import com.trabajo.web.model.response.CarreraResponse;
import com.trabajo.web.repository.CarreraRepository;

@Service
public class CarreraService {
	@Autowired
	private CarreraRepository carreraRepository;
	@Autowired
	private CarreraConverter carreraConverter;
	
	public List<CarreraResponse> getAll(){
		List<Carrera> carreras = carreraRepository.findAll();
		
		if(carreras !=  null && !carreras.isEmpty()) {
			return carreraConverter.entitiesToModels(carreras);
		}
		return null;
	}

	public CarreraResponse findOne(CarreraResponse carrera) {
		if(carrera != null) {
			CarreraResponse model = new CarreraResponse();
			model = carreraConverter.entityToModel(carreraRepository.findById(carrera.getId()).get());
			return model;
		}
		return null;
	}
	
	public Carrera findById(Integer id) {
		if(id != null) {
			Carrera entity = new Carrera();
			entity = carreraRepository.findById(id).get();
			return entity;
		}
		return null;
	}
	
}
