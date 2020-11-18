package com.demo.backend.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.backend.dao.IClienteDao;
import com.demo.backend.dao.IProductDao;
import com.demo.backend.dao.IVentaDao;
import com.demo.backend.model.entity.Cliente;
import com.demo.backend.model.entity.Producto;
import com.demo.backend.model.entity.Venta;
import com.demo.backend.repository.ClienteRepository;
import com.demo.backend.repository.ProductoRepository;
import com.demo.backend.repository.VentaRepository;

@Component
public class ClienteDaoImpl implements IClienteDao{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente register(Cliente cliente) {	
		return clienteRepository.save(cliente);
	}

}
