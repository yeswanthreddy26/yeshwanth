package com.example.exam3.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam3.model.gadgets;

public interface gadgetsRepository extends JpaRepository<gadgets  , Integer> {

}
