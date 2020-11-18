package com.demo.backend.service;

import java.util.List;

import com.demo.backend.model.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto findProducto(String id);
	public Producto delete(String id);
	
	public Producto update(Producto prod);
	
	public Producto register(Producto prod);

}
