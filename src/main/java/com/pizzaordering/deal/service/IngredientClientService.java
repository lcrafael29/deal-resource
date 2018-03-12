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

package com.pizzaordering.deal.service;

import com.pizzaordering.deal.entity.Deal;

/**
 * Interface of ingredient client service layer.
 * 
 * @author Rafael Lima Costa
 *
 */
public interface IngredientClientService {
	
	/**
	 * Operation for adding the discount of ingredients consuming ingredient resource via HTTP REST.
	 * 
	 * @param deal Deal with ingredients discount to be added.
	 */
	public void addIngredientDiscount(Deal deal);
	
	/**
	 * Operation for deleting the discount of ingredients consuming ingredient resource via HTTP REST.
	 * 
	 * @param deal Deal with ingredients discount to be deleted.
	 */
	public void deleteIngredientDiscount(Deal deal);
}