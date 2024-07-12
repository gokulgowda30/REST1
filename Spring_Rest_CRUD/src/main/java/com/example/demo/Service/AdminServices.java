package com.example.demo.Service;

//We use service layer because we write all the Bussiness logics here and then map to the controller layer 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity_DTO.Admin;
import com.example.demo.Repository.AdminRepository;

@Component
public class AdminServices {

	@Autowired
	AdminRepository repository;

	// 1.Save
	public ResponseEntity<String> saveAdmin(Admin admin) {
		repository.save(admin);
		return new ResponseEntity<String>("Single Data Inserted Successfully", HttpStatus.CREATED);

	}

	public ResponseEntity<String> saveAllAdmin(List<Admin> admin) {
		repository.saveAll(admin);
		return new ResponseEntity<String>("Multiple Data Inserted Successfully", HttpStatus.CREATED);

	}

	public ResponseEntity<List<Admin>> fetch() {
		List<Admin> admin = repository.findAll();
		if (admin.isEmpty()) {
			return new ResponseEntity<List<Admin>>(admin, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Admin>>(admin, HttpStatus.FOUND);
		}

	}

	public ResponseEntity<Admin> fetch_by_id(int id) {
		Admin admin = repository.findById(id).orElse(null);
        if (admin==null) {
            return new ResponseEntity<Admin>(admin, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Admin>(admin,HttpStatus.FOUND);
        }
	}

	public ResponseEntity<List<Admin>> fetchByEmail(String email) {
		List<Admin> admins = repository.findByEmail(email);
        if (admins.isEmpty()) {
            return new ResponseEntity<List<Admin>>(admins, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
        }
	}
}
