package com.demo.backend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.backend.dao.IClienteDao;
import com.demo.backend.model.entity.Cliente;
import com.demo.backend.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDao clientDao;

	@Override
	public Cliente register(Cliente cliente) {
		return clientDao.register(cliente);
	}

}
