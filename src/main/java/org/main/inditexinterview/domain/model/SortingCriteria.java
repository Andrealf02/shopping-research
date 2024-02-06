package org.main.inditexinterview.domain.model;

import java.util.Map;
import java.util.Objects;

public class SortingCriteria {
    private String metric;
    private Map<String, Double> weights;

    public SortingCriteria(String metric, Map<String, Double> weights) {
        this.metric = metric;
        this.weights = weights;
        validate();
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
        validate();
    }

    public Map<String, Double> getWeights() {
        return weights;
    }

    public void setWeights(Map<String, Double> weights) {
        this.weights = weights;
        validate();
    }

    private void validate() {
        if (metric == null || metric.isEmpty()) {
            throw new IllegalArgumentException("Metric cannot be null or empty");
        }

        if (weights == null || weights.isEmpty()) {
            throw new IllegalArgumentException("Weights cannot be null or empty");
        }
    }
}
