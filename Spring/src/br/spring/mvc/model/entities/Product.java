package br.spring.mvc.model.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.spring.mvc.model.entities.embeddables.Price;
import static br.spring.mvc.utils.LibraryUtilities.*;

@Entity
public class Product implements EntityInterface, Validator {
	
	private static final String PAGES_ATTRIBUTE_NAME = "pages";
	private static final String DESCRIPTION_ATTRIBUTE_NAME = "description";
	private static final String TITLE_ATTRIBUTE_NAME = "title";

	private static final String ERROR_CODE_REQUIRED_ATTRIBUTE = "requiredAttribute";

	/**
	 * - Serial Version UID 
	 */
	private static final long serialVersionUID = -889501267054436593L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer			id;
	
	private String			title;
	
	@ElementCollection
	private List<Price>		value;
	
	private int				pages;
	
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
	
	public List<Price> getValue() {
		return value;
	}
	public void setValue(List<Price> pValue) {
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
		return "Product [id=" + id + 
					", " + TITLE_ATTRIBUTE_NAME			+ "=" + title + 
					", " + PAGES_ATTRIBUTE_NAME			+ "=" + pages + 
					", " + DESCRIPTION_ATTRIBUTE_NAME	+ "=" + description + "]";
	}
	@Override
	public Object getPrimaryKey() {
		return getId();
	}
	
	public boolean hasAnyAttributeValid() {
		boolean answer = false;
		
		if (
				isStringValid(this.getTitle())			||
				isStringValid(this.getDescription())	||
				this.getPages()							> 0
		) {
			answer = true;
		}
		
		return answer;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object pTarget, Errors pErrors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(pErrors, TITLE_ATTRIBUTE_NAME, ERROR_CODE_REQUIRED_ATTRIBUTE);
		ValidationUtils.rejectIfEmptyOrWhitespace(pErrors, DESCRIPTION_ATTRIBUTE_NAME, ERROR_CODE_REQUIRED_ATTRIBUTE);
		
		Product product = (Product) pTarget;
		
		if ( product.getPages() <= 0 ) {
			pErrors.rejectValue(PAGES_ATTRIBUTE_NAME, ERROR_CODE_REQUIRED_ATTRIBUTE);
		}
	}
	
}