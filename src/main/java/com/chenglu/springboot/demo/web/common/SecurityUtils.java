package com.chenglu.springboot.demo.web.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.chenglu.springboot.demo.web.entity.TblUser;

public class SecurityUtils {
	public static TblUser getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof TblUser) {
			return (TblUser) principal;
		}
		return null;
	}
	
	public static void setUser(TblUser user) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("SYS_ROLE"));
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), authorities);
		auth.setDetails(authentication.getDetails());
		context.setAuthentication(auth);
	}
}
