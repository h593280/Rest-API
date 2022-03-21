package com.customer.entity;

import java.sql.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kyc_customer")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idnr")
	private Integer idnr;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobil")
	private String mobil;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "pep")
	private String pep;
	
	public CustomerEntity() {}
	
	public CustomerEntity(String firstname, String lastname, Date dateOfBirth, String address, String mobil,String email, String pep) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.mobil = mobil;
		this.email = email;
		this.pep = pep;
	}


	public Integer getIdnr() {
		return idnr;
	}

	public void setIdnr(Integer idnr) {
		this.idnr = idnr;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setBirthdate(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}


	@Override
	public String toString() {
		return "customerEntity [firstname=" + firstname + ", lastname=" + lastname + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", mobil=" + mobil + ", email=" + email + ", pep=" + pep
				+ "]";
	}
	
	
	
	
}
