package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.mapper.VendorMapper;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.exceptions.ResourceNotFoundException;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class VendorServiceImplTest {

    @Mock
    private VendorRepository vendorRepository;

    private VendorService vendorService;
    private Vendor correctVendorOne, correctVendorTwo;
    private VendorDTO correctVendorDTOone;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        vendorService = new VendorServiceImpl(vendorRepository, new VendorMapper());
        correctVendorOne = new Vendor(1L, "First Vendor");
        correctVendorTwo = new Vendor(2L, "Second Vendor");
        correctVendorDTOone = new VendorDTO(1L, "First DTO Vendor", "");
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

    @Test
    public void getVendorById() {
        given(vendorRepository.findById(anyLong()))
                .willReturn(Optional.of(correctVendorOne));

        VendorDTO vendorDTO = vendorService.getVendorById(1L);

        then(vendorRepository).should(times(1)).findById(anyLong());

        assertNotNull(vendorDTO);
        assertEquals(correctVendorOne.getId(), vendorDTO.getId());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getVendorByIdThrowsResourceNotFoundException() {
        given(vendorRepository.findById(anyLong()))
                .willReturn(Optional.empty());

        vendorService.getVendorById(999L);
    }

    @Test
    public void testAddVendor() {
        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(correctVendorOne);

        VendorDTO vendorDTO = vendorService.addVendor(correctVendorDTOone);

        then(vendorRepository).should(times(1)).save(any(Vendor.class));

        assertNotNull(vendorDTO);
        assertEquals(correctVendorOne.getId(), vendorDTO.getId());
    }

    @Test
    public void testDeleteVendor() {
        vendorService.deleteVendor(correctVendorDTOone.getId());

        then(vendorRepository).should(times(1)).deleteById(correctVendorDTOone.getId());
    }

    @Test
    public void testUpdateVendor() {
        given(vendorRepository.save(any(Vendor.class)))
                .willReturn(correctVendorOne);

        VendorDTO updatedVendorDTO = vendorService.updateVendorById(correctVendorOne.getId(), correctVendorDTOone);
        assertNotNull(updatedVendorDTO);
        assertEquals(correctVendorOne.getId(), updatedVendorDTO.getId());
        assertEquals(correctVendorOne.getName(), updatedVendorDTO.getName());
        assertTrue(updatedVendorDTO.getVendorUrl().contains("/1"));
    }
}