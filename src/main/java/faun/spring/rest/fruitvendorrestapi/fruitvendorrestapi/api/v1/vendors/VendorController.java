package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.Vendor;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.VendorList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(VendorController.BASE_API_URL)
public class VendorController {

    static final String BASE_API_URL = "/api/v1/vendors";

    @GetMapping
    public VendorList getVendors() {
        List<Vendor> vendors = new ArrayList<>();

        vendors.add(new Vendor(1L, "first Vendor", BASE_API_URL + "/1"));
        vendors.add(new Vendor(2L, "second Vendor", BASE_API_URL + "/2"));
        vendors.add(new Vendor(3L, "third Vendor", BASE_API_URL + "/3"));

        return new VendorList(vendors);
    }

}
