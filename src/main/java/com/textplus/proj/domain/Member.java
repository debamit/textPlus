package com.textplus.proj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member")
public class Member {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name="member_id", insertable=true, updatable=true, unique=true, nullable=false)
	  private long memberId;

	  // member email
	  @Column(name="email", length=255)
	  @NotNull
	  private String email;

	  // member name
	  @Column(name="name", length=255)
	  @NotNull
	  private String name;
	  
	  // member phone
	  @Column(name="phone", length=255)
	  @NotNull
	  private String phone;
	  
	  public Member(){
		  
	  }
	   
	   public Member (long memberId, String email, String name, String phone){
		   this.memberId = memberId;
		   this.name = name;
		   this.email = email;
		   this.phone = phone;
	   }
	   

	public long getId() {
		return memberId;
	}

	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	
	public String getPhone() {
		return phone;
	}

}
