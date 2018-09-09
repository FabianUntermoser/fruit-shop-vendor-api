package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.Vendor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    static final String BASE_API_URL = "/api/v1/vendors";

    @Override
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = new ArrayList<>();

        vendors.add(new Vendor(1L, "first Vendor", BASE_API_URL + "/1"));
        vendors.add(new Vendor(2L, "second Vendor", BASE_API_URL + "/2"));
        vendors.add(new Vendor(3L, "third Vendor", BASE_API_URL + "/3"));

        return vendors;
    }
}
