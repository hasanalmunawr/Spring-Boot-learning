package hasanalmunawrDev.RestfulAPI.service.impl;

import hasanalmunawrDev.RestfulAPI.entity.Address;
import hasanalmunawrDev.RestfulAPI.entity.Contact;
import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.AddressResponse;
import hasanalmunawrDev.RestfulAPI.model.CreateAddressRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateAddressRequest;
import hasanalmunawrDev.RestfulAPI.repository.AddressRepository;
import hasanalmunawrDev.RestfulAPI.repository.ContactRepository;
import hasanalmunawrDev.RestfulAPI.service.AddressService;
import hasanalmunawrDev.RestfulAPI.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public AddressResponse create(User user, CreateAddressRequest addressRequest) {
        validationService.validate(addressRequest);

        Contact contact = contactRepository.findFirstByUserAndId(user, addressRequest.getContactid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Id Not Found"));

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setContact(contact);
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setProvince(addressRequest.getProvince());
        address.setCountry(addressRequest.getCountry());
        address.setPostalCode(addressRequest.getPostalCode());

        addressRepository.save(address);

        return toAddressResponse(address);
    }

    @Override
    @Transactional(readOnly = true)
    public AddressResponse get(User user, String contactId, String addressId) {
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact id Not Found"));

        Address address = addressRepository.findFirstByContactAndId(contact, addressId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address id Not Found"));

        return toAddressResponse(address);
    }

    @Transactional()
    public AddressResponse update(User user, UpdateAddressRequest addressRequest) {
        validationService.validate(addressRequest);
        Contact contact = contactRepository.findFirstByUserAndId(user, addressRequest.getContactId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact id Not Found"));
        Address address = addressRepository.findFirstByContactAndId(contact, addressRequest.getAddressId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address id Not Found"));

        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setProvince(addressRequest.getProvince());
        address.setCountry(addressRequest.getCountry());
        address.setPostalCode(addressRequest.getPostalCode());
        addressRepository.save(address);

        return toAddressResponse(address);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressResponse> getList(User user, String idContact) {
        Contact contact = contactRepository.findById(idContact)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact id Not Found"));
        List<Address> addresses = addressRepository.findAllByContact(contact);

        return  addresses.stream().map(this::toAddressResponse).toList();
    }

    @Override
    @Transactional
    public void delete(User user, String contactId, String addressId) {
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));

        Address address = addressRepository.findFirstByContactAndId(contact, addressId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address is not found"));

        addressRepository.delete(address);
    }


    private AddressResponse toAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .province(address.getProvince())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build();
    }
}
