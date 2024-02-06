package org.main.inditexinterview.application;

import org.main.inditexinterview.application.interfaces.MetricCalculator;
import org.main.inditexinterview.domain.Product;
import org.main.inditexinterview.domain.SortingCriteria;

public class SalesUnitsMetricCalculator implements MetricCalculator {
    @Override
    public double calculateMetric(Product product, SortingCriteria sortingCriteria) {
        double salesUnits = product.getSalesUnits();
        double weight = sortingCriteria.getWeights().getOrDefault("salesUnits", 1.0);
        return salesUnits * weight;
    }
}
