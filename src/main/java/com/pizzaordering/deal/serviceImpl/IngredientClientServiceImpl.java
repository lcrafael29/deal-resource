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

package com.pizzaordering.deal.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pizzaordering.deal.entity.Deal;
import com.pizzaordering.deal.service.IngredientClientService;

/**
 * Implementation of ingredient client service layer interface.
 * 
 * @author Rafael Lima Costa
 *
 */
@Service
public class IngredientClientServiceImpl implements IngredientClientService {
	
	/**
	 * URI of ingredient resource.
	 */
	private static final String URI_INGREDIENT_RESOURCE = "http://localhost:8081/ingredients";
	
	/**
	 * URI of add ingredient discount operation.
	 */
	private static final String URI_ADD_INGREDIENT_DISCOUNT = "/addIngredientDiscount";
	
	/**
	 * URI of delete ingredient discount operation.
	 */
	private static final String URI_DELETE_INGREDIENT_DISCOUNT = "/deleteIngredientDiscount";
	
	/**
	 * Spring implementation for HTTP RESTful resources consummation.
	 */
	private RestTemplate restTemplate = new RestTemplate();
	
	/**
	 * Consume ingredient resource sending deal with ingredients discount to be added.
	 * 
	 * @param deal Deal with ingredients discount to be added.
	 */
	@Override
	public void addIngredientDiscount(Deal deal) {
		restTemplate.put(URI_INGREDIENT_RESOURCE + URI_ADD_INGREDIENT_DISCOUNT, deal);
	}
	
	/**
	 * Consume ingredient resource sending deal with ingredients discount to be deleted.
	 * 
	 * @param deal Deal with ingredients discount to be deleted.
	 */
	@Override
	public void deleteIngredientDiscount(Deal deal) {
		restTemplate.put(URI_INGREDIENT_RESOURCE + URI_DELETE_INGREDIENT_DISCOUNT, deal);
	}
}