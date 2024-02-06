package org.main.inditexinterview.application.interfaces;

import org.main.inditexinterview.domain.Product;
import org.main.inditexinterview.domain.SortingCriteria;

public interface MetricCalculator {
    double calculateMetric(Product product, SortingCriteria sortingCriteria);
}
