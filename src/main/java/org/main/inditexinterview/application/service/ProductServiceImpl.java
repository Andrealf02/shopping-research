package org.main.inditexinterview.application.service;

import org.main.inditexinterview.application.exception.ProductSortingException;
import org.main.inditexinterview.application.interfaces.MetricCalculator;
import org.main.inditexinterview.application.interfaces.ProductService;
import org.main.inditexinterview.domain.Product;
import org.main.inditexinterview.domain.SortingCriteria;
import org.main.inditexinterview.domain.exception.ProductValidationException;
import org.main.inditexinterview.domain.exception.StockValidationException;
import org.main.inditexinterview.infraestructure.ProductRepository;
import org.main.inditexinterview.infraestructure.exception.SortingException;

import java.util.Comparator;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final List<MetricCalculator> metricCalculators;

    public ProductServiceImpl(ProductRepository productRepository, List<MetricCalculator> metricCalculators) {
        this.productRepository = productRepository;
        this.metricCalculators = metricCalculators;
    }

    public List<Product> getSortedProducts(SortingCriteria sortingCriteria) throws ProductSortingException {
        try {
            List<Product> products = productRepository.getAllProducts();

            products.sort(Comparator.comparingDouble(product ->
                    metricCalculators.stream()
                            .mapToDouble(calculator -> calculator.calculateMetric(product, sortingCriteria))
                            .sum()
            ));

            return products;
        } catch (SortingException e) {
            throw new ProductSortingException("Error sorting products: " + e.getMessage());
        } catch (Exception ex) {
            throw new ProductSortingException("Unexpected error: " + ex.getMessage());
        }
    }
}
