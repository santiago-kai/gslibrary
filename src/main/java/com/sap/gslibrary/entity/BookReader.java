/***********************************************************************
 * Module:  Readers.java
 * Author:  I326864
 * Purpose: Defines the Class Readers
 ***********************************************************************/
package com.sap.gslibrary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "BOOKREADERS")
public class BookReader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NonNull
	@Column(name = "USERID", unique = true)
	@Pattern(regexp="^([I]\\d{6}|[C]\\d{7})$", message="UserId format is not correct !")
	private String userId;
	
	@NonNull
	@Column(name = "NAME")
	private String name;
	
	@NonNull
	@Column(name = "PASSWORD")
	@Size(min = 6, message = "Password must at least 6 characters long!")
	private String password;
	
    //Empty: ordinary borrow; 1: root; 2: administrator
	@Column(name = "ROLE")
	private Character role;
	
	@Column(name = "BORROWBOOKSCOUNT")
	private int borrowBooksCount;
	
	@Column(name = "LastModified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;

	//constructor without parameter
	public BookReader() {
    }

    public BookReader(Integer id) {
        this.id  = id;
    }
	
	public BookReader(int id,
			@Pattern(regexp = "^([I]\\d{6}|[C]\\d{7})$", message = "UserId format is not correct !") String userId,
			String name, @Size(min = 6, message = "Password must at least 6 characters long!") String password,
			Character role, int borrowBooksCount, Date lastModified) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.role = role;
		this.borrowBooksCount = borrowBooksCount;
		this.lastModified = lastModified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getRole() {
		return role;
	}

	public void setRole(Character role) {
		this.role = role;
	}

	public int getBorrowBooksCount() {
		return borrowBooksCount;
	}

	public void setBorrowBooksCount(int borrowBooksCount) {
		this.borrowBooksCount = borrowBooksCount;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "BookReader [id=" + id + ", userId=" + userId + ", name=" + name + ", password=" + password + ", role="
				+ role + ", borrowBooksCount=" + borrowBooksCount + ", lastModified=" + lastModified + "]";
	}

}
