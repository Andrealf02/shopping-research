package org.main.inditexinterview.application.service;

import org.main.inditexinterview.application.MetricCalculator;
import org.main.inditexinterview.domain.model.Product;
import org.main.inditexinterview.domain.model.SortingCriteria;
import org.main.inditexinterview.infraestructure.ProductRepository;

import java.util.Comparator;
import java.util.List;

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
