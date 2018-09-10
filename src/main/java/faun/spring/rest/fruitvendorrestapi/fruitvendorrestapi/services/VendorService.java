package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO addVendor(VendorDTO vendor);

    void deleteVendor(Long id);

    VendorDTO updateVendorById(Long id, VendorDTO vendorDTO);

    VendorDTO updateFieldsInVendorById(Long id, VendorDTO vendorDTO);
}
