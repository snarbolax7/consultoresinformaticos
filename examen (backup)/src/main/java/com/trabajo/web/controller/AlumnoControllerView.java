package com.trabajo.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PrePersist;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trabajo.web.model.request.AlumnoRequest;
import com.trabajo.web.model.response.AlumnoResponse;
import com.trabajo.web.model.response.CarreraResponse;
import com.trabajo.web.repository.AlumnoRepository;
import com.trabajo.web.repository.CarreraRepository;
import com.trabajo.web.service.AlumnoService;
import com.trabajo.web.service.CarreraService;

@Controller
public class AlumnoControllerView {
	@Autowired
	AlumnoService alumnoService;
	@Autowired
	CarreraService carreraService;
	@Autowired
	CarreraRepository carreraRepository;
	@Autowired
	AlumnoRepository alumnoRepository;

	@GetMapping(value = "/stform/{id}")
	public String getOne(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash) {

		if (id == 0) {
			AlumnoRequest alumno = new AlumnoRequest();
			model.addAttribute("alumno", alumno);
			List<CarreraResponse> carreras = new ArrayList<CarreraResponse>();
			carreras = carreraService.getAll();
			model.addAttribute("carreras", carreras);
			flash.addFlashAttribute("message", "success");
			return "redirect:/stform";
			
		} else {
			AlumnoResponse alumno = new AlumnoResponse();
			CarreraResponse alumnoCarrera = new CarreraResponse();
			List<CarreraResponse> carreras = new ArrayList<CarreraResponse>();
			List<CarreraResponse> carrerasOrdenadas = new ArrayList<CarreraResponse>();

			carreras = carreraService.getAll();
			alumno = alumnoService.findOne(id);
			alumnoCarrera = carreraService.findOne(alumno.getCarreraId());

			for (int i = 0; i < carreras.size(); i++) {

				if (carreras.get(i).getId().equals(alumnoCarrera.getId())) {

					CarreraResponse aux = new CarreraResponse();
					aux = alumnoCarrera;
					carreras.remove(i);
					carrerasOrdenadas.add(aux);
					carrerasOrdenadas.addAll(carreras);
					break;
				}
			}

			model.addAttribute("alumno", alumno);
			model.addAttribute("carreras", carrerasOrdenadas);
			model.addAttribute("modo", "editar");
			return "form";
		}
	}

	@GetMapping(value = "/view")
	public String list(Model model) {
		List<AlumnoResponse> alumnos = new ArrayList<AlumnoResponse>();
		alumnos = alumnoService.getAll();
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("modo", "crear");
		return "list";
	}

	@GetMapping(value = "/stform")
	public String form(Model model) {
		AlumnoRequest alumno = new AlumnoRequest();
		model.addAttribute("alumno", alumno);
		List<CarreraResponse> carreras = new ArrayList<CarreraResponse>();
		carreras = carreraService.getAll();
		model.addAttribute("carreras", carreras);
		return "form";
	}

//	@PostMapping(value = "/stform")
//	public String save(@ModelAttribute(name = "alumno") AlumnoRequest alumno, Model model, RedirectAttributes flash,
//			SessionStatus status) {
//		if (null == alumnoService.save(alumno)) {
//
//			if (alumno.getNombre().length() < 2 || alumno.getNombre().length() > 45 || alumno.getNombre().isEmpty()) {
//				flash.addFlashAttribute("nombre", 1);
//			}
//			if (alumno.getApellido().length() < 2 || alumno.getApellido().length() > 45 || alumno.getApellido().isEmpty()) {
//				flash.addFlashAttribute("apellido", 1);
//			}
//			if (alumno.getCedula().length() < 2 || alumno.getCedula().length() > 45 || alumno.getCedula().isEmpty()) {
//				flash.addFlashAttribute("cedula", 1);
//			}
//
//			flash.addFlashAttribute("alumno", alumno);
//			flash.addFlashAttribute("carreras", carreraService.getAll());
//			flash.addFlashAttribute("error", "Alumno no pudo ser creado");
//			return "form";
//
//		} else {
//			status.setComplete();
//			flash.addFlashAttribute("success", "Alumno fue creado con C.I.: "+ alumno.getCedula());
//			return "redirect:/view";
//		}
//
//	}

	@GetMapping("/search")
	public String search(@RequestParam("name") String name, Model model) {
		List<AlumnoResponse> alumnoList = alumnoService.findName(name);
		if (!alumnoList.isEmpty()) {
			model.addAttribute("alumnos", alumnoList);
			return "list";
		} else {
			alumnoList = alumnoService.findLastName(name);
			model.addAttribute("alumnos", alumnoList);
			return "list";
		}
	}

	@Transactional
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes flash) {
		flash.addFlashAttribute("info", "Alumno fue eliminado exitosamente con C.I.: " + alumnoService.findOne(id).getCedula());
		alumnoService.deleteOne(id);
		return "redirect:/view";
	}

//	@GetMapping(value = "/stform/recuperar/{id}")
//	public String getOneDelete(@PathVariable(value = "id") Integer id, Model model) {
//		model.addAttribute("idRecuperado", id);
//		List<AlumnoResponse> alumnos = new ArrayList<AlumnoResponse>();
//		alumnos = alumnoService.getAll();
//		model.addAttribute("alumnos", alumnos);
//		model.addAttribute("modal", false);
//		return "list";
//	}

}
