package com.example.page.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.page.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	User findByEmail (String email);

	boolean existsByEmail(String email);
}
