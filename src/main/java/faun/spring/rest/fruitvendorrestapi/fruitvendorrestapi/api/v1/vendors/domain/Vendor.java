package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vendor {

    private Long id;
    private String name;

    @JsonProperty("vendor_url")
    private String vendorUrl;

    public Vendor(Long id, String name, String vendorUrl) {
        this.id = id;
        this.name = name;
        this.vendorUrl = vendorUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

