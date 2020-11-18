package com.demo.backend.service;

import java.util.List;

import com.demo.backend.model.entity.Venta;

import io.reactivex.Single;

public interface IVentaService {
	
	public List<Venta> findAll();
	
	public Venta register(Venta venta);
	
	public Single<Venta> findId(String id);

}
