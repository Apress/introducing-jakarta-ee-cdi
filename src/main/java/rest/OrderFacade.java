package rest;


import cdi.annotations.InStoreQualifier;
import cdi.annotations.OnlineQualifier;
import cdi.annotations.UserNameQualifier;
import cdi.beans.GenericOrder;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class OrderFacade {

    @Inject
    @UserNameQualifier
    String userName;

    @Inject
    @InStoreQualifier
    GenericOrder genericOrder;

    @Inject
    @OnlineQualifier
    GenericOrder onlineOrder;
}
