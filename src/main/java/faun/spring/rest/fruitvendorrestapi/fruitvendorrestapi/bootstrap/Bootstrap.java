package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.bootstrap;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {

    private final VendorRepository vendorRepository;

    public Bootstrap(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Vendor> vendors = produceVendors();
        vendorRepository.saveAll(vendors);
    }

    private List<Vendor> produceVendors() {
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(new Vendor("first VendorDTO"));
        vendors.add(new Vendor("second VendorDTO"));
        vendors.add(new Vendor("third VendorDTO"));
        return vendors;
    }
}
