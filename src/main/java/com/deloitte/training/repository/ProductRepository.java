package com.deloitte.training.repository;

import com.deloitte.training.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author edlabastidaarce
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product WHERE name LIKE '%Mac%'", nativeQuery=true)
    List<Product> findAllMac();
}
