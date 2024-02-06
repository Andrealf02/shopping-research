package org.main.inditexinterview.application;

import org.main.inditexinterview.domain.model.Product;
import org.main.inditexinterview.domain.model.SortingCriteria;
import org.main.inditexinterview.domain.model.Stock;

public class StockRatioMetricCalculator implements MetricCalculator {
    @Override
    public double calculateMetric(Product product, SortingCriteria sortingCriteria) {
        Stock stock = product.getStock();
        double totalStock = stock.getSizeS() + stock.getSizeM() + stock.getSizeL();

        if (totalStock == 0) {
            return 0;
        }

        double stockRatio = totalStock / stock.getSizeS();
        double weight = sortingCriteria.getWeights().getOrDefault("stockRatio", 1.0);

        return stockRatio * weight;
    }
}
