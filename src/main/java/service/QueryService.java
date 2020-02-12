package service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.swing.text.html.Option;
import javax.validation.constraints.Email;

import cdi.annotations.CDIService;
import jpa.entities.ApplicationUser;

@CDIService
public class QueryService {

	@Inject
	private ApplicationUserRepo repo;

	public ApplicationUser find(Long id) {
		return repo.findBy(id);
	}

	public Optional<ApplicationUser> findOptional(Long id) {
		return repo.findOptionalBy(id);
	}

	public ApplicationUser findByEmail(@Email String email) {
		return repo.findByEmail(email);
	}

	public ApplicationUser findByUserName(String userName) {
		return repo.findByUserName(userName);
	}

	public Optional<ApplicationUser> findOptionalByPassword(String hashedPassword) {
		return repo.findOptionalByHashedPassword(hashedPassword);
	}

	public Collection<ApplicationUser> findAllByUserName(String userNamePattern) {
		return repo.findByUserNameLike(userNamePattern);
	}

	List<ApplicationUser> findAll() {
		return repo.findAll();
	}


}
