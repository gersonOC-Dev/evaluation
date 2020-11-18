package com.demo.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.backend.model.entity.Cliente;
import com.demo.backend.service.IClienteService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping(value = "/register")
	public Cliente register(@RequestBody Cliente cliente) {
		return clienteService.register(cliente);
	}
	

}
