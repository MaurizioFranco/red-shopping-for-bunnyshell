/**
 * 
 */
package com.price.low.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.low.entity.Department;
import com.price.low.response.model.DepartmentRecord;
import com.price.low.service.DepartmentService;



/**
 * 
 * Provides rest api for department entity mapping methods
 * 
 * @author maurizio.franco@ymail.com
 */

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
	public static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService ;

	@GetMapping("/")
	public ResponseEntity<List<Department>> getItems() {
		List<Department> items = departmentService.getAll();
		
		if (items.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<CeReProAbstractEntity> getRoleById(@PathVariable("id") final Long id){
//		Optional<Role> optRole = roleRepository.findById(id);
//		
//		if (!optRole.isPresent()) {
//			return new ResponseEntity<>(
//				new CustomErrorType("Role with id " + id + " not found"),
//				HttpStatus.NOT_FOUND);
//		}
//		
//		return new ResponseEntity<>(optRole.get(), HttpStatus.OK);
//	}
//	
//	@GetMapping("/level/{level}")
//	public ResponseEntity<CeReProAbstractEntity> getRoleByLevel(@PathVariable("level") final Integer level){
//		logger.info("getRoleByLevel - START - level: {}", level);
//		Role optRole = roleService.selectByLevel(level);
//		
//		if (optRole== null) {
//			return new ResponseEntity<>(
//				new CustomErrorType("Role with level " + level + " not found"),
//				HttpStatus.NOT_FOUND);
//		}
//		
//		return new ResponseEntity<>(optRole, HttpStatus.OK);
//	}
//	
//	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<CeReProAbstractEntity> createRole(
//			@Valid @RequestBody final Role role) {
//		logger.info("Creating Role : {}", role);
//		
//		if (roleRepository.findByLevel(role.getLevel()) != null) {
//			
//			return new ResponseEntity<>(
//					new CustomErrorType(
//							"Unable to create new role. A Role with level " + role.getLevel() + " already exist."),
//					HttpStatus.CONFLICT);
//		}
//		
//		Role insertedRole = roleService.insert(role);
//		return new ResponseEntity<>(insertedRole, HttpStatus.CREATED);
//	}
//	
//	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<CeReProAbstractEntity> updateRole(
//			@PathVariable("id") final Long id, @RequestBody Role role) {
//	
//		Optional<Role> optRole = roleRepository.findById(id);
//		
//		if (!optRole.isPresent()) {
//			return new ResponseEntity<>(
//					new CustomErrorType("Unable to upate. Role with id " + id + " not found."), 
//					HttpStatus.NOT_FOUND);
//		}
//		
//		Role currentRole = optRole.get();
//	
//		currentRole.setLabel(role.getLabel());
//		currentRole.setDescription(role.getDescription());
//		currentRole.setLevel(role.getLevel());
//		// save currentUser obejct
//		roleRepository.save(currentRole);
//		// return ResponseEntity object
//		return new ResponseEntity<>(currentRole, HttpStatus.OK);
//	}
//	 
//	@DeleteMapping("/{id}")
//	public ResponseEntity<CeReProAbstractEntity> deleteRole(@PathVariable("id") final Long id) {
//		Optional<Role> optRole = roleRepository.findById(id);
//		
//		if (!optRole.isPresent()) {
//			return new ResponseEntity<>(
//					new CustomErrorType("Unable to delete. Role with id " + id + " not found."), 
//					HttpStatus.NOT_FOUND);
//		}
//		
//		roleRepository.delete(optRole.get());
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
	
}
