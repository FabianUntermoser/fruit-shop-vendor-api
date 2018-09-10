package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.controllers;

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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {VendorController.class})
public class VendorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VendorService vendorService;

    private VendorDTO corretVendorOne, corretVendorTwo, corretVendorThree;

    @Before
    public void setUp() {
        corretVendorOne = new VendorDTO(1L, "first VendorDTO", VendorController.BASE_API_URL + "/1");
        corretVendorTwo = new VendorDTO(2L, "second VendorDTO", VendorController.BASE_API_URL + "/2");
        corretVendorThree = new VendorDTO(3L, "third VendorDTO", VendorController.BASE_API_URL + "/3");
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
                .willReturn(Arrays.asList(corretVendorOne, corretVendorTwo, corretVendorThree));

        mockMvc.perform(get(VendorController.BASE_API_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendors", hasSize(3)));

        then(vendorService).should(times(1)).getAllVendors();
    }

    @Test
    public void testGettingVendorById() throws Exception {
        given(vendorService.getVendorById(anyLong()))
                .willReturn(corretVendorOne);

        mockMvc.perform(get(VendorController.BASE_API_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(corretVendorOne.getName())));

        then(vendorService).should(times(1)).getVendorById(anyLong());
    }

}