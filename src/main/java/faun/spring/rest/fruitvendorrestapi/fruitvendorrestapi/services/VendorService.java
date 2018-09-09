package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> getAllVendors();

}
