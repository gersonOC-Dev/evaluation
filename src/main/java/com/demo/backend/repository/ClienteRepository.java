package com.demo.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.backend.model.entity.Cliente;
import com.demo.backend.model.entity.Venta;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

	
}
