package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain;

import java.util.List;

public class VendorList {

    private List<Vendor> vendors;

    public VendorList(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }
}
