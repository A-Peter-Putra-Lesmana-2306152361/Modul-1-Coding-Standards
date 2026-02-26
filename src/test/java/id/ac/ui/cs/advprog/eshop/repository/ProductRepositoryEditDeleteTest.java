package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryEditDeleteTest {

    @InjectMocks
    ProductRepository productRepository;

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product();
        product1.setProductId("id-1");
        product1.setProductName("Product 1");
        product1.setProductQuantity(10);

        product2 = new Product();
        product2.setProductId("id-2");
        product2.setProductName("Product 2");
        product2.setProductQuantity(20);

        productRepository.create(product1);
        productRepository.create(product2);
    }

    @Test
    void testFindById() {
        Product found = productRepository.findById("id-1");
        assertNotNull(found);
        assertEquals("id-1", found.getProductId());
        assertEquals("Product 1", found.getProductName());
        assertEquals(10, found.getProductQuantity());
    }

    @Test
    void testUpdateProduct() {
        Product updated = new Product();
        updated.setProductId("id-1");
        updated.setProductName("Product 1 Updated");
        updated.setProductQuantity(99);

        Product result = productRepository.update(updated);
        assertNotNull(result);

        Product found = productRepository.findById("id-1");
        assertNotNull(found);
        assertEquals("Product 1 Updated", found.getProductName());
        assertEquals(99, found.getProductQuantity());

        Iterator<Product> it = productRepository.findAll();
        int count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    void testUpdateProductIfIdNotFound() {
        Product updated = new Product();
        updated.setProductId("not-exist");
        updated.setProductName("X");
        updated.setProductQuantity(1);

        Product result = productRepository.update(updated);
        assertNull(result);
    }

    @Test
    void testDeleteByIdSuccess() {
        boolean deleted = productRepository.deleteById("id-2");
        assertTrue(deleted);

        Product found = productRepository.findById("id-2");
        assertNull(found);

        Iterator<Product> it = productRepository.findAll();
        assertTrue(it.hasNext());
        assertEquals("id-1", it.next().getProductId());
        assertFalse(it.hasNext());
    }

    @Test
    void testDeleteByIdIfNotFound() {
        boolean deleted = productRepository.deleteById("not-exist");
        assertFalse(deleted);
    }
}
