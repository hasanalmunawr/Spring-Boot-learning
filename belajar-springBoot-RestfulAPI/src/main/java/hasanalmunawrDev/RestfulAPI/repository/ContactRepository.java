package hasanalmunawrDev.RestfulAPI.repository;

import hasanalmunawrDev.RestfulAPI.entity.Contact;
import hasanalmunawrDev.RestfulAPI.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String>, JpaSpecificationExecutor<Contact> {

    Optional<Contact> findFirstByUserAndId(User user, String id);

//    Page<Contact> findAll(Specification<Contact> specification, Pageable pageable);

//    Optional<Address> findFirstByContactAndId(Contact contact, UpdateAddressRequest request);


//    Page<Contact> findAll(Specification<Contact> specification, Pageable pageable);
}
