package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.mapper;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.controllers.VendorController;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import org.springframework.stereotype.Component;

@Component
public class VendorMapper {

    public VendorDTO vendorToVendorDTO(Vendor vendor) {
        if (vendor == null) return null;

        String vendorUrl = VendorController.BASE_API_URL + "/" + vendor.getId();

        return new VendorDTO(vendor.getId(), vendor.getName(), vendorUrl);
    }

    public Vendor vendorDTOtoVendor(VendorDTO vendor) {
        if (vendor == null) return null;

        return new Vendor(vendor.getId(), vendor.getName());
    }

}
