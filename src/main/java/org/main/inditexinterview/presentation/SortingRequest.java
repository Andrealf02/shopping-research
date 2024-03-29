package org.main.inditexinterview.presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.main.inditexinterview.domain.SortingCriteria;


public class SortingRequest {
    private SortingCriteria sortingCriteria;

    @JsonCreator
    public SortingRequest(SortingCriteria sortingCriteria) {
        this.sortingCriteria = sortingCriteria;
        validate();
    }

    public SortingCriteria getSortingCriteria() {
        return sortingCriteria;
    }

    public void setSortingCriteria(SortingCriteria sortingCriteria) {
        this.sortingCriteria = sortingCriteria;
        validate();
    }

    private void validate() {
        if (sortingCriteria == null) {
            throw new IllegalArgumentException("SortingCriteria cannot be null");
        }
    }
}
