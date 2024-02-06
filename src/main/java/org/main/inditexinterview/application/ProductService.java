package org.main.inditexinterview.application;

import org.main.inditexinterview.domain.model.Product;
import org.main.inditexinterview.domain.model.SortingCriteria;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getSortedProducts(SortingCriteria sortingCriteria);
}

