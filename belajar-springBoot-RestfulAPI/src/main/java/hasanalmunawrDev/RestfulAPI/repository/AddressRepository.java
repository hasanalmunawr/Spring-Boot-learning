package hasanalmunawrDev.RestfulAPI.repository;

import hasanalmunawrDev.RestfulAPI.entity.Address;
import hasanalmunawrDev.RestfulAPI.entity.Contact;
import hasanalmunawrDev.RestfulAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, String> {

    Optional<Address> findFirstByContactAndId(Contact contact, String id);

    List<Address> findAllByContact(Contact contact);
}
