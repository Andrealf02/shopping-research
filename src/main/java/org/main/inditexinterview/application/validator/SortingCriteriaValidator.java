package org.main.inditexinterview.application.validator;

import org.main.inditexinterview.domain.SortingCriteria;

public class SortingCriteriaValidator {
    public static void validate(SortingCriteria sortingCriteria) {
        if (sortingCriteria == null) {
            throw new IllegalArgumentException("SortingCriteria cannot be null");
        }

        if (sortingCriteria.getMetric() == null || sortingCriteria.getMetric().isEmpty()) {
            throw new IllegalArgumentException("Metric cannot be null or empty");
        }

        if (sortingCriteria.getWeights() == null || sortingCriteria.getWeights().isEmpty()) {
            throw new IllegalArgumentException("Weights cannot be null or empty");
        }
    }
}
