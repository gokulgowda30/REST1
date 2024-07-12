package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.Entity_DTO.Admin;
//We extend the JPA Repository(I) because it consist of all methods such as save ,saveall,so we can use this methods to perform CRUD operations on the data
@Component
public interface AdminRepository extends JpaRepository<Admin,Integer> {

	 List<Admin> findByEmail(String email);

}
