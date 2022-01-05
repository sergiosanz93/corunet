package com.ssanz.corunet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity principal que muestra los precios de los productos
 * 
 * @author Sergio
 *
 */
@Entity
@Table(name="PRICES")
public class Prices {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@JoinColumn(name = "BRAND_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Brand brandID;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(name = "PRICE_LIST")
	private Integer priceList;
	
	@Column(name = "PRODUCT_ID")
	private Integer productID;
	
	@Column(name = "PRIORITY")
	private Integer priority;
	
	@Column(name = "PRICE")
	private Float price;
	
	@Column(name = "CURR", length = 3)
	private String currency;

	
	/*
	 * GETTERS Y SETTERS 
	 */
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Brand getBrandID() {
		return brandID;
	}

	public void setBrandID(Brand brandID) {
		this.brandID = brandID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}
	
	

	
	
	
}
