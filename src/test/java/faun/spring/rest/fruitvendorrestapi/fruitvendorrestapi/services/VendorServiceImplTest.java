package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.mapper.VendorMapper;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class VendorServiceImplTest {

    @Mock
    private VendorRepository vendorRepository;

    private VendorService vendorService;
    private Vendor correctVendorOne, correctVendorTwo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(vendorRepository, new VendorMapper());
        correctVendorOne = new Vendor(1L, "First Vendor");
        correctVendorTwo = new Vendor(2L, "Second Vendor");
    }

    @Test
    public void getAllVendors() {

        given(vendorRepository.findAll())
                .willReturn(Arrays.asList(correctVendorOne, correctVendorTwo));

        List<VendorDTO> vendorDTOs = vendorService.getAllVendors();

        then(vendorRepository).should(times(1)).findAll();

        assertNotNull(vendorDTOs);
        assertEquals(2, vendorDTOs.size());
        assertEquals(correctVendorOne.getId(), vendorDTOs.get(0).getId());
        assertEquals(correctVendorTwo.getId(), vendorDTOs.get(1).getId());
    }
}