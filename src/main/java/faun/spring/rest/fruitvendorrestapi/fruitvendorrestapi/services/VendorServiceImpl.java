package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.VendorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    static final String BASE_API_URL = "/api/v1/vendors";

    @Override
    public List<VendorDTO> getAllVendors() {
        List<VendorDTO> vendors = new ArrayList<>();

        vendors.add(new VendorDTO(1L, "first VendorDTO", BASE_API_URL + "/1"));
        vendors.add(new VendorDTO(2L, "second VendorDTO", BASE_API_URL + "/2"));
        vendors.add(new VendorDTO(3L, "third VendorDTO", BASE_API_URL + "/3"));

        return vendors;
    }
}
