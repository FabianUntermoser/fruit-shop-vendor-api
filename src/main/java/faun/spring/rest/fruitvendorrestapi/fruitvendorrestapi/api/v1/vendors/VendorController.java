package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VendorController.BASE_API_URL)
public class VendorController {

    static final String BASE_API_URL = "/api/v1/vendors";

    @GetMapping
    public String test() {
        return "hello world!";
    }

}
