package com.demo.backend.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.backend.model.entity.Venta;
import com.demo.backend.service.IVentaService;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/venta")
@Slf4j
public class VentaController {
	
	@Autowired
	private IVentaService ventaService;
	
	@GetMapping(value = "/")
	public List<Venta> allVenta(){
		return ventaService.findAll();
	}
	
	
	@PostMapping(value = "/register")
	public Venta register(@RequestBody Venta venta){
		return ventaService.register(venta);
	}
	
	@GetMapping(value = "/{id}")
	public Single<Venta> findId(@PathVariable String id) {
		return ventaService.findId(id);
	}

}
