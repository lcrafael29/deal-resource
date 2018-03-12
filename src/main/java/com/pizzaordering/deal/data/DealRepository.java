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

package com.pizzaordering.deal.data;

import org.springframework.data.repository.CrudRepository;

import com.pizzaordering.deal.entity.Deal;

/**
 * Interface of deal repository layer.
 * 
 * @author Rafael Lima Costa
 *
 */
public interface DealRepository extends CrudRepository<Deal, Integer> {
}