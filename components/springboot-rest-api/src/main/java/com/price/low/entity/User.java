package com.price.low.entity;

import java.time.LocalDateTime;

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
 * @author maurizio.franco@ymail.com
 *
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
//	@Email(message = "error.user.email.email")
//	@NotEmpty(message = "error.user.email.empty")
//	@Length(max = 100, message = "error.user.email.length")
	@Column(name = "email")
	private String email;
	
//	@Length(max = 100, message = "error.user.password.length")
	@Column(name = "password")
	private String password;
	
//	@NotNull(message = "error.user.firstname.empty")
//	@Length(max = 50, message = "error.user.firstname.length")
	@Column(name = "firstname")
	private String firstname;
	
//	@NotNull(message = "error.user.lastname.empty")
//	@Length(max = 50, message = "error.user.lastname.length")
	@Column(name = "lastname")
	private String lastname; 
	
	@Column(name="regdate")
	private LocalDateTime regdate;

	@Column(name="role")
	private int role;
    
    @Column(name = "enabled")  
    private boolean enabled;

}






