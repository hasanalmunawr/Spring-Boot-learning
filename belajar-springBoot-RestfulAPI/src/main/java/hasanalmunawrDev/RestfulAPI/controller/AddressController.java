package hasanalmunawrDev.RestfulAPI.controller;

import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.AddressResponse;
import hasanalmunawrDev.RestfulAPI.model.CreateAddressRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateAddressRequest;
import hasanalmunawrDev.RestfulAPI.model.WebResponse;
import hasanalmunawrDev.RestfulAPI.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/contacs/{idContact}/address",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<AddressResponse> create(User user,
                                               @PathVariable(value = "idContact") String idContact,
                                               @RequestBody CreateAddressRequest addressRequest) {
        addressRequest.setContactid(idContact);
        AddressResponse addressResponse = addressService.create(user, addressRequest);
        return WebResponse.<AddressResponse>builder()
                .data(addressResponse)
                .build();
    }

    @GetMapping(
            path = "/api/contacts/{idContact}/address/{idAddres}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<AddressResponse> get(User user,
                                            @PathVariable(value = "idContact") String idContact,
                                            @PathVariable(value = "idAddres") String idAddress) {
        AddressResponse addressResponse = addressService.get(user, idContact, idAddress);
        return WebResponse.<AddressResponse>builder()
                .data(addressResponse)
                .build();
    }

    @PutMapping(
            value = "/api/contacts/{idContact}/address/{idAddress}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<AddressResponse> update(User user,
                                               @PathVariable(value = "idContact") String idContact,
                                               @PathVariable(value = "idAddress") String idAddress,
                                               @RequestBody UpdateAddressRequest addressRequest) {
        addressRequest.setContactId(idContact);
        addressRequest.setAddressId(idAddress);
        AddressResponse update = addressService.update(user, addressRequest);
        return WebResponse.<AddressResponse>builder()
                .data(update)
                .build();
    }

    @GetMapping(
            path = "/api/contacts/{idContact}/addresses",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<AddressResponse>> getList(User user,
                                                      @PathVariable(value = "idContact") String idContact) {
        List<AddressResponse> addressResponses = addressService.getList(user, idContact);
        return WebResponse.<List<AddressResponse>>builder().data(addressResponses).build();
    }


    @DeleteMapping(path = "/api/contacts/{idContact}/address/{idAddres}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> delete(User user,
                                      @PathVariable(value = "idContact") String idContact,
                                      @PathVariable(value = "idAddres") String idAddress) {
        addressService.delete(user, idContact, idAddress);
        return WebResponse.<String>builder().data("OK").build();
    }

}
