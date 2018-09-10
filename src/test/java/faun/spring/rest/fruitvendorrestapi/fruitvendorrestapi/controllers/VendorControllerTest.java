package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {VendorController.class})
public class VendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VendorService vendorService;

    private VendorDTO correctVendorDTOone, correctVendorTwo, correctVendorThree;

    @Before
    public void setUp() {
        correctVendorDTOone = new VendorDTO(1L, "first VendorDTO", VendorController.BASE_API_URL + "/1");
        correctVendorTwo = new VendorDTO(2L, "second VendorDTO", VendorController.BASE_API_URL + "/2");
        correctVendorThree = new VendorDTO(3L, "third VendorDTO", VendorController.BASE_API_URL + "/3");
    }

    @Test
    public void testReachabillity() throws Exception {
        mockMvc.perform(get(VendorController.BASE_API_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGettingAllVendors() throws Exception {
        given(vendorService.getAllVendors())
                .willReturn(Arrays.asList(correctVendorDTOone, correctVendorTwo, correctVendorThree));

        mockMvc.perform(get(VendorController.BASE_API_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendors", hasSize(3)));

        then(vendorService).should(times(1)).getAllVendors();
    }

    @Test
    public void testGettingVendorById() throws Exception {
        given(vendorService.getVendorById(anyLong()))
                .willReturn(correctVendorDTOone);

        mockMvc.perform(get(VendorController.BASE_API_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(correctVendorDTOone.getName())));

        then(vendorService).should(times(1)).getVendorById(anyLong());
    }

    @Test
    public void testPostVendor() throws Exception {
        given(vendorService.addVendor(anyObject()))
                .willReturn(correctVendorDTOone);

        mockMvc.perform(post(VendorController.BASE_API_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString(correctVendorDTOone)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", equalTo(correctVendorDTOone.getName())));
    }

    private String toJsonString(VendorDTO vendor) {
        try {
            return new ObjectMapper().writeValueAsString(vendor);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    public void testDeleteVendor() throws Exception {
        mockMvc.perform(delete(VendorController.BASE_API_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        then(vendorService).should(times(1)).deleteVendor(anyLong());
    }

    @Test
    public void testPutVendor() throws Exception {
        given(vendorService.updateVendorById(anyLong(), any(VendorDTO.class)))
                .willReturn(correctVendorDTOone);

        mockMvc.perform(put(VendorController.BASE_API_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString(correctVendorDTOone)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(correctVendorDTOone.getName())));

        then(vendorService).should(times(1)).updateVendorById(anyLong(), any(VendorDTO.class));
    }

    @Test
    public void testPatchVendor() throws Exception {
        given(vendorService.updateFieldsInVendorById(anyLong(), any(VendorDTO.class)))
                .willReturn(correctVendorDTOone);

        mockMvc.perform(patch(VendorController.BASE_API_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString(correctVendorDTOone)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(correctVendorDTOone.getName())));

        then(vendorService).should(times(1)).updateFieldsInVendorById(anyLong(), any(VendorDTO.class));
    }
}