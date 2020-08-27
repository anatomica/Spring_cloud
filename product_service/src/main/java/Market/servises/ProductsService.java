package Market.servises;

import Market.dtos.ProductDto;
import Market.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Market.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

    public Product findById(Long id) throws Exception {
        return productsRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public void deleteAll() {
        productsRepository.deleteAll();
    }

    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return productsRepository.existsById(id);
    }

    public List<ProductDto> getDtoData() {
        return productsRepository.findAllBy();
    }
}
