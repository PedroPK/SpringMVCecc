package br.spring.mvc.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer		id;
	
	private String		title;
	
	private BigDecimal	value;
	
	private int			pages;
	
	@Lob
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer pId) {
		this.id = pId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String pTitle) {
		this.title = pTitle;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal pValue) {
		this.value = pValue;
	}
	
	public int getPages() {
		return pages;
	}
	public void setPages(int pPages) {
		this.pages = pPages;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String pDescription) {
		this.description = pDescription;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + pages;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object pObj) {
		if (this == pObj)
			return true;
		if (pObj == null)
			return false;
		if (getClass() != pObj.getClass())
			return false;
		Product other = (Product) pObj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pages != other.pages)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", pages=" + pages + ", description=" + description + "]";
	}
	
}