package com.demo.backend.dao.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.backend.dao.IProductDao;
import com.demo.backend.model.entity.Producto;
import com.demo.backend.repository.ProductoRepository;

@Component
public class ProductoDaoImpl implements IProductDao{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {	
		return productoRepository.findAll();
	}

	public Producto delete(String id) {
		Optional<Producto> prod = productoRepository.findById(id);
		productoRepository.delete(prod.get());
		return prod.get();
	}

	@Override
	public Producto findProducto(String id) {
		return productoRepository.findId(Integer.parseInt(id));
	}

	@Override
	public Producto update(Producto prod) {
		try {
			Optional<Producto> producto = productoRepository.findById(prod.getId());
			if (producto.isPresent()) {
				return productoRepository.save(prod);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return null;
		
	}

	@Override
	public Producto register(Producto prod) {
		
		return productoRepository.save(prod);
	}
}
