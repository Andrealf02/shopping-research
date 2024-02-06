package org.main.inditexinterview.application.interfaces;

import java.util.Map;

public interface WeightService {
    double getWeight(String metric, Map<String, Double> weights);
    void validateWeights(Map<String, Double> weights);
}
