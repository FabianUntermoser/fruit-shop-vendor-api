package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.controllers;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.dto.VendorListDTO;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.services.VendorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(VendorController.BASE_API_URL)
public class VendorController {

    public static final String BASE_API_URL = "/api/v1/vendors";

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("")
    public VendorListDTO getVendors() {
        List<VendorDTO> vendors = vendorService.getAllVendors();
        return new VendorListDTO(vendors);
    }

    @GetMapping("/{id}")
    public VendorDTO getVendorById(@PathVariable String id) {
        return vendorService.getVendorById(Long.valueOf(id));
    }

}
