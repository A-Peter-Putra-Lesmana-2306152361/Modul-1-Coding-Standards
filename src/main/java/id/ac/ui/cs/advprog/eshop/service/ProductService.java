package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> findAll();

    // EDIT
    Product findById(String productId);
    Product update(Product product);

    // DELETE (dipakai di branch delete-product)
    boolean deleteById(String productId);
}
