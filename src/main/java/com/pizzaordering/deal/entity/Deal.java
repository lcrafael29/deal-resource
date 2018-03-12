/**
 * Pizza Ordering Application
 * 
 * HTTP REST Microservices that handle ordering, deals and inventory
 * 
 * FastSpring Coding Challenge
 * 
 * Rafael Lima Costa
 * March of 2018
 * Santa Barbara, CA, USA
 */

package com.pizzaordering.deal.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Deal entity.
 * 
 * @author Rafael Lima Costa
 *
 */
@Entity
@Table(name = "del_deal")
public class Deal implements Serializable {
	
	/**
	 * Serial version UID for serialization.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Description.
	 */
	private String description;
	
	/**
	 * Map of deal ingredients, using ingredient id as key and deal ingredient as value.
	 */
	@OneToMany(mappedBy = "dealIngredientId.deal", cascade = CascadeType.REMOVE)
	@MapKey(name = "dealIngredientId.ingredientId")
	private Map<Long, DealIngredient> dealIngredientMap;
	
	/**
	 * Constructor.
	 */
	public Deal() {
	}

	/**
	 * Get id of deal.
	 * 
	 * @return Id of deal.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set id of deal.
	 * 
	 * @param id Id of deal.
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Get description.
	 * 
	 * @return Description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set description.
	 * 
	 * @param description Description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get map of deal ingredient.
	 * 
	 * @return Map of deal ingredient.
	 */
	public Map<Long, DealIngredient> getDealIngredientMap() {
		return dealIngredientMap;
	}

	/**
	 * Set map of deal ingredient.
	 * 
	 * @param dealIngredientMap Map of deal ingredient.
	 */
	public void setDealIngredientMap(Map<Long, DealIngredient> dealIngredientMap) {
		this.dealIngredientMap = dealIngredientMap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deal other = (Deal) obj;
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
		return true;
	}
}