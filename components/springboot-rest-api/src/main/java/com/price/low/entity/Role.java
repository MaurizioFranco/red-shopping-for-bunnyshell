package com.price.low.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * The persistent class for the roles database table.
 *	@author maurizio.franco@ymail.com
 */
@Entity
@Table( name = "roles" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Role {
	
	public static final int JAVA_COURSE_CANDIDATE_LEVEL = 90 ; // TO REMOVE
	public static final int ADMIN_LEVEL = 0 ;
	public static final int TECHNICAL_RECRUITER_LEVEL = 10 ;
	public static final int HR_LEVEL = 50 ;
	public static final int ACCOUNT_LEVEL = 90 ;
	public static final int GUEST_LEVEL = 100 ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
//	@Length(max = 50, message = "error.role.label.length")
//	@NotEmpty(message = "error.role.label.empty")
	@Column(name = "label")
	private String label;
		
	
//	@Length(max = 100, message = "error.role.description.length")
	@Column(name = "description")
	private String description;
	
//	@NotNull(message = "error.role.level.notnull")
	@Column(name = "level")
	private int level;
	
}
