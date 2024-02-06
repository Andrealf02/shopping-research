package org.main.inditexinterview.application.service;

import org.main.inditexinterview.application.interfaces.WeightService;

import java.util.Map;

public class DefaultWeightService implements WeightService {
    @Override
    public double getWeight(String metric, Map<String, Double> weights) {
        return weights.getOrDefault(metric, 1.0);
    }

    @Override
    public void validateWeights(Map<String, Double> weights) {
        double sumOfWeights = weights.values().stream().mapToDouble(Double::doubleValue).sum();

        if (sumOfWeights != 100.0) {
            throw new IllegalArgumentException("Sum of weights must be equal to 100%, current sum: " + sumOfWeights);
        }
    }
}
