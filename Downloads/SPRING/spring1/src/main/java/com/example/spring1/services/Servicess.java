package com.example.spring1.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring1.model.InternationalOrg;

public interface Servicess extends JpaRepository<InternationalOrg , Integer>
{

}
