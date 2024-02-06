package org.main.inditexinterview.application;

import org.junit.jupiter.api.Test;
import org.main.inditexinterview.application.SalesUnitsMetricCalculator;
import org.main.inditexinterview.application.StockRatioMetricCalculator;
import org.main.inditexinterview.application.service.DefaultWeightService;
import org.main.inditexinterview.domain.Product;
import org.main.inditexinterview.domain.SortingCriteria;
import org.main.inditexinterview.domain.Stock;
import org.main.inditexinterview.domain.exception.ProductValidationException;
import org.main.inditexinterview.domain.exception.StockValidationException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetricCalculatorTest {

    @Test
    public void testSalesUnitsMetricCalculator() throws StockValidationException, ProductValidationException {
        SalesUnitsMetricCalculator calculator = new SalesUnitsMetricCalculator();
        Product product = new Product(1, "Test Product", 50, new Stock(10, 20, 30));
        SortingCriteria sortingCriteria = new SortingCriteria("salesUnits", Map.of("salesUnits", 1.0), new DefaultWeightService());

        double result = calculator.calculateMetric(product, sortingCriteria);

        assertEquals(50.0, result);
    }

    @Test
    public void testStockRatioMetricCalculator() throws StockValidationException, ProductValidationException {
        StockRatioMetricCalculator calculator = new StockRatioMetricCalculator();
        Product product = new Product(2, "Test Product 2", 30, new Stock(5, 10, 15));
        SortingCriteria sortingCriteria = new SortingCriteria("stockRatio", Map.of("stockRatio", 0.5), new DefaultWeightService());

        double result = calculator.calculateMetric(product, sortingCriteria);

        assertEquals(3.0, result);
    }
}
