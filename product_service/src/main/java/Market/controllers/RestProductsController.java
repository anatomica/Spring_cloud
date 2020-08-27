package Market.controllers;

import Market.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Market.servises.ProductsService;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class RestProductsController {
    private ProductsService productsService;

    @Autowired
    public RestProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<ProductDto> getAllProductsDto() {
        return productsService.getDtoData();
    }

}