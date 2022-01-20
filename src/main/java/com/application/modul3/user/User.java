package com.application.modul3.user;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //annotation ce indica ca, clasa este o entity 
@Table(name = "user", schema = "administration") //indica tabelul din baza de bate cu care mapeaza entitatea
public class User {
	
	@Id //indica primary key a clasei
	@GeneratedValue(strategy = GenerationType.IDENTITY) // adnotare ce defineste stategia de generare a primary key 
	private Integer id;
	
	@Column(name = "first_name") //adnotare ce defineste coloana din db care mapeaza campul adnotat
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "address")
	private String address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
