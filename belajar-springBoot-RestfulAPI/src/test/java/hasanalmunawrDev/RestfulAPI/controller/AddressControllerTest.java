package hasanalmunawrDev.RestfulAPI.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hasanalmunawrDev.RestfulAPI.entity.Address;
import hasanalmunawrDev.RestfulAPI.entity.Contact;
import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.AddressResponse;
import hasanalmunawrDev.RestfulAPI.model.CreateAddressRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateAddressRequest;
import hasanalmunawrDev.RestfulAPI.model.WebResponse;
import hasanalmunawrDev.RestfulAPI.repository.AddressRepository;
import hasanalmunawrDev.RestfulAPI.repository.ContactRepository;
import hasanalmunawrDev.RestfulAPI.repository.UserRepository;
import hasanalmunawrDev.RestfulAPI.security.BCrypt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        addressRepository.deleteAll();
        contactRepository.deleteAll();
        userRepository.deleteAll();

        User user = new User();
        user.setUsername("hasan");
        user.setPassword(BCrypt.hashpw("test", BCrypt.gensalt()));
        user.setName("Test");
        user.setToken("token");
        user.setTokenExpiredAt(System.currentTimeMillis() + 1000000);
        userRepository.save(user);

        Contact contact = new Contact();
        contact.setId("idContact");
        contact.setUser(user);
        contact.setFirstName("Hasan");
        contact.setLastName("Almunawar");
        contact.setEmail("san@example.com");
        contact.setPhone("9238423432");
        contactRepository.save(contact);
    }

    @Test
    void testCreateFail() throws Exception{
        CreateAddressRequest addressRequest = new CreateAddressRequest();
        addressRequest.setCountry("Indonesia");
        addressRequest.setPostalCode("24314");
        mockMvc.perform(
                post("/api/contacs/123412/address")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
                        .content(objectMapper.writeValueAsString(addressRequest))
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<AddressResponse>>() {
            });
            assertNotNull(response.getError());
        });
    }

     @Test
    void testCreateSucces() throws Exception{
        CreateAddressRequest addressRequest = new CreateAddressRequest();
        addressRequest.setCountry("Indonesia");
        addressRequest.setPostalCode("24314");
        mockMvc.perform(
                post("/api/contacs/idContact/address")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
                        .content(objectMapper.writeValueAsString(addressRequest))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<AddressResponse>>() {
            });
            assertNull(response.getError());
        });
    }

    @Test
    void getNotFound() throws Exception{
        mockMvc.perform(
                get("/api/contacts/123321/address/12351")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isNotFound()
        ) .andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void getSucces() throws Exception{

        Contact contact = contactRepository.findById("idContact").orElse(null);
        assertNotNull(contact);

        Address address = new Address();
        address.setId("addressId");
        address.setContact(contact);
        address.setCountry("Indonesia");
        address.setPostalCode("12341");
        addressRepository.save(address);

        mockMvc.perform(
                get("/api/contacts/idContact/address/"+address.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<AddressResponse>>() {
            });
            assertNull(response.getError());
            assertEquals(address.getCountry(), response.getData().getCountry());
            assertEquals(address.getPostalCode(), response.getData().getPostalCode());
        });
    }

    @Test
    void updateFail() throws Exception {
        UpdateAddressRequest addressRequest = new UpdateAddressRequest();
        addressRequest.setCountry("");
        mockMvc.perform(
                put("/api/contacts/idContact/address/idAddress")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
                        .content(objectMapper.writeValueAsString(addressRequest))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<AddressResponse>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void updateSucces() throws Exception {
        Contact contact = contactRepository.findById("idContact").orElse(null);
        assertNotNull(contact);

        Address address = new Address();
        address.setId("addressId");
        address.setContact(contact);
        address.setCountry("Indonesia");
        address.setPostalCode("12341");
        addressRepository.save(address);

        UpdateAddressRequest addressRequest = new UpdateAddressRequest();
        addressRequest.setCountry("Singapore");
        mockMvc.perform(
                put("/api/contacts/idContact/address/addressId")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "token")
                        .content(objectMapper.writeValueAsString(addressRequest))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<AddressResponse>>() {
            });
            assertNull(response.getError());
            assertEquals(addressRequest.getCountry(), response.getData().getCountry());
        });
    }

    @Test
    void getListFail() throws Exception {
        mockMvc.perform(
                get("/api/contacts/idContactssss/addresses")
                        .header("X-API-TOKEN", "token")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<AddressResponse>>() {
            });
            assertNotNull(response.getError());
        });
    }

     @Test
    void getListSucces() throws Exception {
         Contact contact = contactRepository.findById("idContact").orElseThrow();

         for (int i = 0; i < 5; i++) {
             Address address = new Address();
             address.setId("test-" + i);
             address.setContact(contact);
             address.setStreet("Jalan");
             address.setCity("Jakarta");
             address.setProvince("DKI");
             address.setCountry("Indonesia");
             address.setPostalCode("123123");
             addressRepository.save(address);
         }

         mockMvc.perform(
                 get("/api/contacts/idContact/addresses")
                         .accept(MediaType.APPLICATION_JSON)
                         .contentType(MediaType.APPLICATION_JSON)
                         .header("X-API-TOKEN", "token")
         ).andExpectAll(
                 status().isOk()
         ).andDo(result -> {
             WebResponse<List<AddressResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
             });
             assertNull(response.getError());
             assertEquals(5, response.getData().size());
         });
    }

    @Test
    void deletFail() throws Exception{
        mockMvc.perform(
                delete("/api/contacts/1dContact/address/i1dAddres")
                        .header("X-API-TOKEN", "token")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void deletSucces() throws Exception{
        Contact contact = contactRepository.findById("idContact").orElse(null);
        assertNotNull(contact);

        Address address = new Address();
        address.setId("addressId");
        address.setContact(contact);
        address.setCountry("Indonesia");
        address.setPostalCode("12341");
        addressRepository.save(address);

        mockMvc.perform(
                delete("/api/contacts/idContact/address/addressId")
                        .header("X-API-TOKEN", "token")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNull(response.getError());
            assertEquals("OK", response.getData().trim());
        });
    }


}