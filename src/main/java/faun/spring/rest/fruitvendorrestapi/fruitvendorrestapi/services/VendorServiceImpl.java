package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.mapper.VendorMapper;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorMapper vendorMapper) {
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        List<Vendor> vendors = new ArrayList<>();

        vendors.add(new Vendor(1L, "first VendorDTO"));
        vendors.add(new Vendor(2L, "second VendorDTO"));
        vendors.add(new Vendor(3L, "third VendorDTO"));

        return vendors.stream()
                .map(vendorMapper::vendorToVendorDTO)
                .collect(Collectors.toList());
    }
}
