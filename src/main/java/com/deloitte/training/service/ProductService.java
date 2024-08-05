package com.deloitte.training.service;

import com.deloitte.training.model.Product;

import java.util.List;

/**
 * @author edlabastidaarce
 */
public interface ProductService {

    List<Product> findAllMac();

    List<Product> findAll();

    Product save(Product product);

    Product edit(Product product, Long id);

    void delete(Long id);

}
