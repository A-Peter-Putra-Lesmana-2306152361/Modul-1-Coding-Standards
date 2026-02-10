package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    // EDIT SUPPORT
    public Product findById(String productId) {
        for (Product p : productData) {
            if (p.getProductId() != null && p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public Product update(Product updated) {
        for (int i = 0; i < productData.size(); i++) {
            Product p = productData.get(i);
            if (p.getProductId() != null && p.getProductId().equals(updated.getProductId())) {
                productData.set(i, updated);
                return updated;
            }
        }
        return null;
    }

    // DELETE SUPPORT (dipakai di branch delete-product)
    public boolean deleteById(String productId) {
        return productData.removeIf(p -> p.getProductId() != null && p.getProductId().equals(productId));
    }
}
