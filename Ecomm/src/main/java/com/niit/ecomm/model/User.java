package com.niit.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class User
	{
		String name;
		String useraddress;
		long userphoneno;
		@Id
		String email;
		String password;
		String role;
		boolean enabled;
		
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUseraddress() {
			return useraddress;
		}
		public void setUseraddress(String useraddress) {
			this.useraddress = useraddress;
		}
		public long getUserphoneno() {
			return userphoneno;
		}
		public void setUserphoneno(long userphoneno) {
			this.userphoneno = userphoneno;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
	}
