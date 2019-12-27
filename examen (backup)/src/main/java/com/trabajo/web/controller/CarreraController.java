package com.trabajo.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.trabajo.web.model.response.CarreraResponse;
import com.trabajo.web.service.CarreraService;

@RestController
@RequestMapping(value = "/carreras")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;

	@GetMapping
	public ResponseEntity<?> getAll() {

		try {
			List<CarreraResponse> carreras = carreraService.getAll();
			if (carreras != null) {
				return new ResponseEntity<>(carreras, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
