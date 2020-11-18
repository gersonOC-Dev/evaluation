package com.demo.backend.dao;

import java.util.List;

import com.demo.backend.model.entity.Venta;

import io.reactivex.Single;

public interface IVentaDao {
	
	
	public List<Venta> findAll();
	
	public Venta register(Venta venta);
	
	public Single<Venta> findId(String id);

}
