package com.sheryians.major.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	@NotEmpty
	@Column(nullable = false)
	private String firstName;
	
	private String lastName;
	@NotEmpty
	@Column(nullable=false)
	@Email(message="{invalid error}")
	private String userEmail;
	
	public User() {
		
		
	}


	private String password;
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	
	@JoinTable(
		    name = "user_role",
		    joinColumns = {@JoinColumn(name = "users_Id",  referencedColumnName = "userId")},
		    inverseJoinColumns = {@JoinColumn(name = "roles_Id", referencedColumnName = "roleId")}
		)

	
	
	
	
	
	
	
	
	public List<Role> roles;
	


	


	public int getId() {
				return id;
			}


			public void setId(int id) {
				this.id = id;
			}


			public String getFirstName() {
				return firstName;
			}


			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}


			public String getLastName() {
				return lastName;
			}


			public void setLastName(String lastName) {
				this.lastName = lastName;
			}


			public String getUserEmail() {
				return userEmail;
			}


			public void setUserEmail(String email) {
				this.userEmail =email;
			}


			public String getPassword() {
				return password;
			}


			public void setPassword(String password) {
				this.password = password;
			}


			public List<Role> getRoles() {
				return roles;
			}


			public void setRoles(List<Role> roles) {
				this.roles = roles;
			}


			public User(User user) {
				
				this.id = user.getId();
				this.firstName = user.getFirstName();
				this.lastName = user.getLastName();
				this.userEmail = user.getUserEmail();
				this.password = user.getPassword();
				this.roles =user.getRoles();
						
			}

			

	
	
	
	
	
	
	
	
	
}


