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

package com.pizzaordering.deal;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pizzaordering.deal.data.DealIngredientRepository;
import com.pizzaordering.deal.data.DealRepository;
import com.pizzaordering.deal.entity.Deal;
import com.pizzaordering.deal.entity.DealIngredient;
import com.pizzaordering.deal.entity.DealIngredientId;
import com.pizzaordering.deal.service.DealService;
import com.pizzaordering.deal.service.IngredientClientService;

/**
 * Unit test of deal service layer.
 * 
 * @author Rafael Lima Costa
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DealServiceTest {
	
	/**
	 * Interface of deal service layer.
	 */
	@Autowired
	DealService dealService;
	
	/**
	 * Interface of ingredient client service layer mocked.
	 */
	@MockBean
	IngredientClientService ingredientClientService;
	
	/**
	 * Interface of deal repository layer mocked.
	 */
	@MockBean
	DealRepository dealRepository;
	
	/**
	 * Interface of deal ingredient repository layer mocked.
	 */
	@MockBean
	DealIngredientRepository dealIngredientRepository;
	
	/**
	 * Test add deal method:
	 * 
	 * > Mock database calls of this flow.
	 * > Test method sending input and comparing returned output with expected output.
	 */
	@Test
	public void addDealTest() {
		Deal deal = null;
		DealIngredient dealIngredient = null;
		Map<Long, DealIngredient> dealIngredientMap = null;
		Deal dealSaved = null;
		Deal dealExpected = null;
		
		// Mock ingredientClientService.addIngredientDiscount(deal) call.
		Mockito.mock(IngredientClientService.class);
		
		// Mock dealRepository.save(deal) call.
		deal = new Deal();
		deal.setDescription("Cheese Promotion");
		
		dealSaved = new Deal();
		dealSaved.setId(1);
		dealSaved.setDescription("Cheese Promotion");
		
		Mockito.when(dealRepository.save(deal)).thenReturn(dealSaved);
		
		// Mock dealIngredientRepository.saveAll(dealIngredientMap.values()) call.
		deal = new Deal();
		deal.setId(1);
		deal.setDescription("Cheese Promotion");
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDealIngredientId(new DealIngredientId());
		dealIngredient.getDealIngredientId().setIngredientId(1L);
		dealIngredient.getDealIngredientId().setDeal(deal);
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap = new HashMap<Long, DealIngredient>();
		dealIngredientMap.put(1L, dealIngredient);
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDealIngredientId(new DealIngredientId());
		dealIngredient.getDealIngredientId().setIngredientId(2L);
		dealIngredient.getDealIngredientId().setDeal(deal);
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap.put(2L, dealIngredient);
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDealIngredientId(new DealIngredientId());
		dealIngredient.getDealIngredientId().setIngredientId(3L);
		dealIngredient.getDealIngredientId().setDeal(deal);
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap.put(3L, dealIngredient);
		
		Mockito.when(dealIngredientRepository.saveAll(dealIngredientMap.values())).thenReturn(dealIngredientMap.values());
		
		// Input.
		deal = new Deal();
		deal.setDescription("Cheese Promotion");
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap = new HashMap<Long, DealIngredient>();
		dealIngredientMap.put(1L, dealIngredient);
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap.put(2L, dealIngredient);
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap.put(3L, dealIngredient);
		
		deal.setDealIngredientMap(dealIngredientMap);
		
		// Output.
		dealExpected = new Deal();
		dealExpected.setId(1);
		dealExpected.setDescription("Cheese Promotion");
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDealIngredientId(new DealIngredientId());
		dealIngredient.getDealIngredientId().setIngredientId(1L);
		dealIngredient.getDealIngredientId().setDeal(dealExpected);
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap = new HashMap<Long, DealIngredient>();
		dealIngredientMap.put(1L, dealIngredient);
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDealIngredientId(new DealIngredientId());
		dealIngredient.getDealIngredientId().setIngredientId(2L);
		dealIngredient.getDealIngredientId().setDeal(dealExpected);
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap.put(2L, dealIngredient);
		
		dealIngredient = new DealIngredient();
		dealIngredient.setDealIngredientId(new DealIngredientId());
		dealIngredient.getDealIngredientId().setIngredientId(3L);
		dealIngredient.getDealIngredientId().setDeal(dealExpected);
		dealIngredient.setDiscountPercentage(BigDecimal.valueOf(15));
		
		dealIngredientMap.put(3L, dealIngredient);
		
		dealExpected.setDealIngredientMap(dealIngredientMap);
		
		// Test.
		assertThat(dealService.addDeal(deal)).isEqualTo(dealExpected);
	}
}