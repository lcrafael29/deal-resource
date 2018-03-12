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
 * Interface of deal service layer.
 * 
 * @author Rafael Lima Costa
 *
 */
public interface DealService {
	
	/**
	 * Operation for adding a deal.
	 * 
	 * @param deal Deal to be added on database.
	 * @return Deal added on database.
	 */
	public Deal addDeal(Deal deal);
	
	/**
	 * Operation for getting a deal.
	 * 
	 * @param id Id of deal to be gotten from database.
	 * @return Deal gotten from database.
	 */
	public Deal getDeal(Integer id);
	
	/**
	 * Operation for deleting a deal.
	 * 
	 * @param id Id of deal to be deleted from database.
	 */
	public void deleteDeal(Integer id);
}