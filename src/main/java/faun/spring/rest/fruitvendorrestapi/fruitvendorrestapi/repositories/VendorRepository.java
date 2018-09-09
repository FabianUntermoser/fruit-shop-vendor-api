package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.repositories;

import faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
