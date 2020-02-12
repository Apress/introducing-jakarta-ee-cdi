package service;

import cdi.annotations.CreateUserQualifier;
import jpa.entities.ApplicationUser;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless
public class PersistenceService {

    @Inject
    @CreateUserQualifier
    Event<ApplicationUser> emailEvent;

    @Inject
    private ApplicationUserRepo repo;

    public ApplicationUser persistUser(ApplicationUser applicationUser) {
        //Persist new user into datastore, returning the persisted user.

        ApplicationUser savedUser = repo.save(applicationUser);
        emailEvent.fire(savedUser);


        return savedUser;

    }
}
