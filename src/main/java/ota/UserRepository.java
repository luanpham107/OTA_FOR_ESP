package ota;

import org.springframework.data.repository.CrudRepository;
import ota.AppUser;

public interface UserRepository extends CrudRepository<AppUser, Long> {
}
