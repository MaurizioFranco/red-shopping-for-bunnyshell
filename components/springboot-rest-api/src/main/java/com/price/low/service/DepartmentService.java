package com.price.low.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.low.entity.Department;
import com.price.low.repository.DepartmentRepository;
import com.price.low.response.model.DepartmentRecord;

//import franco.maurizio.hr.desk.com.persistence.entity.Role;
//import franco.maurizio.hr.desk.com.persistence.entity.User;
//import franco.maurizio.hr.desk.com.persistence.repository.RoleRepository;

/**
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Service
public class DepartmentService {

	public static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	/**
	 * Provides list of departments entities from repository
	 * 
	 * @return List<Departments>, list of Departments entity objects
	 */
	public List<Department> getAll() {
		logger.info("getAll - START");
		List<Department> items = departmentRepository.findAll();
//		List<DepartmentRecord> items = Arrays.asList(
//				new DepartmentRecord (1, "cibo", "da mangiare", 0),
//				new DepartmentRecord (2, "igiene", "igiene personale", 10),
//				new DepartmentRecord (1, "pulizia", "pulizia casa", 100)				
//				) ;
		logger.info("getAll - END - returning " + items.size() + " departments.");
		return items;
	}
//	public List<Role> getAll() {
//		logger.info("getAll - START");
//		List<Role> roles = roleRepository.findAll();
//		logger.info("getAll - END - returning " + roles.size() + " roles.");
//		return roles;
//	}
//
//	/**
//	 * Try to delete all entities from role table
//	 */
//	public void deleteAll() {
//		logger.debug("deleteAll - START");
//		roleRepository.deleteAll();
//	}
//	
//	/**
//	 * Provides to insert given role entity 
//	 * 
//	 * @return entity, Role entity just inserted
//	 */
//	public Role insert(Role entity) {
//		logger.info("insert - START - entity: {}", entity);
//		entity = roleRepository.save(entity);
//		logger.info("insert - END - returning inserted entity: {}" + entity);
//		return entity;
//	}
//	
//	public Role selectByLevel(int level) {
//		logger.info("selectByLevel - START - level: {}", level);
//		Role role = roleRepository.findByLevel(level);
//		logger.info("selectByLevel - END - returning selectByLevel role: {}" + role);
//		return role;
//	}
}
