package UserClient;

import Market.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Controller
public class MainController {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products")
    public String showIndex(Model model) {
        ResponseEntity restExchange = restTemplate.exchange("http://localhost:7766/products", HttpMethod.GET, null, List.class);
        List<ProductDto> products = (List<ProductDto>)restExchange.getBody();
        model.addAttribute("products", products);
        return "all_products";
    }
}
