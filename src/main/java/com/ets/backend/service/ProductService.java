package com.ets.backend.service;

import com.ets.backend.entity.Product;
import com.ets.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Produit introuvable avec l'id : " + id
                        )
                );
    }

    public Product createProduct(Product product) {
        product.setId(null);

        if (product.getAvailable() == null) {
            product.setAvailable(true);
        }

        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);

        product.setName(productDetails.getName());
        product.setBrand(productDetails.getBrand());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        product.setImage(productDetails.getImage());
        product.setEmoji(productDetails.getEmoji());

        if (productDetails.getAvailable() == null) {
            product.setAvailable(true);
        } else {
            product.setAvailable(productDetails.getAvailable());
        }

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException(
                    "Produit introuvable avec l'id : " + id
            );
        }

        productRepository.deleteById(id);
    }
}