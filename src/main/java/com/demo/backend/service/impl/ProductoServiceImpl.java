package com.demo.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.backend.dao.IProductDao;
import com.demo.backend.dao.IVentaDao;
import com.demo.backend.model.entity.Producto;
import com.demo.backend.model.entity.Venta;
import com.demo.backend.service.IProductoService;
import com.demo.backend.service.IVentaService;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductDao productDao;

	@Override
	public List<Producto> findAll() {
		return productDao.findAll();
	}

	@Override
	public Producto findProducto(String id) {
		
		return productDao.findProducto(id);
	}

	@Override
	public Producto delete(String id) {
		
		return productDao.delete(id);
	}

	@Override
	public Producto update(Producto prod) {
		// TODO Auto-generated method stub
		return productDao.update(prod);
	}

	@Override
	public Producto register(Producto prod) {
		// TODO Auto-generated method stub
		return productDao.register(prod);
	}
	
	

}
