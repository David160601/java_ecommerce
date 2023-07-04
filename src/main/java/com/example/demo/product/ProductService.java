package com.example.demo.product;

import com.example.demo.dto.CreateProductDto;
import com.example.demo.dto.UpdateProductDto;
import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    Product createProduct(CreateProductDto createProductDto) {
        Product newProduct = new Product();
        newProduct.setDescription(createProductDto.getDescription());
        newProduct.setQty(createProductDto.getQty());
        newProduct.setTitle(createProductDto.getTitle());
        newProduct.setPrice(createProductDto.getPrice());
        newProduct = productRepository.save(newProduct);
        return newProduct;
    }

    Product getProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product" + " id " + id + " not found"));
        return product;
    }

    List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    void deleteProduct(long id) {
        Product deleteProduct = this.getProduct(id);
        productRepository.delete(deleteProduct);
    }

    Product updateProduct(UpdateProductDto updateProductDto) {
        Product updateProduct = this.getProduct(updateProductDto.getId());
        if (updateProductDto.getTitle() != null && !updateProductDto.getTitle().isEmpty()) {
            updateProduct.setTitle(updateProductDto.getTitle());
        }
        if (updateProductDto.getDescription() != null && !updateProductDto.getDescription().isEmpty()) {
            updateProduct.setDescription(updateProductDto.getDescription());
        }
        if (updateProductDto.getPrice() != updateProduct.getPrice()) {
            updateProduct.setPrice(updateProductDto.getPrice());
        }
        if (updateProductDto.getQty() != updateProduct.getQty()) {
            updateProduct.setQty(updateProductDto.getQty());
        }
        updateProduct = this.productRepository.save(updateProduct);
        return updateProduct;
    }

}
