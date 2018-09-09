package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.mapper;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.controllers.VendorController;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendorMapperTest {

    private VendorMapper mapper;

    private Vendor correctVendor;
    private VendorDTO correctVendorDTO;

    @Before
    public void setUp() {
        mapper = new VendorMapper();
        correctVendor = new Vendor(1L, "James");
        correctVendorDTO = new VendorDTO(1L, "James", VendorController.BASE_API_URL + "/1");
    }

    @Test
    public void testNull() {
        assertNull(mapper.vendorToVendorDTO(null));
        assertNull(mapper.vendorDTOtoVendor(null));
    }

    @Test
    public void testVendorDTOtoVendor() {
        Vendor domain = mapper.vendorDTOtoVendor(correctVendorDTO);

        assertNotNull(domain);
        assertEquals(correctVendor.getId(), domain.getId());
        assertEquals(correctVendor.getName(), domain.getName());
    }

    @Test
    public void testVendorToVendorDTO() {
        VendorDTO dto = mapper.vendorToVendorDTO(correctVendor);

        assertNotNull(dto);
        assertEquals(correctVendorDTO.getId(), dto.getId());
        assertEquals(correctVendorDTO.getName(), dto.getName());
        assertEquals(correctVendorDTO.getVendorUrl(), dto.getVendorUrl());
    }

}