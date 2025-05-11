package com.springproject.ProductPro.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.ProductPro.model.Product;
import com.springproject.ProductPro.service.ProductService;

@RestController
public class ProductController 
{
    @Autowired
    private ProductService service;
   
    @GetMapping("/products")
    public List<Product> getProducts()
    {
        return service.getProducts(); 
    }
    @GetMapping("/products/{prodId}")

    public Product getProductById(@PathVariable int prodId)
    {
       return service.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product p)
    {
        System.out.println(p);
       service.addProduct(p); 
    }

    @PutMapping("/products")
    public void updateProd(@RequestBody Product p)
    {
        service.updateProd(p);
    }
    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId)
    {
        service.deleteProduct(prodId);
    }

}