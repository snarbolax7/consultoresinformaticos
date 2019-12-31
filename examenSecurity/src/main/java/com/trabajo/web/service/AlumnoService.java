package com.trabajo.web.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trabajo.web.converter.AlumnoConverter;
import com.trabajo.web.entity.Alumno;
import com.trabajo.web.model.request.AlumnoRequest;
import com.trabajo.web.model.response.AlumnoResponse;
import com.trabajo.web.repository.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private AlumnoConverter alumnoConverter;

	public List<AlumnoResponse> getAll() {
		List<Alumno> alumnos = alumnoRepository.findAll();

		if (alumnos != null && !alumnos.isEmpty()) {
			return alumnoConverter.entitiesToModels(alumnos);
		}
		return null;
	}

	public AlumnoResponse save(AlumnoRequest model) {
		try {
			Alumno alumno = new Alumno();
			if (model != null) {
				alumno = alumnoConverter.modelToEntity(model);
				alumnoRepository.save(alumno);
			}
			return alumnoConverter.entityToModel(alumno);
		} catch (Exception e) {
			return null;
		}
	}

	public AlumnoResponse updateOne(AlumnoRequest model) {
		Alumno alumno = alumnoRepository.findById(model.getId()).get();
		if (alumno == null) {
			return null;
		}
		alumno = alumnoConverter.modelToEntity(model);
		alumno = alumnoRepository.save(alumno);
		return alumnoConverter.entityToModel(alumno);
	}

	public AlumnoResponse deleteOne(Integer Id) {
		AlumnoResponse alumno = new AlumnoResponse();
		alumno = alumnoConverter.entityToModel(alumnoRepository.findById(Id).get());
		if (alumno == null) {
			return null;
		}
		alumnoRepository.deleteById(alumno.getId());
		return alumno;
	}

	public AlumnoResponse findOne(Integer Id) {
		if (Id != null && Id > 0) {
			AlumnoResponse alumno = new AlumnoResponse();
			return alumno = alumnoConverter.entityToModel(alumnoRepository.findById(Id).get());
		}
		return null;
	}

	public List<AlumnoResponse> findName(String name) {
		List<AlumnoResponse> alumnoList = new ArrayList<AlumnoResponse>();
		alumnoList = alumnoConverter.entitiesToModels((alumnoRepository.findName(name)));
		return alumnoList;
	}

	public List<AlumnoResponse> findLastName(String name) {
		List<AlumnoResponse> alumnoList = new ArrayList<AlumnoResponse>();
		alumnoList = alumnoConverter.entitiesToModels((alumnoRepository.findLastName(name)));
		return alumnoList;
	}

}
