package com.deloitte.training.controllers;

import com.deloitte.training.model.Product;
import com.deloitte.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author edlabastidaarce
 */
@RestController
@RequestMapping("/product")
public class ProductApiController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(value = "/allMac")
    public @ResponseBody List<Product> findAllMac() {
        return productService.findAllMac();
    }

    @PostMapping(value = "/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @PutMapping("/edit/{id}")
    public Product edit(@RequestBody Product product, @PathVariable("id") Long id) {
        return productService.edit(product, id);
    }

}
