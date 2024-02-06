package org.main.inditexinterview.presentation;

import org.main.inditexinterview.application.ProductService;
import org.main.inditexinterview.domain.model.Product;
import org.main.inditexinterview.domain.model.SortingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/sort")
    public ResponseEntity<List<Product>> sortProducts(@RequestBody SortingRequest sortingRequest) {
        List<Product> sortedProducts = productService.getSortedProducts(sortingRequest.getSortingCriteria());
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }
}
