package hasanalmunawrDev.RestfulAPI.service;

import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.AddressResponse;
import hasanalmunawrDev.RestfulAPI.model.CreateAddressRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateAddressRequest;

import java.util.List;

public interface AddressService {

    AddressResponse create(User user, CreateAddressRequest addressRequest);

    AddressResponse get(User user, String contactId, String addressId);

    AddressResponse update(User user,UpdateAddressRequest addressRequest);

    List<AddressResponse> getList(User user, String idContact);

    void delete(User user, String contactId, String addressId);
}
