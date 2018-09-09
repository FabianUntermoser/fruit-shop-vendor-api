package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vendor {

    private String name;

    @JsonProperty("vendor_url")
    private String vendorUrl;

    public Vendor(String name, String vendorUrl) {
        this.name = name;
        this.vendorUrl = vendorUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorUrl() {
        return vendorUrl;
    }

    public void setVendorUrl(String vendorUrl) {
        this.vendorUrl = vendorUrl;
    }
}

