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

package com.pizzaordering.deal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaordering.deal.entity.Deal;
import com.pizzaordering.deal.service.DealService;

/**
 * Resource to expose deal operations and handle deal requests.
 * 
 * @author Rafael Lima Costa
 *
 */
@RestController
@RequestMapping("/deals")
public class DealController {
	
	/**
	 * Interface of deal service layer.
	 */
	@Autowired
	DealService dealService;
	
	/**
	 * Operation for adding a deal.
	 * 
	 * @param deal Deal to be added on database.
	 * @return Deal added on database.
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Deal addDeal(@RequestBody Deal deal) {
		return dealService.addDeal(deal);
	}
	
	/**
	 * Operation for getting a deal.
	 * 
	 * @param id Id of deal to be gotten from database.
	 * @return Deal gotten from database.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Deal getDeal(@PathVariable Integer id) {
		return dealService.getDeal(id);
	}
	
	/**
	 * Operation for deleting a deal.
	 * 
	 * @param id Id of deal to be deleted from database.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteDeal(@PathVariable Integer id) {
		dealService.deleteDeal(id);
	}
}