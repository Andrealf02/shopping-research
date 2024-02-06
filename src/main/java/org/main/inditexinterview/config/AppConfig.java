package org.main.inditexinterview.config;

import org.main.inditexinterview.application.*;
import org.main.inditexinterview.infraestructure.ProductRepository;
import org.main.inditexinterview.infraestructure.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class AppConfig {


    @Bean
    @Primary
    public ProductRepository productRepository() {
        return new ProductRepositoryImpl();
    }

    @Bean
    public ProductService productService(ProductRepository productRepository, List<MetricCalculator> metricCalculators) {
        return new ProductServiceImpl(productRepository, metricCalculators);
    }

    @Bean
    public MetricCalculator stockRatioMetricCalculator() {
        return new StockRatioMetricCalculator();
    }

    @Bean
    public MetricCalculator salesUnitsMetricCalculator() {
        return new SalesUnitsMetricCalculator();
    }
}
