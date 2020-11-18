package com.demo.backend.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.backend.model.entity.Producto;
import com.demo.backend.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping(value = "/")
	public List<Producto> allProduct(){
		return productoService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Producto productId(@PathVariable String id){
		return productoService.findProducto(id);
	}
	
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto register(@RequestBody Producto producto){
		return productoService.register(producto);
	}
	
	@PutMapping(value = "/update")
	public Producto update(@RequestBody Producto producto){
		return productoService.register(producto);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public Producto delete(@PathVariable String id){
		return productoService.delete(id);
	}
	
	

}
