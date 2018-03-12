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

import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaordering.deal.data.DealIngredientRepository;
import com.pizzaordering.deal.data.DealRepository;
import com.pizzaordering.deal.entity.Deal;
import com.pizzaordering.deal.entity.DealIngredient;
import com.pizzaordering.deal.entity.DealIngredientId;
import com.pizzaordering.deal.service.DealService;
import com.pizzaordering.deal.service.IngredientClientService;

/**
 * Implementation of deal service layer interface.
 * 
 * @author Rafael Lima Costa
 *
 */
@Service
public class DealServiceImpl implements DealService {
	
	/**
	 * Interface of ingredient client service layer.
	 */
	@Autowired
	IngredientClientService ingredientClientService;
	
	/**
	 * Interface of deal repository layer.
	 */
	@Autowired
	DealRepository dealRepository;
	
	/**
	 * Interface of deal repository layer.
	 */
	@Autowired
	DealIngredientRepository dealIngredientRepository;
	
	/*
	 * Save deal on database.
	 */
	public Deal addDeal(Deal deal) {
		Map<Long, DealIngredient> dealIngredientMap = null;
		DealIngredient dealIngredient = null;
		
		ingredientClientService.addIngredientDiscount(deal);
		
		dealIngredientMap = deal.getDealIngredientMap();
		
		deal.setDealIngredientMap(null);
		deal = dealRepository.save(deal);
		
		if (dealIngredientMap != null) {
			for (Long ingredientId : dealIngredientMap.keySet()) {
				dealIngredient = dealIngredientMap.get(ingredientId);
				dealIngredient.setDealIngredientId(new DealIngredientId());
				dealIngredient.getDealIngredientId().setIngredientId(ingredientId);
				dealIngredient.getDealIngredientId().setDeal(deal);
			}
			
			dealIngredientRepository.saveAll(dealIngredientMap.values());
			
			deal.setDealIngredientMap(dealIngredientMap);
		}
		
		return deal;
	}
	
	/*
	 * Get deal from database.
	 */
	public Deal getDeal(Integer id) {
		Deal closedRecipe = null;
		
		closedRecipe = dealRepository.findById(id).get();
		
		Hibernate.initialize(closedRecipe.getDealIngredientMap());
		
		return closedRecipe;
	}
	
	/*
	 * Delete deal from database.
	 */
	public void deleteDeal(Integer id) {
		ingredientClientService.deleteIngredientDiscount(dealRepository.findById(id).get());
		
		dealRepository.deleteById(id);
	}
}