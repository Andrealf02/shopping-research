package org.main.inditexinterview.infraestructure.config;

import org.main.inditexinterview.application.SalesUnitsMetricCalculator;
import org.main.inditexinterview.application.StockRatioMetricCalculator;
import org.main.inditexinterview.application.interfaces.MetricCalculator;
import org.main.inditexinterview.application.interfaces.ProductService;
import org.main.inditexinterview.application.service.ProductServiceImpl;
import org.main.inditexinterview.domain.exception.ProductValidationException;
import org.main.inditexinterview.domain.exception.StockValidationException;
import org.main.inditexinterview.infraestructure.ProductRepository;
import org.main.inditexinterview.infraestructure.ProductRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public String apiVersion() {
        return "v1";
    }

    @Bean
    @Primary
    public ProductRepository productRepository() throws ProductValidationException, StockValidationException {
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
