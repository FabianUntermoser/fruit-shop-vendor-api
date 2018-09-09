package faun.spring.rest.fruitvendorrestapi.fruitvendorrestapi.api.v1.vendors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @GetMapping
    public String test() {
        return "hello world!";
    }

}
