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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BOOKS")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@NotNull
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Column(name = "ISBN")
	@Size(max = 13, min = 13)
	private String isbn;
	
	@Column(name = "IMG")
	private String img;
	
	@Column(name = "EBOOK")
	private String ebook;
	
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
	@Pattern(regexp="^([I]\\d{6}|[C]\\d{7})$", message="UserId format is not correct!")
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

	public Book(int id, @NotNull String name, @NotNull @Size(max = 13, min = 13) String isbn, String img, String ebook,
			String donor, String category, Date purchasingTime, String description,
			@Pattern(regexp = "^([I]\\d{6}|[C]\\d{7})$", message = "UserId format is not correct!") String borrower,
			Date borrowerTime, Date lastModified) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.img = img;
		this.ebook = ebook;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getEbook() {
		return ebook;
	}

	public void setEbook(String ebook) {
		this.ebook = ebook;
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

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", isbn=" + isbn + ", img=" + img + ", ebook=" + ebook + ", donor="
				+ donor + ", category=" + category + ", purchasingTime=" + purchasingTime + ", description="
				+ description + ", borrower=" + borrower + ", borrowerTime=" + borrowerTime + ", lastModified="
				+ lastModified + "]";
	}

   
}