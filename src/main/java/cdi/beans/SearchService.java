package cdi.beans;

import java.util.Collection;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import jpa.entities.Order;
import service.QueryService;

@ApplicationScoped
public class SearchService {

    private final Collection<Order> searchResults = new HashSet<>();

    private QueryService queryService;

    @Inject
    public SearchService(QueryService qS) {
        this.queryService = qS;
    }

    public Collection<Order> searchOrders(String reqQueryString, String... optionalQueryStrings) {
        //perform search in datastore and put results in searchResults

        return searchResults;
    }
}
