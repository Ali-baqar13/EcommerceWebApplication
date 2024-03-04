
package com.sheryians.major.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.JoinColumn;

public class CustomDetail extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomDetail(User user) {
		super(user);

	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authoritylist=new ArrayList<>();
//		super.getRoles().forEach(role->{
//			
//			authoritylist.add(new SimpleGrantedAuthority(getUserEmail())
//			
//			
//		});
//		return authoritylist;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorityList = new ArrayList<>();
		super.getRoles().forEach(role -> {

			String roleName = role.getUserName();

			GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
			authorityList.add(authority);
		});
		return authorityList;
	}

	@Override
	public String getUsername() {

		return super.getUserEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}