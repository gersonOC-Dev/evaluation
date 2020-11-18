package com.demo.backend.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.backend.dao.IVentaDao;
import com.demo.backend.model.entity.Venta;
import com.demo.backend.repository.VentaRepository;

import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class VentaDaoImpl implements IVentaDao{
	
	@Autowired
	private VentaRepository ventaRepository;

	@Override
	public List<Venta> findAll() {	
		return ventaRepository.findAll();
	}

	@Override
	public Venta register(Venta venta) {
		return ventaRepository.save(venta);
	}

	@Override
	public Single<Venta> findId(String id) {
		return  Single.just(ventaRepository.findById(id).get())
				.doOnError(error -> log.error("Error in FinID Producto", error))
				.onErrorResumeNext(Single.error(new Throwable()));
	}

	
}
