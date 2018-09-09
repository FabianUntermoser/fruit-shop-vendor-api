package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.VendorDTO;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();

}
