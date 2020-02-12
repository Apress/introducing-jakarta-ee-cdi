package cdi.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Provider;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import cdi.annotations.OnlineQualifier;
import jpa.entities.ApplicationUser;
import jpa.entities.Order;

@ConversationScoped
@OnlineQualifier
public class SelfService implements
		GenericOrder, Serializable {

	@Inject
	@ConfigProperty(name = "self-service", defaultValue = "Hello, and welcome!")
	private String selfServiceWelcome;

	@Inject
	@ConfigProperty(name = "dynamic-value")
	private Provider<String> myDynamicValue;

	@Inject
	@OnlineQualifier
	Event<ApplicationUser> messageEvent;

	@Inject
	UserSession userSession;

	List<Order> lastOrders = new ArrayList<>();

	@PostConstruct
	private void init() {
		Logger.getAnonymousLogger().log(Level.INFO, myDynamicValue.get());
		//Populate list from DB
	}

	@Inject
	Conversation conversation;

	public void beginOrderProcess() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	@Override
	public BigDecimal order() {

		//fire a message event to send SMS before returning from this method
		//        messageEvent.fire(userSession.getCurrentUser());
		messageEvent.fireAsync(userSession.getCurrentUser());
		return null;
	}

	public void endOrderProcess() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}

}
