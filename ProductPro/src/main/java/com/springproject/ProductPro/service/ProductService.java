package com.springproject.ProductPro.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ProductPro.model.Product;
import com.springproject.ProductPro.repository.ProductRepo;


@Service

public class ProductService 
{

    @Autowired
    ProductRepo repo;
    /* List<Product> products= new ArrayList<>(Arrays.asList(new Product(101,"Laptop",90000),
                                                      new Product(102,"Iphone",50000),
                                                      new Product(103,"Mac book",120000)))  ;*/ 


    public List<Product> getProducts()
    {
        // return  products;
        return repo.findAll();
    }

    public Product getProductById(int prodId)
    {
        /*  return products.stream().
        filter(p -> p.getId()==prodId).findFirst().get();
        return products.stream().
        filter(p -> p.getId()==prodId).findFirst().orElse(new Product(100,null,0));  //or null */
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product p)
    {
    //    products.add(p);
          repo.save(p);
    }
    public void updateProd(Product p)
    {
        /*int index=0;
        for(int i=0;i<products.size();i++)
            if(products.get(i).getId()==p.getId())
            index=i;
        products.set(index,p); */
        repo.save(p);
    }
    public void deleteProduct(int prodId)
    {
        repo.deleteById(prodId);
        /*int index=0;
        for(int i=0;i<products.size();i++)
            if(products.get(i).getId()==prodId)
            index=i;
        products.remove(index); */
    }
    
}
