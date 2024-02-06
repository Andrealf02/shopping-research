package org.main.inditexinterview.domain;

import org.main.inditexinterview.application.interfaces.WeightService;
import org.main.inditexinterview.application.validator.SortingCriteriaValidator;

import java.util.Map;

public class SortingCriteria {
    private String metric;
    private Map<String, Double> weights;
    private WeightService weightService;

    public SortingCriteria(String metric, Map<String, Double> weights, WeightService weightService) {
        this.metric = metric;
        this.weights = weights;
        this.weightService = weightService;
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

    public double getWeightForMetric(String metric) {
        return weightService.getWeight(metric, weights);
    }

    private void validate() {
        SortingCriteriaValidator.validate(this);
    }
}
