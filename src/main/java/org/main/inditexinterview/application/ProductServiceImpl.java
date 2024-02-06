package org.main.inditexinterview.application;

import org.main.inditexinterview.domain.model.Product;
import org.main.inditexinterview.domain.model.SortingCriteria;
import org.main.inditexinterview.infraestructure.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final List<MetricCalculator> metricCalculators;

    public ProductServiceImpl(ProductRepository productRepository, List<MetricCalculator> metricCalculators) {
        this.productRepository = productRepository;
        this.metricCalculators = metricCalculators;
    }

    public List<Product> getSortedProducts(SortingCriteria sortingCriteria) {
        List<Product> products = productRepository.getAllProducts();

        products.sort(Comparator.comparingDouble(product ->
                metricCalculators.stream()
                        .mapToDouble(calculator -> calculator.calculateMetric(product, sortingCriteria))
                        .sum()
        ));

        return products;
    }
}


