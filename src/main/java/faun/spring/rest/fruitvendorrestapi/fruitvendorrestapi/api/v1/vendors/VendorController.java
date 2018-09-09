package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.Vendor;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.VendorList;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services.VendorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(VendorController.BASE_API_URL)
public class VendorController {

    static final String BASE_API_URL = "/api/v1/vendors";

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public VendorList getVendors() {
        List<Vendor> vendors = vendorService.getAllVendors();
        return new VendorList(vendors);
    }

}
