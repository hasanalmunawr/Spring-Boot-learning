package hasanalmunawrDev.RestfulAPI.service;

import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.ContactResponse;
import hasanalmunawrDev.RestfulAPI.model.CreateContactRequest;
import hasanalmunawrDev.RestfulAPI.model.SearchContactRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateContactRequest;
import org.springframework.data.domain.Page;

public interface ContactService {

    ContactResponse create(User user, CreateContactRequest contactRequest);

    ContactResponse get(User user, String id);

    ContactResponse update(User user, UpdateContactRequest contactRequest);

    Page<ContactResponse> search(User user, SearchContactRequest contactRequest);

    void delete(User user, String id);
}
