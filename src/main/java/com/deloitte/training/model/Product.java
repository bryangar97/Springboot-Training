package com.deloitte.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author edlabastidaarce
 */
@Data
@Entity
@Table (name = "product")
public class Product {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    protected Long id;

    @Column(name="name")
    protected String name;

    @Column(name="short_description")
    protected String short_description;

    @Column(name="description")
    protected String description;

    @Column(name="price")
    protected Double prince;

    @Column(name="stock")
    protected int stock;

    @Column(name="rating")
    protected Double rating;
}
