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

import org.springframework.lang.NonNull;

@Entity
@Table(name = "READERS")
public class Reader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NonNull
	@Column(name = "USERID", unique = true)
	private String userId;
	
	@NonNull
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "BORROWBOOKSCOUNT")
	private int borrowBooksCount;
	
	@Column(name = "LastModified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;

	//constructor without parameter
	public Reader() {
    }

    public Reader(Integer id) {
        this.id  = id;
    }

    public Reader(String userId, String name, Integer borrowBooksCount) {
        this.userId = userId;
        this.name = name;
        this.borrowBooksCount = borrowBooksCount;
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

}
