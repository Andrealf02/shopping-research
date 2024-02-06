package org.main.inditexinterview.infraestructure;

import org.main.inditexinterview.application.interfaces.ProductService;
import org.main.inditexinterview.application.exception.ProductSortingException;
import org.main.inditexinterview.domain.Product;
import org.main.inditexinterview.infraestructure.exception.SortingException;
import org.main.inditexinterview.presentation.SortingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/sort")
    public ResponseEntity<List<Product>> sortProducts(@RequestBody SortingRequest sortingRequest, BindingResult result) throws MethodArgumentNotValidException {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            throw new MethodArgumentNotValidException(null, result);
        }

        try {
            List<Product> sortedProducts = productService.getSortedProducts(sortingRequest.getSortingCriteria());
            return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
        } catch (SortingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception | ProductSortingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
