package com.example.demo.product;

import com.example.demo.dto.CreateProductDto;
import com.example.demo.dto.UpdateProductDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    Product createProduct(@RequestBody() @Valid CreateProductDto createProductDto) {
        return this.productService.createProduct(createProductDto);
    }

    @GetMapping("/{id}")
    Product getProduct(@PathVariable("id") long id) {
        return this.productService.getProduct(id);
    }

    @GetMapping()
    List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable("id") long id) {
        this.productService.deleteProduct(id);
    }

    @PutMapping()
    Product updateProduct(@RequestBody() @Valid UpdateProductDto updateProductDto) {
        return this.productService.updateProduct(updateProductDto);
    }
}
