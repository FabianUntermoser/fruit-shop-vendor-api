package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.controllers.VendorController;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    @Override
    public List<VendorDTO> getAllVendors() {
        List<Vendor> vendors = new ArrayList<>();

        vendors.add(new Vendor(1L, "first VendorDTO"));
        vendors.add(new Vendor(2L, "second VendorDTO"));
        vendors.add(new Vendor(3L, "third VendorDTO"));

        return vendors.stream()
                .map(vendor -> new VendorDTO(
                        vendor.getId(),
                        vendor.getName(),
                        VendorController.BASE_API_URL + "/" + vendor.getId()
                )).collect(Collectors.toList());
    }
}
