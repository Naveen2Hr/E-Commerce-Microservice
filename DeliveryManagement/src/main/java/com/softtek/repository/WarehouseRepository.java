package com.softtek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

}
