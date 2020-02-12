package service;

import java.util.Collection;
import java.util.Optional;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import jpa.entities.ApplicationUser;

@Repository
public interface ApplicationUserRepo extends EntityRepository<ApplicationUser, Long> {

	ApplicationUser findByEmail(String email);

	ApplicationUser findByUserName(String userName);

	Optional<ApplicationUser> findOptionalByHashedPassword(String hashedPassword);

	Collection<ApplicationUser> findByUserNameLike(String userName);
}
