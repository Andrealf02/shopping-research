package org.main.inditexinterview.application;

import org.junit.jupiter.api.Test;
import org.main.inditexinterview.application.exception.ProductSortingException;
import org.main.inditexinterview.application.interfaces.MetricCalculator;
import org.main.inditexinterview.application.interfaces.ProductService;
import org.main.inditexinterview.application.service.DefaultWeightService;
import org.main.inditexinterview.application.service.ProductServiceImpl;
import org.main.inditexinterview.domain.Product;
import org.main.inditexinterview.domain.SortingCriteria;
import org.main.inditexinterview.domain.Stock;
import org.main.inditexinterview.domain.exception.StockValidationException;
import org.main.inditexinterview.infraestructure.ProductRepository;
import org.main.inditexinterview.infraestructure.exception.SortingException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Test
    public void testGetSortedProducts() throws StockValidationException, ProductSortingException {
        ProductRepository productRepository = mock(ProductRepository.class);
        List<MetricCalculator> metricCalculators = Collections.singletonList(new SalesUnitsMetricCalculator());
        ProductService productService = new ProductServiceImpl(productRepository, metricCalculators);

        List<Product> mockProducts = Arrays.asList(
                new Product(1, "Test Product 1", 20, new Stock(5, 10, 15)),
                new Product(2, "Test Product 2", 30, new Stock(10, 20, 30))
        );

        SortingCriteria sortingCriteria = new SortingCriteria("salesUnits", Collections.singletonMap("salesUnits", 1.0), new DefaultWeightService());

        when(productRepository.getAllProducts()).thenReturn(mockProducts);

        List<Product> result = productService.getSortedProducts(sortingCriteria);

        assertEquals(2, result.size());
        assertEquals("Test Product 1", result.get(0).getName());
        assertEquals("Test Product 2", result.get(1).getName());
    }

    @Test
    public void testGetSortedProductsWithSortingException(){
        ProductRepository productRepository = mock(ProductRepository.class);
        List<MetricCalculator> metricCalculators = Collections.singletonList(new SalesUnitsMetricCalculator());
        ProductService productService = new ProductServiceImpl(productRepository, metricCalculators);

        SortingCriteria sortingCriteria = new SortingCriteria("salesUnits", Collections.singletonMap("salesUnits", 1.0), new DefaultWeightService());

        when(productRepository.getAllProducts()).thenThrow(new SortingException("Sorting failed"));

        assertThrows(ProductSortingException.class, () -> productService.getSortedProducts(sortingCriteria));
    }
}
