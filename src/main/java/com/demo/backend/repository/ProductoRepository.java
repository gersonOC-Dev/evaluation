package com.demo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.backend.model.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String>{

	@Query(value="Select * from producto  where id_producto = ?1",nativeQuery =true)
	Producto findId( int id);
}
