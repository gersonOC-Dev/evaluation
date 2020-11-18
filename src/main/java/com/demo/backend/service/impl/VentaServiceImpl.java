package com.demo.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.backend.dao.IVentaDao;
import com.demo.backend.model.entity.Venta;
import com.demo.backend.service.IVentaService;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import sun.util.logging.resources.logging;

@Service
@Slf4j
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IVentaDao ventaDao;

	@Override
	public List<Venta> findAll() {
		return ventaDao.findAll();
	}

	@Override
	public Venta register(Venta venta) {
		// TODO Auto-generated method stub
		return ventaDao.register(venta);
	}

	@Override
	public Single<Venta> findId(String id) {
		// TODO Auto-generated method stub
		return ventaDao.findId(id)
				.doOnSuccess(res -> log.info("Find Venta success"));
	}

}
