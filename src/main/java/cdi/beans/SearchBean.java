package cdi.beans;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jpa.entities.Order;

@RequestScoped
@Named
public class SearchBean {

	@Inject
	private SearchService searchService;

	private Collection<Order> orders;

	public void search(String searchQuery) {
		orders = searchService.searchOrders(searchQuery);
	}

	public Collection<Order> getOrders() {
		return orders;
	}
}
