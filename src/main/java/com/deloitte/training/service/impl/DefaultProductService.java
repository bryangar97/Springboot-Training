package com.deloitte.training.service.impl;

import com.deloitte.training.model.Product;
import com.deloitte.training.repository.ProductRepository;
import com.deloitte.training.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author edlabastidaarce
 */
@Service
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllMac() {
        return productRepository.findAllMac();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product edit(Product product, Long id) {
        Optional<Product> currentProduct = productRepository.findById(id);
        if (currentProduct.isEmpty()) {
           throw new IllegalArgumentException("Product not found");
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
