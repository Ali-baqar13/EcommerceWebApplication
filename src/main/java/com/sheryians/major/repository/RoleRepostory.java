
package com.sheryians.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Role;

public interface RoleRepostory extends JpaRepository<Role, Integer> {
	
//	public List<Role> findById(int id);

}
