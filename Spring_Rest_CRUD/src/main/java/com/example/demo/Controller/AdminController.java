package com.example.demo.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity_DTO.Admin;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Service.AdminServices;

@RestController
//@RequestMapping("admins")
public class AdminController {

//	@Autowired
//	AdminRepository repository;
	@Autowired
	AdminServices services;

	// 1.Save one Admin Record
	// @RequestMapping works for all but we use @PostMapping for insert,@GetMapping
	// for fetch,@DeleteMapping for deleting,@PutMapping for updation
	@PostMapping("/admins")
	public ResponseEntity<String> saveAdmin(@RequestBody Admin admin) {// @RequestBody will receive JSON Object and then
																		// convert JSON object to java object
//Instead of writing the logic in AdminController we are writting in AdminServices
		// repository.save(admin);
//		return new ResponseEntity<String>("Data Inserted Successfully", HttpStatus.CREATED);
		return services.saveAdmin(admin);
	}

	// 2.Save Multiple Admin Record's
	@PostMapping("/admins/many")
	public ResponseEntity<String> saveAllAdmin(@RequestBody List<Admin> admin) {// @RequestBody will convert JSON object
																				// to java object
		// Instead of writing the logic in AdminController we are writting in
		// AdminServices
		// repository.save(admin);
//				return new ResponseEntity<String>("Data Inserted Successfully", HttpStatus.CREATED);
		return services.saveAllAdmin(admin);
	}

	// 3. Fetch All Records
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> fetchAllAdmins() {
		return services.fetch();
	}

	// 4. Fetch One record
	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> fetchById(@PathVariable int id) {
		return services.fetch_by_id(id);

	}

	// 5. Fetch By Email
	@GetMapping("/admins/email/{email}")
	public ResponseEntity<List<Admin>> fetchByEmail(@PathVariable String email) {
		return services.fetchByEmail(email);
	}

	//6. Delete By ID
	@DeleteMapping("/admins/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return services.deleteById(id);
	}

	//7. Record Updation
	@PutMapping("/admins")
	public ResponseEntity<String> update(@RequestBody Admin admin) {
		return services.update(admin);
	}
	
	
	@GetMapping("/admins/email/{email}/password/{password}")
	public ResponseEntity<String> login(@PathVariable String email,@PathVariable String password){
		return services.login(email,password);
	}

}
