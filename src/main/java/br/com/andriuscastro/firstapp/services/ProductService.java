package br.com.andriuscastro.firstapp.services;

import br.com.andriuscastro.firstapp.entities.Product;
import br.com.andriuscastro.firstapp.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public  List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> prod = this.productRepository.findById(id);
        return prod.get();
    }
}
