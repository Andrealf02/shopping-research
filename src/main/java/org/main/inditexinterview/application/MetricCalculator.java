package org.main.inditexinterview.application;

import org.main.inditexinterview.domain.model.Product;
import org.main.inditexinterview.domain.model.SortingCriteria;

public interface MetricCalculator {
    double calculateMetric(Product product, SortingCriteria sortingCriteria);
}
