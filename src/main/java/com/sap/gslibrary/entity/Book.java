/***********************************************************************
 * Module:  Books.java
 * Author:  I326864
 * Purpose: Defines the Class Books
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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOOKS")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NotNull
	@Column(name = "NAME", unique = true)
	private int name;
	
	@Column(name = "DONOR")
	private String donor;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "PURCHASINGTIME")
	@Temporal(TemporalType.DATE)
	private Date purchasingTime;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "BORROWER")
	private String borrower;
	
	@Column(name = "BORROWTIME")
	@Temporal(TemporalType.DATE)
	private Date borrowerTime;
	
	@Column(name = "LastModified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;

	//constructor without parameter
	public Book() {
    }

    public Book(Integer id) {
        this.id  = id;
    }

    public Book(int id, @NotNull int name, 
    		String donor, String category, Date purchasingTime, 
    		String description, String borrower, 
    		Date borrowerTime, Date lastModified) {
		this.id = id;
		this.name = name;
		this.donor = donor;
		this.category = category;
		this.purchasingTime = purchasingTime;
		this.description = description;
		this.borrower = borrower;
		this.borrowerTime = borrowerTime;
		this.lastModified = lastModified;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getName() {
		return name;
	}
	
	public void setName(int name) {
		this.name = name;
	}
	
	public String getDonor() {
		return donor;
	}
	
	public void setDonor(String donor) {
		this.donor = donor;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public java.util.Date getPurchasingTime() {
		return purchasingTime;
	}
	
	public void setPurchasingTime(java.util.Date purchasingTime) {
		this.purchasingTime = purchasingTime;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBorrower() {
		return borrower;
	}
	
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	
	public java.util.Date getBorrowerTime() {
		return borrowerTime;
	}
	
	public void setBorrowerTime(java.util.Date borrowerTime) {
		this.borrowerTime = borrowerTime;
	}
   
}