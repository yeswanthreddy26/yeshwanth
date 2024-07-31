package com.example.level.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.level.model.item;


public interface itemRepository extends JpaRepository<item , Integer>
{

}
